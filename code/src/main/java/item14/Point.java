package item14;

public class Point implements Comparable<Point> {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Double getDistance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    @Override
    public int compareTo(Point other) {
        if (this == other) {
            return 0;
        }

        return this.getDistance().compareTo(other.getDistance());
    }

    @Override
    public String toString() {
        return "Point(x=" + this.x + ", y=" + this.y + ")";
    }
}
