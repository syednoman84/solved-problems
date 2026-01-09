package problems.BinarySearch;

/*
 * 875. Koko Eating Bananas
 * Medium
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
 * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead
 * and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 *
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 * Constraints:
 * - 1 <= piles.length <= 10^4
 * - piles.length <= h <= 10^9
 * - 1 <= piles[i] <= 10^9
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = piles[0];
        for(int pile : piles) {
            if(pile < left)
                left = pile;
            if(pile > right)
                right = pile;
        }
        int result = right;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(isSatisfy(piles, mid, h)) {
                result = Math.min(result, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }
    
    private boolean isSatisfy(int[] piles, int mid, int h) {
        int count = 0;
        for(int pile : piles) {
            count += (pile/mid);
            if(pile%mid != 0)
                count++;
        }
        return count <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        
        // Test case 1
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = solution.minEatingSpeed(piles, h);
        int expected = 4;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
