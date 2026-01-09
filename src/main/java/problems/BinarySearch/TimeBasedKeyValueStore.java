package problems.BinarySearch;

/*
 * 981. Time Based Key-Value Store
 * Medium
 *
 * Design a time-based key-value data structure that can store multiple values for the same key
 * at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 * - TimeMap() Initializes the object of the data structure.
 * - void set(String key, String value, int timestamp) Stores the key key with the value value
 *   at the given time timestamp.
 * - String get(String key, int timestamp) Returns a value such that set was called previously,
 *   with timestamp_prev <= timestamp. If there are multiple such values, it returns the value
 *   associated with the largest timestamp_prev. If there are no values, it returns "".
 *
 * Example 1:
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 *
 * Constraints:
 * - 1 <= key.length, value.length <= 100
 * - key and value consist of lowercase English letters and digits.
 * - 1 <= timestamp <= 10^7
 * - All the timestamps timestamp of set are strictly increasing.
 * - At most 2 * 10^5 calls will be made to set and get.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if(treeMap == null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if(floor == null) {
            return "";
        }
        return treeMap.get(floor);
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore solution = new TimeBasedKeyValueStore();
        
        // Test case 1
        solution.set("foo", "bar", 1);
        String result = solution.get("foo", 1);
        String expected = "bar";
        String status = result.equals(expected) ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
