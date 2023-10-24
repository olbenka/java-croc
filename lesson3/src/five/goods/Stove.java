package five.goods;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;

// плита
public class Stove extends Goods {
    private String type;

    public Stove(String name, double price, String description,
                 int weight, Dimensions dimensions, int power,
                 ImportGoods data, String type) {
        super(name, price, description, weight, dimensions, power, data);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Тип плиты: " + type);
    }
}
