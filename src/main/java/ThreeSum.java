import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int length = nums.length;

        Arrays.sort(nums);

        for (int pivot = 0; pivot < length; pivot++) {
            if (nums[pivot] > 0) {
                break;
            }

            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) {
                continue;
            }

            int low = pivot + 1;
            int high = length - 1;
            while (low < high) {
                int total = nums[pivot] + nums[low] + nums[high];

                if (total < 0) {
                    low++;
                } else if (total > 0) {
                    high--;
                } else {
                    result.add(List.of(nums[pivot], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                }

            }
        }
        return result;
    }
}