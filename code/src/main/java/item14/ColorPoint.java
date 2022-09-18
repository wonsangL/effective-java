package item14;

public class ColorPoint extends Point {
    private String color;

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

    @Override
    public String toString() {
        return "ColorPoint(x=" + super.x + ", y=" + super.y + ", color=" + this.color + ")";
    }
}
