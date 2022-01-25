package rectangles;

import java.util.Optional;

public class Rectangle {
    private final Point topLeft;
    private final Point topRight;
    private final Point bottomLeft;
    private final Point bottomRight;

    public Rectangle(Point topLeft, int width, int height) {
        if (topLeft.getX() < 0 || topLeft.getY() < 0 || width < 0 || height < 0) {
            throw new IllegalArgumentException("parameters must be non-negative");
        }
        this.topLeft = topLeft;
        this.topRight = new Point(topLeft.getX() + width, topLeft.getY());
        this.bottomLeft = new Point(topLeft.getX(), topLeft.getY() + height);
        this.bottomRight = new Point(topLeft.getX() + width, topLeft.getY() + height);
    }

    public Rectangle(Point p1, Point p2) {
        this(new Point(Math.min(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY())),
                Math.max(p1.getX(), p2.getX()) - Math.min(p1.getX(), p2.getX()),
                Math.max(p1.getY(), p2.getY()) - Math.min(p1.getY(), p2.getY()));
    }

    public Rectangle(int width, int height) {
        this(new Point(0, 0), width, height);
    }

    private boolean contains(Point point) {
        return (this.topLeft.getX() <= point.getX() &&
                point.getX() <= this.topRight.getX() &&
                this.topLeft.getY() <= point.getY() &&
                point.getY() <= this.bottomLeft.getY()
        );
    }

    public int getWidth() {
        return this.topRight.getX() - this.topLeft.getX();
    }

    public int getHeight() {
        return this.bottomLeft.getY() - this.topLeft.getY();
    }

    public Rectangle setWidth(int newWidth) {
        if (newWidth < 0) {
            throw new IllegalArgumentException();
        } else return new Rectangle(this.topLeft, newWidth, this.getHeight());
    }

    public Rectangle setHeight(int newHeight) {
        if (newHeight < 0) {
            throw new IllegalArgumentException();
        } else return new Rectangle(this.topLeft, this.getWidth(), newHeight);
    }

    public Point getTopLeft() {
        return this.topLeft;
    }

    public Point getTopRight() {
        return this.topRight;
    }

    public Point getBottomLeft() {
        return this.bottomLeft;
    }

    public Point getBottomRight() {
        return this.bottomRight;
    }

    public int area() {
        return this.getWidth() * this.getHeight();
    }

    public boolean intersects(Rectangle other) {
        return intersection(other).isPresent();
    }

    public Optional<Rectangle> intersection(Rectangle other) {
        int left1 = topLeft.getX();
        int left2 = other.topLeft.getX();
        int bottom1 = bottomLeft.getY();
        int bottom2 = other.bottomLeft.getY();
        int right1 = topRight.getX();
        int right2 = other.topRight.getX();
        int top1 = topLeft.getY();
        int top2 = other.topLeft.getY();
        int newLeft = Math.max(left1, left2);
        int newBottom = Math.min(bottom1, bottom2);
        int newRight = Math.min(right1, right2);
        int newTop = Math.max(top1, top2);
        if (newLeft > newRight || newTop > newBottom) {
            return Optional.empty();
        }
        int width = newRight - newLeft;
        int height = newBottom - newTop;
        Point point = new Point(newLeft,newTop);
        return Optional.of(new Rectangle(point, width, height));
    }
}
