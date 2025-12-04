import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Problem Statement:
     *      Given an integer array nums, return true if any value appears at least twice in the array,
     *      and return false if every element is distinct.
     *
     *
     * Solution:
     *      Using HashSet for O(1) lookups and insertions
     *      Time: O(n) average, Space: O(n)
     *      Key advantage: Early termination when duplicate found
     */
    public boolean hasDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if (seen.contains(num)){
                return true;
            }

            seen.add(num);
        }
        return false;
    }

    public boolean hasDuplicateViaStreams(int[] nums) {

        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
