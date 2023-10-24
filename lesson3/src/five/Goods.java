package five;

public class Goods {
    private String name;
    private double price;
    private String description;
    private int weight;
    private Dimensions dimensions;
    private int power;
    private ImportGoods data;


    public Goods(String name, double price, String description,
                 int weight, Dimensions dimensions,
                 int power, ImportGoods data) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.weight = weight;
        this.dimensions = dimensions;
        this.power = power;
        this.data = data;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Цена (в рублях): " + price);
        System.out.println("Описание: " + description);
        System.out.println("Вес: " + weight + " кг");
        System.out.println("Габариты: " + dimensions.toString());
        System.out.println("Мощность: " + power + " Вт");
        if (!(data.getCountry()).equals("Россия")){
            System.out.println("Информация о гарантии импортного товара: " + data.toString());
        } else {
            System.out.println("Страна-производитель: " + data.getCountry());
        }
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


}

