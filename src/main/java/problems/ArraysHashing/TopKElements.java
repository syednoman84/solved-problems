package problems.ArraysHashing;

/*
 * 347. Top K Frequent Elements
 * Medium
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - k is in the range [1, the number of unique elements in the array].
 * - It is guaranteed that the answer is unique.
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] res = new int[k];
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val-a.val);
        for(int key : mp.keySet())
            pq.offer(new Pair(key, mp.get(key)));
        for(int i = 0; i < k; i++)
            res[i] = pq.poll().key;
        
        return res;
    }

    public static void main(String[] args) {
        TopKElements solution = new TopKElements();
        
        // Test case 1
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        boolean match = (result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1);
        String status = match ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: [1,2] (in any order), Got: " + java.util.Arrays.toString(result) + " [" + status + "]");
    }
}

class Pair {
    int key;
    int val;
    
    Pair(int k, int v) {
        key = k;
        val = v;
    }
}
