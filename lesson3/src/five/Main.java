package five;

import five.goods.WashingMachine;
import five.goods.Refrigerator;
import five.goods.Stove;

public class Main {
    public static void main(String[] args) {
        Goods[] goods = new Goods[3];
        goods[0] = new Refrigerator("Холодильник Samsung", 17999.1, "Холодильник с морозильной камерой", 50,
                new Dimensions(150.5, 60.6, 70.7), 300, false,
                true, -20 );

        goods[1] = new WashingMachine("Посудомоечная машина DEXP", 20799.0, "Белого цвета", 10,
                new Dimensions(84.2, 44.4, 41.7), 200, true,
                new ImportGoods("Китай", false), false);

        goods[2] = new Stove("Плита DeLuxe", 15599.2, "Плита из эмалированной стали", 10,
                new Dimensions(85.0, 50.0, 50.0), 200, true,
                new ImportGoods("Америка", true), "Электрическая");
        for (Goods good: goods) {
            System.out.println(good.toString());
        }
        System.out.println("Если нужно отобрать только импортные товары: ");
        for (Goods good: goods) {
            if (good.isImport()){
                System.out.println(good.toString());
            }
        }

    }
}

// здесь не совсем совпадают с реальностью размеры и цены, но я частично вдохновлялась товарами у dns
