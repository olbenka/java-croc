package six;

public abstract class Figure {
    public abstract boolean inFigure(int x, int y);

    public abstract void move(int dx, int dy);
    @Override
    public abstract String toString();
}
