package five;

public class Dimensions {
    private double height;
    private double width;
    private double depth;

    public Dimensions(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }


    @Override
    public String toString() {
        return height + "x" + width + "x" + depth + " см";
    }
}
