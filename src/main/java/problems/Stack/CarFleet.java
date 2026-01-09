package problems.Stack;

/*
 * 853. Car Fleet
 * Medium
 *
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
 * A car fleet is some non-empty set of cars driving at the same position and same speed.
 * Return the number of car fleets that will arrive at the destination.
 *
 * Example 1:
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 *
 * Example 2:
 * Input: target = 10, position = [3], speed = [3]
 * Output: 1
 *
 * Example 3:
 * Input: target = 100, position = [0,2,4], speed = [4,2,1]
 * Output: 1
 *
 * Constraints:
 * - n == position.length == speed.length
 * - 1 <= n <= 10^5
 * - 0 < target <= 10^6
 * - 0 <= position[i] < target
 * - All the values of position are unique.
 * - 0 < speed[i] <= 10^6
 */
import java.util.Arrays;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, res = 0;
        double[][] cars = new double[n][2];
        
        for(int i = 0; i < n; i++) {
            cars[i] = new double[] {position[i], (double)(target-position[i])/speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double curr = 0;
        for(int i = n-1; i >= 0; i--) {
            if(cars[i][1] > curr) {
                curr = cars[i][1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CarFleet solution = new CarFleet();
        
        // Test case 1: target = 10, position = [3], speed = [3]
        int result1 = solution.carFleet(10, new int[]{3}, new int[]{3});
        int expected1 = 1;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
