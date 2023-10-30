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

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public ImportGoods getData() {
        return data;
    }

    public void setData(ImportGoods data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isImport() {
        return isImport;
    }

    public void setImport(boolean anImport) {
        isImport = anImport;
    }
}


