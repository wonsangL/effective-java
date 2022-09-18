package item14;

public class Point implements Comparable<Point> {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        if (this == other) {
            return 0;
        }

        Double distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        Double otherDistance = Math.sqrt(Math.pow(other.x, 2) + Math.pow(other.y, 2));

        return distance.compareTo(otherDistance);
    }

    @Override
    public String toString() {
        return "Point(x=" + this.x + ", y=" + this.y + ")";
    }
}
