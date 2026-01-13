package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DijkstrasAlgorithmTest {
    private final DijkstrasAlgorithm solution = new DijkstrasAlgorithm();

    @Test
    void testMinimumObstacles() {
        assertEquals(2, solution.minimumObstacles(new int[][]{{0,1,1},{1,1,0},{1,1,0}}));
        assertEquals(1, solution.minimumObstacles(new int[][]{{0,1},{1,0}}));
        assertEquals(0, solution.minimumObstacles(new int[][]{{0,0},{0,0}}));
        assertEquals(0, solution.minimumObstacles(new int[][]{{0,1},{0,0}}));
    }
}