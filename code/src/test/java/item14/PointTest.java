package item14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void compareWithBiggerPointTest() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);

        assertEquals(-1, Math.signum(a.compareTo(b)));
    }

    @Test
    void compareWithSmallerPointTest() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);

        assertEquals(1, Math.signum(b.compareTo(a)));
    }

    @Test
    void compareWithEqualPointTest() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 1);

        assertEquals(0, Math.signum(b.compareTo(a)));
    }
}