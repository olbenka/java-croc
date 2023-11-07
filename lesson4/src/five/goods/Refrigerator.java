package five.goods;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;

// холодильник
public class Refrigerator extends Goods {
    private boolean hasFreezer;
    private int freezerTemperature;

    public Refrigerator(String name, double price, String description,
                        int weight, Dimensions dimensions, int power, boolean isImport,
                         ImportGoods data, boolean hasFreezer, int freezerTemperature) {
        super(name, price, description, weight, dimensions, power, isImport, data);
        this.hasFreezer = hasFreezer;
        this.freezerTemperature = freezerTemperature;
    }

    public Refrigerator(String name, double price, String description, int weight,
                        Dimensions dimensions, int power, boolean isImport,
                        boolean hasFreezer, int freezerTemperature) {
        super(name, price, description, weight, dimensions, power, isImport);
        this.hasFreezer = hasFreezer;
        this.freezerTemperature = freezerTemperature;
    }


    @Override
    public String toString() {
        String str = "Температура морозильной камеры: " + freezerTemperature + "°C" + '\n';
        return (super.toString() +
                "Наличие морозильной камеры: " + (hasFreezer ? "Да" : "Нет") + '\n' +
                (hasFreezer ? str : '\n'));
    }
}

