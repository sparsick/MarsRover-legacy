package rover;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GridTest {
    private int height = 10;
    private int width = 11;

    private Grid createGrid(int height, int width) {
        return new Grid(height, width);
    }


    @Test
    void testGridHeightAndWidth() {
        Grid grid = createGrid(height, width);
        assertThat(grid)
                .hasFieldOrPropertyWithValue("height", 10)
                .hasFieldOrPropertyWithValue("width", 11);
    }

    @Test
    void testDifferentHeightAndWidth() {
        int height = 12;
        int width = 13;
        Grid grid = createGrid(height, width);
        assertThat(grid)
                .hasFieldOrPropertyWithValue("height", 12)
                .hasFieldOrPropertyWithValue("width", 13);
    }

    @Test
    void testHasObstacleAtAndThrowsException() {
        ThrowableAssert.ThrowingCallable codeUnderTest = () -> {
            Grid grid = createGrid(height, width);
            grid.addObstacleAt(1, 1, 0);
            grid.checkForObstacle(new Point(1, 1, 0));
        };
        assertThatCode(codeUnderTest)
                .isInstanceOf(Grid.ObstacleEncountered.class)
                .hasMessage("Obstacle Encountered");
    }
}