package five;

public class Goods {
    private String name;
    private double price;
    private String description;
    private int weight;
    private Dimensions dimensions;
    private int power;

    private boolean isImport;
    private ImportGoods data;

    public Goods(String name, double price, String description,
                 int weight, Dimensions dimensions, int power, boolean isImport) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.weight = weight;
        this.dimensions = dimensions;
        this.power = power;
        this.isImport = isImport;
    }

    public Goods(String name, double price, String description,
                 int weight, Dimensions dimensions,
                 int power, boolean isImport, ImportGoods data) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.weight = weight;
        this.dimensions = dimensions;
        this.power = power;
        this.isImport = isImport;
        this.data = data;
    }

    public String ImportantInfo(){
        return  name + '\t' + price + '\n';
    }
    @Override
    public String toString() {
        return  "Название: " + name + '\n' +
                "Цена (в рублях): " + price + '\n' +
                "Описание: " + description + '\n' +
                "Вес: " + weight + " кг" + '\n' +
                "Габариты: " + dimensions.toString() + '\n' +
                "Мощность: " + power + " Вт" + '\n' +
                (isImport ? ("Информация о гарантии импортного товара:\n" + data.toString() + '\n') :
                        "Cтрана: Россия \n");
    }

    public double getPrice() {
        return price;
    }

    public boolean isImport() {
        return isImport;
    }


}


