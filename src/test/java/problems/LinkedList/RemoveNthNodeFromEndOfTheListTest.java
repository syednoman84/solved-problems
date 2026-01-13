package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfTheListTest {
    private final RemoveNthNodeFromEndOfTheList solution = new RemoveNthNodeFromEndOfTheList();

    @Test
    void testRemoveNthFromEnd() {
        RemoveNthNodeFromEndOfTheList.ListNode head1 = solution.new ListNode(1);
        RemoveNthNodeFromEndOfTheList.ListNode result1 = solution.removeNthFromEnd(head1, 1);
        assertNull(result1);
        
        RemoveNthNodeFromEndOfTheList.ListNode head2 = solution.new ListNode(1);
        head2.next = solution.new ListNode(2);
        RemoveNthNodeFromEndOfTheList.ListNode result2 = solution.removeNthFromEnd(head2, 1);
        assertEquals(1, result2.val);
        
        RemoveNthNodeFromEndOfTheList.ListNode head3 = solution.new ListNode(1);
        head3.next = solution.new ListNode(2);
        head3.next.next = solution.new ListNode(3);
        RemoveNthNodeFromEndOfTheList.ListNode result3 = solution.removeNthFromEnd(head3, 2);
        assertEquals(1, result3.val);
        assertEquals(3, result3.next.val);
    }
}