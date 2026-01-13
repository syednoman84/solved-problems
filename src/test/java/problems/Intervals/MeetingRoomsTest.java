package problems.Intervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsTest {
    private final MeetingRooms solution = new MeetingRooms();

    @Test
    void testCanAttendMeetings() {
        assertFalse(solution.canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}}));
        assertTrue(solution.canAttendMeetings(new int[][]{{5,8},{9,15}}));
        assertTrue(solution.canAttendMeetings(new int[][]{{7,10},{2,4}}));
        assertTrue(solution.canAttendMeetings(new int[][]{}));
    }
}