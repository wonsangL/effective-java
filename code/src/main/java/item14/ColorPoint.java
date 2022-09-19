package item14;

import java.util.Comparator;

public class ColorPoint extends Point {
    private String color;

    private static final Comparator<ColorPoint> COMPARATOR = Comparator.comparing((ColorPoint point) -> point.getDistance())
            .thenComparing(point -> point.color);

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public int compareTo(Point other) {
        int result = super.compareTo(other);

        if (other instanceof ColorPoint) {
            return result == 0 ? this.color.compareTo(((ColorPoint)other).color) : result;
        }

        return result;
    }

    public int compareTo(ColorPoint point) {
        return COMPARATOR.compare(this, point);
    }

    @Override
    public String toString() {
        return "ColorPoint(x=" + super.x + ", y=" + super.y + ", color=" + this.color + ")";
    }
}
