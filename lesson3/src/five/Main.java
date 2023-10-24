package five;

import five.goods.WashingMachine;
import five.goods.Refrigerator;
import five.goods.Stove;

public class Main {
    public static void main(String[] args) {
        Refrigerator[] refrigerators = new Refrigerator[2];
        refrigerators[0] = new Refrigerator("Холодильник Samsung", 17999, "Холодильник с морозильной камерой", 50,
                new Dimensions(150, 60, 70), 300,
                new ImportGoods("Россия", true), true, -20 );
        refrigerators[1] = new Refrigerator("Холодильник DEXP", 20000, "Холодильник с морозильной камерой", 50,
                new Dimensions(45.4, 128.5, 70), 300,
                new ImportGoods("Китай", true), true, -20 );

        WashingMachine[] machines = new WashingMachine[2];
        machines[0] = new WashingMachine("Посудомоечная машина DEXP", 20799, "Белого цвета", 10,
                new Dimensions(84, 44, 41), 200,
                new ImportGoods("Китай", false), false);
        machines[1] = new WashingMachine("Посудомоечная машина Midea", 29499, "Серого цвета", 10,
                new Dimensions(84, 44, 41), 200,
                new ImportGoods("Китай", true), true);

        Stove[] stoves = new Stove[2];
        stoves[0] = new Stove("Плита DeLuxe", 15599, "Плита из эмалированной стали", 10,
                new Dimensions(85, 50, 50), 200,
                new ImportGoods("Америка", true), "Электрическая");
        stoves[1] = new Stove("Плита Darina", 10599, "серого цвета", 10,
                new Dimensions(70, 40, 50), 200,
                new ImportGoods("Россия", true), "Индукционная");

        // вывод всей информации
        for (Refrigerator refs : refrigerators) {
            refs.printInfo();
            System.out.println("--------");
        }
        for (WashingMachine machine : machines) {
            machine.printInfo();
            System.out.println("--------");
        }
        for (Stove stove : stoves) {
            stove.printInfo();
            System.out.println("--------");
        }
    }
}

// здесь не совсем совпадают с реальностью размеры и цены, но я частично вдохновлялась товарами у dns