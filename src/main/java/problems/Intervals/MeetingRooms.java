/**
 * [920 · Meeting Rooms](https://www.lintcode.com/problem/920/)
 * Easy
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * Note: (0,8),(8,10) is not conflict at 8
 *
 * Example 1:
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation: (0,30), (5,10) and (0,30),(15,20) will conflict
 *
 * Example 2:
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation: Two times will not conflict
 *
 * Approach:
 * - Sort intervals by end time
 * - Check if any two consecutive intervals overlap
 * - If they do, return false
 * - If no overlaps found, return true
 *
 * Complexity Analysis:
 * - Time Complexity: O(nlogn)
 * - Space Complexity: O(1)
 */
import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals.length == 1)
            return true;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int[] next = intervals[intervals.length-1];
        for(int i = intervals.length-2; i >= 0; i--) {
            int[] current = intervals[i];
            if(current[1] > next[0] && current[1] <= next[1])
                return false;
            next = current;
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        
        // Test case 1: intervals = [(5,8),(9,15)]
        int[][] intervals1 = {{5, 8}, {9, 15}};
        boolean result1 = solution.canAttendMeetings(intervals1);
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
