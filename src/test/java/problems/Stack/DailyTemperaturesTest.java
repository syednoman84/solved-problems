package problems.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {
    private final DailyTemperatures solution = new DailyTemperatures();

    @Test
    void testDailyTemperatures() {
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        assertArrayEquals(new int[]{1,1,1,0}, solution.dailyTemperatures(new int[]{30,40,50,60}));
        assertArrayEquals(new int[]{1,1,0}, solution.dailyTemperatures(new int[]{30,60,90}));
        assertArrayEquals(new int[]{0}, solution.dailyTemperatures(new int[]{89}));
    }
}