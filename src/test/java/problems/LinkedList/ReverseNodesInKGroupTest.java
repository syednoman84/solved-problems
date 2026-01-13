package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseNodesInKGroupTest {
    private final ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

    @Test
    void testReverseKGroup() {
        ReverseNodesInKGroup.ListNode head1 = solution.new ListNode(1);
        head1.next = solution.new ListNode(2);
        ReverseNodesInKGroup.ListNode result1 = solution.reverseKGroup(head1, 2);
        assertEquals(2, result1.val);
        assertEquals(1, result1.next.val);
        
        ReverseNodesInKGroup.ListNode head2 = solution.new ListNode(1);
        head2.next = solution.new ListNode(2);
        head2.next.next = solution.new ListNode(3);
        ReverseNodesInKGroup.ListNode result2 = solution.reverseKGroup(head2, 2);
        assertEquals(2, result2.val);
        assertEquals(1, result2.next.val);
        assertEquals(3, result2.next.next.val);
    }
}