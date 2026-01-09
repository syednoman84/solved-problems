package problems.LinkedList;

/*
 * 146. LRU Cache
 * Medium
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * - void put(int key, int value) Update the value of the key if the key exists. Otherwise,
 *   add the key-value pair to the cache. If the number of keys exceeds the capacity from this
 *   operation, evict the least recently used key.
 * - The functions get and put must each run in O(1) average time complexity.
 *
 * Example 1:
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Constraints:
 * - 1 <= capacity <= 3000
 * - 0 <= key <= 10^4
 * - 0 <= value <= 10^5
 * - At most 2 * 10^5 calls will be made to get and put.
 */
import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> mp;
    int size;
    
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        mp = new HashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)) {
            Node node = mp.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else
            return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            Node node = mp.get(key);
            remove(node);
        }
        if(mp.size() == size)
            remove(tail.prev);
        insert(new Node(key, value));
    }
    
    private void remove(Node node) {
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
        mp.put(node.key, node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        
        // Test case 1: put(1,1), put(2,2), get(1)
        cache.put(1, 1);
        cache.put(2, 2);
        int result1 = cache.get(1);
        int expected1 = 1;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
