package five.goods;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;

//стиральная машина
public class WashingMachine extends Goods {
    private boolean hasDryer;

    public WashingMachine(String name, double price, String description,
                          int weight, Dimensions dimensions, int power,
                           ImportGoods data, boolean hasDryer) {
        super(name, price, description, weight, dimensions, power, data);
        this.hasDryer = hasDryer;
    }

    public boolean isHasDryer() {
        return hasDryer;
    }

    public void setHasDryer(boolean hasDryer) {
        this.hasDryer = hasDryer;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Наличие сушилки: " + (hasDryer ? "Да" : "Нет"));
    }
}
