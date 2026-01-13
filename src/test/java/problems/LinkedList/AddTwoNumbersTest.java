package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {
    private final AddTwoNumbers solution = new AddTwoNumbers();

    @Test
    void testAddTwoNumbers() {
        AddTwoNumbers.ListNode l1 = solution.new ListNode(0);
        AddTwoNumbers.ListNode l2 = solution.new ListNode(0);
        AddTwoNumbers.ListNode result1 = solution.addTwoNumbers(l1, l2);
        assertEquals(0, result1.val);
        
        AddTwoNumbers.ListNode l3 = solution.new ListNode(2);
        l3.next = solution.new ListNode(4);
        AddTwoNumbers.ListNode l4 = solution.new ListNode(5);
        l4.next = solution.new ListNode(6);
        AddTwoNumbers.ListNode result2 = solution.addTwoNumbers(l3, l4);
        assertEquals(7, result2.val);
        assertEquals(0, result2.next.val);
        assertEquals(1, result2.next.next.val);
    }
}