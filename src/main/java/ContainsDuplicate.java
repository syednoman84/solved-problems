import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Optimized solution using HashSet for O(1) lookups
     * Time: O(n) average, Space: O(n)
     * Key advantage: Early termination when duplicate found
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
