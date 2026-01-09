package problems.LinkedList;

/*
 * 25. Reverse Nodes in k-Group
 * Hard
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
 * is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Constraints:
 * - The number of nodes in the list is n.
 * - 1 <= k <= n <= 5000
 * - 0 <= Node.val <= 1000
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0, head); // dummy head
        ListNode curr = head, prev = root;
        
        while(curr != null) {
            ListNode tail = curr; // keep track of the 1st element of each group
            int listIndex = 0;
            
            while(curr != null && listIndex < k) {
                curr = curr.next;
                listIndex++;
            }
            // listIndex != k means we have a group less than k size
            if(listIndex != k)
                prev.next = tail;
                // less than k size so simply pointing prev to the 
                // first element of the group
            else {
                // reverse the group
                prev.next = reverse(tail, k);
                // prev will move to the first element(now the last) of the group
                // so that next of it would have the reverse of the group
                prev = tail;
            }
        }
        return root.next;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode curr = head, prev = null, next = null;
        
        while(curr != null && k > 0) {
            k--;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        
        // Test case 1: head = [1,2], k = 2
        ListNode head1 = new ReverseNodesInKGroup().new ListNode(1);
        head1.next = new ReverseNodesInKGroup().new ListNode(2);
        ListNode result1 = solution.reverseKGroup(head1, 2);
        boolean expected1 = true;
        boolean actual1 = result1.val == 2 && result1.next.val == 1;
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
