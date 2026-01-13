package problems.Intervals;

/**
 * [919 · Meeting Rooms II](https://www.lintcode.com/problem/919/)
 * Medium
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * Note: (0,8),(8,10) is not conflict at 8
 *
 * Example 1:
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 *
 * Example 2:
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation: Only need one meeting room
 *
 * Approach:
 * - Sort starting time and ending time separately
 * - Two pointers one from traversing through the start[] and the other through the end[]
 * - keep track of max count(it would have the answer)
 * - if pointer pointing at start < pointer pointing at end
 *   - increment the count & move the start pointer forward
 * - else
 *   - decrement the count & move the end pointer forward
 *
 * Complexity Analysis:
 * - Time Complexity: O(nlogn)
 * - Space Complexity: O(n)
 */
import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(end);
        Arrays.sort(start);

        int startPointer = 0, endPointer = 0;
        int usedRooms = 0, count = 0;

        while (startPointer < intervals.length) {
            if (start[startPointer] < end[endPointer]) {
                count += 1;
                startPointer += 1;
            }
            else {
                count -= 1;
                endPointer += 1;
            }
            usedRooms = Math.max(usedRooms, count);
        }

        return usedRooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        
        // Test case 2: intervals = [(9,10),(4,9),(4,17)]
        int[][] intervals2 = {{9,10},{4,9},{4,17}};
        int result2 = solution.minMeetingRooms(intervals2);
        int expected2 = 3;
        String status2 = result2 == expected2 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + expected2 + ", Got: " + result2 + " [" + status2 + "]");
    }
}
