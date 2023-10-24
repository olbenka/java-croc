package five.goods;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;

// холодильник
public class Refrigerator extends Goods {
    private boolean hasFreezer;
    private int freezerTemperature;

    public Refrigerator(String name, double price, String description,
                        int weight, Dimensions dimensions, int power,
                         ImportGoods data, boolean hasFreezer, int freezerTemperature) {
        super(name, price, description, weight, dimensions, power, data);
        this.hasFreezer = hasFreezer;
        this.freezerTemperature = freezerTemperature;
    }

    public boolean isHasFreezer() {
        return hasFreezer;
    }

    public void setHasFreezer(boolean hasFreezer) {
        this.hasFreezer = hasFreezer;
    }

    public int getFreezerTemperature() {
        return freezerTemperature;
    }

    public void setFreezerTemperature(int freezerTemperature) {
        this.freezerTemperature = freezerTemperature;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Наличие морозильной камеры: " + (hasFreezer ? "Да" : "Нет"));
        if (hasFreezer) {
            System.out.println("Температура морозильной камеры: " + freezerTemperature + "°C");
        }
    }
}
