import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    /**
     * 215. Kth Largest Element in an Array
     * Medium
     * 
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * 
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * 
     * Example 1:
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * 
     * Example 2:
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     * 
     * Constraints:
     * - 1 <= k <= nums.length <= 10^4
     * - -10^4 <= nums[i] <= 10^4
     * 
     * Approach:
     * - Min PriorityQueue
     * - if size becomes > k, poll
     * - after going through the array, we'll have the kth largest element as the min element in the PQ
     * 
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        
        // Test case 1
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        int expected = 5;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
