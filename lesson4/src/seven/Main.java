package seven;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;
import five.goods.Refrigerator;
import five.goods.Stove;
import five.goods.WashingMachine;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws OrderException {
        Goods[] goods = new Goods[3];
        goods[0] = new Refrigerator("Холодильник Samsung", 17999.1455, "Холодильник с морозильной камерой", 50,
                new Dimensions(150.5, 60.6, 70.7), 300, false,
                true, -20);

        goods[1] = new WashingMachine("Посудомоечная машина DEXP", 20799.4567, "Белого цвета", 10,
                new Dimensions(84.2, 44.4, 41.7), 200, true,
                new ImportGoods("Китай", false), false);

        goods[2] = new Stove("Плита DeLuxe", 15599.2433, "Плита из эмалированной стали", 10,
                new Dimensions(85.0, 50.0, 50.0), 200, true,
                new ImportGoods("Америка", true), "Электрическая");

        LocalDateTime dateTime1 = LocalDateTime.of(2023, 10, 30, 10, 10, 10);
        Order order = new Order(dateTime1, 3, goods, "Alzhaparova Albina Nurlanovna", "+79510336740");
        System.out.println("Если заказ собран и срок не истек:");
        order.assemblyOrder(LocalDateTime.of(2023, 10, 31, 15, 13, 55));
        if (order.isAvailable()) {
            System.out.println(order.makeNotification());
        }
        System.out.println(order.getStatus());
        System.out.println("Доступен: " + (order.isAvailable() ? "Да" : "Нет"));
        System.out.println("Если забрали:");
        order.closedOrder(LocalDateTime.of(2023, 10, 31, 16, 13, 55));
        System.out.println(order.getStatus());

    }

}
