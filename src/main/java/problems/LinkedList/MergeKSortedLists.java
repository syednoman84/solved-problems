package problems.LinkedList;

/*
 * 23. Merge k Sorted Lists
 * Hard
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 * - k == lists.length
 * - 0 <= k <= 10^4
 * - 0 <= lists[i].length <= 500
 * - -10^4 <= lists[i][j] <= 10^4
 * - lists[i] is sorted in ascending order.
 * - The sum of lists[i].length will not exceed 10^4.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge2LL(l1, l2);
        } else return null;
    }

    public ListNode merge2LL(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tmp = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                ListNode nextL1 = l1.next;
                l1.next = l2;
                l1 = nextL1;
                tmp = tmp.next;
            } else {
                tmp.next = l2;
                ListNode nextL2 = l2.next;
                l2.next = l1;
                l2 = nextL2;
                tmp = tmp.next;
            }
        }

        if (l1 == null) tmp.next = l2;
        if (l2 == null) tmp.next = l1;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Test case 1: lists = []
        ListNode[] lists1 = {};
        ListNode result1 = null;
        if(lists1.length > 0) {
            result1 = solution.mergeKLists(lists1);
        }
        boolean expected1 = true;
        boolean actual1 = result1 == null;
        String status1 = actual1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
