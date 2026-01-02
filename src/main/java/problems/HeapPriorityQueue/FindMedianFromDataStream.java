import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     * 295. Find Median from Data Stream
     * Hard
     * 
     * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
     * 
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * 
     * Implement the MedianFinder class:
     * - MedianFinder() initializes the MedianFinder object.
     * - void addNum(int num) adds the integer num from the data stream to the data structure.
     * - double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
     * 
     * Example 1:
     * Input: ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
     * [[], [1], [2], [], [3], []]
     * Output: [null, null, null, 1.5, null, 2.0]
     * 
     * Constraints:
     * - -10^5 <= num <= 10^5
     * - There will be at least one element in the data structure before calling findMedian.
     * - At most 5 * 10^4 calls will be made to addNum and findMedian.
     * 
     * Approach:
     * - Use two heaps, one max heap(smallerList), other min heap(largerList)
     * - if smallList is not empty and first element is less than equal to num then add num to largeList
     * - else add num to smallList
     * - balance the size of both the heaps
     *   - so that smallList never become more than 1 + size of largeList
     *   - largeList's size always remain less or equal to the size of smallList
     * 
     * Time Complexity:
     * - add operation: O(logN)
     * - find median operation: O(1)
     * 
     * Space Complexity:
     * - add operation: O(1)
     * - find median operation: O(1)
     */
    int size;
    PriorityQueue<Integer> smallList;
    PriorityQueue<Integer> largeList;
    
    public FindMedianFromDataStream() {
        smallList = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        largeList = new PriorityQueue<>(); // minHeap
    }
    
    public void addNum(int num) {
        
        if(!smallList.isEmpty() && smallList.peek() <= num)
            largeList.offer(num);
        else
            smallList.offer(num);
        // size balance
        if(smallList.size() > largeList.size()+1) {
            int tmp = smallList.poll();
            largeList.offer(tmp);
        } else if(smallList.size() < largeList.size()) {
            int tmp = largeList.poll();
            smallList.offer(tmp);
        }
        size++;
    }
    
    public double findMedian() {

        if(size % 2 != 0) {
            return (double) smallList.peek();
        } else {
            return (double) (smallList.peek() + largeList.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream solution = new FindMedianFromDataStream();
        
        // Test case 1
        solution.addNum(1);
        double result1 = solution.findMedian();
        double expected1 = 1.0;
        String status1 = Math.abs(result1 - expected1) < 0.0001 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
        
        solution.addNum(2);
        double result2 = solution.findMedian();
        double expected2 = 1.5;
        String status2 = Math.abs(result2 - expected2) < 0.0001 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + expected2 + ", Got: " + result2 + " [" + status2 + "]");
    }
}
