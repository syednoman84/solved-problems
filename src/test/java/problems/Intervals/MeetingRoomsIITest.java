package problems.Intervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsIITest {
    private final MeetingRoomsII solution = new MeetingRoomsII();

    @Test
    void testMinMeetingRooms() {
        assertEquals(2, solution.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        assertEquals(1, solution.minMeetingRooms(new int[][]{{2,7}}));
        assertEquals(2, solution.minMeetingRooms(new int[][]{{9,10},{4,9},{4,17}}));
        assertEquals(0, solution.minMeetingRooms(new int[][]{}));
    }
}