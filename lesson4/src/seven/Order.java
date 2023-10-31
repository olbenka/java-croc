package seven;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

import five.Goods;
public class Order implements Notification, Pickup {
    private String orderNumber;
    private LocalDateTime orderDate;
    private LocalDateTime assemblyDate;
    private LocalDateTime receiptDate;
    private Goods[] order;
    private int orderCount;
    private String clientName;
    private String clientNumber;
    private OrderStatus status;
    public Order(LocalDateTime orderDate, int orderCount, Goods[] order,
                 String clientName, String clientNumber) throws OrderException {
        this.orderNumber = makeOrderNumber(orderDate, clientNumber);
        this.orderDate = orderDate;
        this.assemblyDate = null;
        this.receiptDate = null;
        this.orderCount = orderCount;
        if (orderCount > 75){
            throw new OrderException("В заказе не может быть больше 75 позиций.");
        }
        this.order = order;
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

    public String makeNotification() {
        // имя
        String[] name = clientName.split(" ");
        String firstName = name[1];
        // дата
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime plusWeeks = assemblyDate.plusWeeks(2);
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

        return String.format("Уважаемый %s!\n" +
                        "Рады сообщить, что Ваш заказ %s готов к выдаче.\n" +
                        "Состав заказа:\n%s\n" +
                        "Сумма к оплате: %s\n" +
                        "Срок хранения заказа %s.\n" +
                        "С наилучшими пожеланиями, магазин “Кошки и картошки”",
                firstName, orderNumber, goodsList.toString(), formatterNumber.format(orderSum),
                formatterDate.format(plusWeeks));
    }

    public boolean isAvailable() throws OrderException {
        int result = assemblyDate.compareTo(LocalDateTime.now());
        if (result > 0){
            return false;
        }
        LocalDateTime plusWeeks = assemblyDate.plusWeeks(2);
        result = plusWeeks.compareTo(LocalDateTime.now());
        if (result > 0){
            return true;
        } else {
            throw new OrderException("Срок хранения товара истек.");
        }
    }

    public void assemblyOrder(LocalDateTime date) {
        if (status == OrderStatus.CREATED){
            assemblyDate = date;
            status = OrderStatus.COLLECTED;
        }
    }

    public void closedOrder(LocalDateTime date) {
        if (status == OrderStatus.COLLECTED) {
            receiptDate = date;
            status = OrderStatus.CLOSED;
        }
    }

    public void updateStatus() {
        if (status == OrderStatus.COLLECTED) {
            LocalDateTime plusWeeks = assemblyDate.plusWeeks(2);
            int result = plusWeeks.compareTo(LocalDateTime.now());
            if (result < 0){
                status = OrderStatus.EXPIRED;
            }
        }
    }

    public OrderStatus getStatus() {
        return status;
    }
}
