/*
 * 2. Add Two Numbers
 * Medium
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * - The number of nodes in each linked list is in the range [1, 100].
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr1 = l1, curr2 = l2, curr3 = res;
        int carry = 0;
        while(curr1 != null || curr2 != null || carry > 0) {
            int v1 = curr1 == null ? 0 : curr1.val;
            int v2 = curr2 == null ? 0 : curr2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            curr3.next = new ListNode(sum % 10);
            curr3 = curr3.next;
            curr1 = curr1 == null ? curr1 : curr1.next;
            curr2 = curr2 == null ? curr2 : curr2.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        
        // Test case 1: l1 = [0], l2 = [0]
        ListNode l1 = new AddTwoNumbers().new ListNode(0);
        ListNode l2 = new AddTwoNumbers().new ListNode(0);
        ListNode result = solution.addTwoNumbers(l1, l2);
        String expected = "[0]";
        String actual = listToString(result);
        String status = actual.equals("[0]") ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + actual + " [" + status + "]");
    }
    
    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while(head != null) {
            sb.append(head.val);
            head = head.next;
            if(head != null) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
