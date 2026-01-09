package problems.HeapPriorityQueue;

import java.util.PriorityQueue;

public class kthLargestElementInAStream {
    /**
     * 703. Kth Largest Element in a Stream
     * Easy
     * 
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * 
     * Implement KthLargest class:
     * - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
     * - int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
     * 
     * Example 1:
     * Input: ["KthLargest", "add", "add", "add", "add", "add"]
     * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
     * Output: [null, 4, 5, 5, 8, 8]
     * 
     * Constraints:
     * - 1 <= k <= 10^4
     * - 0 <= nums.length <= 10^4
     * - -10^4 <= nums[i] <= 10^4
     * - -10^4 <= val <= 10^4
     * - At most 10^4 calls will be made to add.
     * - It is guaranteed that there will be at least k elements in the array when you search for the kth element.
     * 
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    PriorityQueue<Integer> pq;
    int k;
    
    public kthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num: nums)
            pq.offer(num);
        
        while(pq.size() > k)
            pq.poll();
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k)
            pq.poll();
        
        return pq.peek();
    }

    public static void main(String[] args) {
        kthLargestElementInAStream solution = new kthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        
        // Test case 1
        int result = solution.add(3);
        int expected = 4;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
