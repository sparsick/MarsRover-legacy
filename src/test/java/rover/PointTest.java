package rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointTest {

	Point createPoint(int x, int y, int z) {
		return new Point(x, y, z);
	}

	@ParameterizedTest
	@CsvSource({"0, 0, 0", "1, 0, 0", "0, 2, 0", "0, 2, 5"})
	void testPoints(int x, int y, int z) {
		assertThat(createPoint(x, y, z))
				.hasFieldOrPropertyWithValue("x", x)
				.hasFieldOrPropertyWithValue("y", y)
				.hasFieldOrPropertyWithValue("z", z);
	}

	@Test
	void testEqual() {
		Point point1 = createPoint(0, 2, 5);
		Point point2 = createPoint(0, 2, 5);
		assertTrue(point1.equals(point2));
	}
}
