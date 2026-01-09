package problems.BinarySearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private final BinarySearch solution = new BinarySearch();

    @Test
    void testSearch() {
        assertEquals(4, solution.search(new int[]{-1,0,3,5,9,12}, 9));
        assertEquals(-1, solution.search(new int[]{-1,0,3,5,9,12}, 2));
        assertEquals(0, solution.search(new int[]{5}, 5));
        assertEquals(-1, solution.search(new int[]{5}, 3));
        assertEquals(2, solution.search(new int[]{1,2,3,4,5}, 3));
    }
}