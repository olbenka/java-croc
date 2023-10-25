package six;

public class Annotation {
    private Figure figure;
    private String description;

    public Figure getFigure() {
        return figure;
    }

    public String getDescription() {
        return description;
    }

    public Annotation(Figure figure, String description) {
        this.figure = figure;
        this.description = description;
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + description;
    }
}
