package rover;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {
    private Grid grid;
    private int height = 10;
    private int width = 11;

    private void createGrid(int height, int width) {
        grid = new Grid(height, width);
    }


    @Test
    void testGridHeightAndWidth() {
        createGrid(height, width);
        assertEquals(10, grid.getHeight());
        assertEquals(11, grid.getWidth());
    }

    @Test
    void testDifferentHeightAndWidth() {
        int height = 12;
        int width = 13;
        createGrid(height, width);
        assertEquals(12, grid.getHeight());
        assertEquals(13, grid.getWidth());
    }

    @Test
    void testHasObstacleAtAndThrowsException() {
        ThrowableAssert.ThrowingCallable codeUnderTest = () -> {
            createGrid(height, width);
            grid.addObstacleAt(1, 1, 0);
            grid.checkForObstacle(new Point(1, 1, 0));
        };
        assertThatCode(codeUnderTest)
                .isInstanceOf(Grid.ObstacleEncoutered.class)
                .hasMessage("Obstacle Encoutered");
    }
}
