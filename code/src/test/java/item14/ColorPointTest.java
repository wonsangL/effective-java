package item14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColorPointTest {
    /**
     * 해당 테스트는 실패하도록 되어있다.
     * <p>
     *     {@code compareTo}가 추이성이 지켜졌다면, a와 b가 동일하고 b와 c가 동일하기 때문에 a와 c도 동일해야하지만<br>
     *     아래 예제에서는 a와 c를 비교할 경우 두 객체는 동일하지 않다는 결과가 반환된다.
     * </p>
     */
    @Test
    void compareTransitivityErrorTest() {
        ColorPoint a = new ColorPoint(1, 1, "red");
        Point b = new Point(1, 1);
        ColorPoint c = new ColorPoint(1, 1, "blue");

        float aCompareToB = Math.signum(a.compareTo(b));
        float bCompareToC = Math.signum(b.compareTo(c));
        float aCompareToC = Math.signum(a.compareTo(c));

        assertEquals(0, aCompareToB);
        assertEquals(0, bCompareToC);
        assertEquals(0, aCompareToC);
    }

    /**
     * 해당 테스트에서는 가운데 {@link Point} 객체로 인하여 정렬이 예상과 다르게 동작하는 것을 보여준다.
     * <p>
     *     기대하는 결과는 적어도 두 {@link ColorPoint} 객체는 올바르게 정렬(green -> red)되는 것이지만<br>
     *     아래 코드에서는 정렬되지 않는다.
     * </p>
     */
    @Test
    void sortingWithTransitivityError() {
        List<Point> points = new ArrayList<>();

        points.add(new ColorPoint(1, 1, "red"));
        points.add(new Point(1, 1));
        points.add(new ColorPoint(1, 1, "green"));

        Collections.sort(points);

        points.forEach(System.out::println);
    }
}