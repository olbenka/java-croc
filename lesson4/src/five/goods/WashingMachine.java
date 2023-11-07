package five.goods;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;

//стиральная машина
public class WashingMachine extends Goods {
    private boolean hasDryer;

    public WashingMachine(String name, double price, String description,
                          int weight, Dimensions dimensions, int power, boolean isImport,
                           ImportGoods data, boolean hasDryer) {
        super(name, price, description, weight, dimensions, power, isImport, data);
        this.hasDryer = hasDryer;
    }

    public WashingMachine(String name, double price, String description,
                          int weight, Dimensions dimensions, int power, boolean isImport,
                          boolean hasDryer) {
        super(name, price, description, weight, dimensions, power, isImport);
        this.hasDryer = hasDryer;
    }

    @Override
    public String toString() {
        return (super.toString() +
                "Наличие сушилки: " + (hasDryer ? "Да" : "Нет") + '\n');
    }

}
