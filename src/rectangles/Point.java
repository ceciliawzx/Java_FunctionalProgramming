package rectangles;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0,0);
    }

    public Point(int x) {
        this (x, 0);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Point setX(int newX) {
        if (newX < 0) {
            throw new IllegalArgumentException("parameter must be non-negative");
        } else return new Point(newX, this.y);
    }

    public Point setY(int newY) {
        if (newY < 0) {
            throw new IllegalArgumentException("parameter must be non-negative");
        } else return new Point(this.x, newY);
    }

    public boolean isLeftOf(Point other) {
        return this.x < other.x;
    }

    public boolean isRightOf(Point other) {
        return this.x > other.x;
    }

    public boolean isAbove(Point other) {
        return this.y < other.y;
    }

    public boolean isBelow(Point other) {
        return this.y > other.y;
    }

    public Point add(Point vector) {
        return new Point(this.x + vector.x, this.y + vector.y);
    }
}
