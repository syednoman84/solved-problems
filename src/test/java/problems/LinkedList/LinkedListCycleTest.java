package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {
    private final LinkedListCycle solution = new LinkedListCycle();

    @Test
    void testHasCycle() {
        assertFalse(solution.hasCycle(null));
        
        LinkedListCycle.ListNode head1 = solution.new ListNode(1);
        assertFalse(solution.hasCycle(head1));
        
        LinkedListCycle.ListNode head2 = solution.new ListNode(3);
        head2.next = solution.new ListNode(2);
        head2.next.next = head2;
        assertTrue(solution.hasCycle(head2));
        
        LinkedListCycle.ListNode head3 = solution.new ListNode(1);
        head3.next = solution.new ListNode(2);
        assertFalse(solution.hasCycle(head3));
    }
}