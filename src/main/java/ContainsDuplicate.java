import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean hasDuplicateViaStreams(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

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
}
