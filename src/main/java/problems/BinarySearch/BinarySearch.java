package problems.BinarySearch;

/*
 * 704. Binary Search
 * Easy
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index.
 * Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * Constraints:
 * - 1 <= nums.length <= 104
 * - -104 < nums[i], target < 104
 * - All the integers in nums are unique.
 * - nums is sorted in ascending order.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        while(l <= r) {
            int mid = l + (r - l)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        
        // Test case 1
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = solution.search(nums, target);
        int expected = 4;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
