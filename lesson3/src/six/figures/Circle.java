package six.figures;

import six.Figure;
import six.Movable;

public class Circle extends Figure implements Movable {
    private int x0;
    private int y0;
    private int radius;

    public Circle(int x0, int y0, int radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    @Override
    public boolean inFigure(int x, int y) {
        return Math.pow(x - x0, 2) + Math.pow(y - y0, 2) <= Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle (" + x0 + ", " + y0 + "), " + radius;
    }

    @Override
    public void move(int dx, int dy){
        x0 += dx;
        y0 += dy;
    }
}
