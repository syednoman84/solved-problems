package problems.Intervals;

/*
You are given a 2D integer array intervals, where intervals[i] = [left_i, right_i] represents the ith interval starting at left_i and ending at right_i (inclusive).

You are also given an integer array of query points queries. The result of query[j] is the length of the shortest interval i such that left_i <= queries[j] <= right_i. If no such interval exists, the result of this query is -1.

Return an array output where output[j] is the result of query[j].

Note: The length of an interval is calculated as right_i - left_i + 1.

Example 1:

Input: intervals = [[1,3],[2,3],[3,7],[6,6]], queries = [2,3,1,7,6,8]

Output: [2,2,3,5,1,-1]

Explanation:

    Query = 2: The interval [2,3] is the smallest one containing 2, it's length is 2.
    Query = 3: The interval [2,3] is the smallest one containing 3, it's length is 2.
    Query = 1: The interval [1,3] is the smallest one containing 1, it's length is 3.
    Query = 7: The interval [3,7] is the smallest one containing 7, it's length is 5.
    Query = 6: The interval [6,6] is the smallest one containing 6, it's length is 1.
    Query = 8: There is no interval containing 8.

Constraints:

    1 <= intervals.length <= 1000
    1 <= queries.length <= 1000
    1 <= left_i <= right_i <= 10000
    1 <= queries[j] <= 10000
 */

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        
        // Create array of query indices sorted by query value
        Integer[] queryIndices = new Integer[queries.length];
        for (int j = 0; j < queries.length; j++) {
            queryIndices[j] = j;
        }
        Arrays.sort(queryIndices, (a, b) -> Integer.compare(queries[a], queries[b]));
        
        int i = 0;
        for (int idx : queryIndices) {
            int q = queries[idx];
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumIntervalToIncludeEachQuery solution = new MinimumIntervalToIncludeEachQuery();
        
        // Test the failing case
        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
        int[] queries = {2,19,5};
        int[] result = solution.minInterval(intervals, queries);
        
        System.out.print("Result: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(",");
        }
        // Test the third case
        int[][] intervals2 = {{1,4},{2,4},{3,6},{4,4}};
        int[] queries2 = {5};
        int[] result2 = solution.minInterval(intervals2, queries2);
        
        System.out.print("Result2: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}