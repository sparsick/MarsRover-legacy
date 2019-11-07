package rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointTest {

    private static Stream<TestPoint> testPoints() {
        return Stream.of(
                new TestPoint(0, 0, 0),
                new TestPoint(1, 0, 0),
                new TestPoint(0, 2, 0),
                new TestPoint(0, 2, 5));
    }

    Point createPoint(int x, int y, int z) {
        return new Point(x, y, z);
    }

    @ParameterizedTest
    @MethodSource("testPoints")
    void testPoints(TestPoint tp) {
        assertThat(createPoint(tp.x, tp.y, tp.z))
                .hasFieldOrPropertyWithValue("x", tp.x)
                .hasFieldOrPropertyWithValue("y", tp.y)
                .hasFieldOrPropertyWithValue("z", tp.z);
    }

    @Test
    void testEqual() {
        Point point1 = createPoint(0, 2, 5);
        Point point2 = createPoint(0, 2, 5);
        //noinspection SimplifiableJUnitAssertion
        assertTrue(point1.equals(point2));
    }

    private static class TestPoint {
        int x, y, z;

        TestPoint(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "TestPoint{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
}
