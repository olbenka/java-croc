package seven;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

import five.Goods;
public class Order implements Notification, Pickup {
    final private String orderNumber;
    final private LocalDateTime orderCreatedDate;
    private LocalDateTime orderCollectedDate;
    private LocalDateTime orderClosedDate;
    final private Goods[] order;
    final private String clientName;
    final private String clientNumber;
    private OrderStatus status;
    public Order(LocalDateTime orderCreatedDate, Goods[] order,
                 String clientName, String clientNumber) throws ExceedsMaximumArraySizeExeption {
        this.orderNumber = makeOrderNumber(orderCreatedDate, clientNumber);
        this.orderCreatedDate = orderCreatedDate;
        this.orderCollectedDate = null;
        this.orderClosedDate = null;
        this.order = order;
        if (order.length > 75){
            throw new ExceedsMaximumArraySizeExeption("В заказе не может быть больше 75 позиций.");
        }
        this.clientName = clientName;
        this.clientNumber = clientNumber;
        this.status = OrderStatus.CREATED;
    }

    public String makeOrderNumber(LocalDateTime orderDate, String clientNumber){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String date = orderDate.format(formatter);
        String number = clientNumber.substring(clientNumber.length() - 4);
        return date + number;
    }

    @Override
    public String makeNotification() {
        // имя
        String[] name = clientName.split(" ");
        String firstName = name[1];
        // дата
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime plus2Weeks = orderCollectedDate.plusWeeks(2);
        // сумма заказа и вывод товаров с важной информацией
        StringBuilder goodsList = new StringBuilder();
        double orderSum = 0.0;
        for (Goods good : order) {
            goodsList.append(good.ImportantInfo());
            orderSum += good.getPrice();
        }
        goodsList.deleteCharAt(goodsList.length()-1);
        // сумма заказа
        NumberFormat formatterNumber = NumberFormat.getCurrencyInstance(new Locale("ru", "RU"));

        return String.format("Уважаемый %s!\n\n" +
                        "Рады сообщить, что Ваш заказ %s готов к выдаче.\n\n" +
                        "Состав заказа:\n%s\n\n" +
                        "Сумма к оплате: %s\n\n" +
                        "Срок хранения заказа %s.\n\n" +
                        "С наилучшими пожеланиями, магазин “Кошки и картошки”",
                firstName, orderNumber, goodsList.toString(), formatterNumber.format(orderSum),
                formatterDate.format(plus2Weeks));
    }

    @Override
    public boolean isAvailable() throws OrderExceededStoragePeriodExeption {
        if (orderCollectedDate == null) {
            return false;
        }
        boolean result = orderCollectedDate.isAfter(LocalDateTime.now());
        if (result){
            return false;
        }
        LocalDateTime plusWeeks = orderCollectedDate.plusWeeks(2);
        result = plusWeeks.isAfter(LocalDateTime.now());
        if (result) {
            return true;
        } else {
            throw new OrderExceededStoragePeriodExeption("Срок хранения товара истек.");
        }
    }

    @Override
    public void assemblyAnOrder(LocalDateTime date) {
        if (status == OrderStatus.CREATED){
            orderCollectedDate = date;
            status = OrderStatus.COLLECTED;
        }
    }

    @Override
    public void issuingAnOrder(LocalDateTime date) {
        if (status == OrderStatus.COLLECTED) {
            orderClosedDate = date;
            status = OrderStatus.CLOSED;
        }
    }

    @Override
    public void expireAnOrder() {
        if (status == OrderStatus.COLLECTED) {
            LocalDateTime plusWeeks = orderCollectedDate.plusWeeks(2);
            boolean result = plusWeeks.isBefore(LocalDateTime.now());
            if (result){
                status = OrderStatus.EXPIRED;
            }
        }
    }

    public OrderStatus getStatus() {
        return status;
    }
}
