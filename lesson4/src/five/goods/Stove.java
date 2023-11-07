package five.goods;

import five.Dimensions;
import five.Goods;
import five.ImportGoods;

// плита
public class Stove extends Goods {
    private String type;

    public Stove(String name, double price, String description,
                 int weight, Dimensions dimensions, int power, boolean isImport,
                 ImportGoods data, String type) {
        super(name, price, description, weight, dimensions, power, isImport, data);
        this.type = type;
    }
    public Stove(String name, double price, String description,
                 int weight, Dimensions dimensions, int power, boolean isImport,
                 String type) {
        super(name, price, description, weight, dimensions, power, isImport);
        this.type = type;
    }

    @Override
    public String toString() {
        return (super.toString() + "Тип плиты: " + type + '\n');
    }
}
