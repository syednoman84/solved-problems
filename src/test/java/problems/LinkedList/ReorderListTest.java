package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReorderListTest {
    private final ReorderList solution = new ReorderList();

    @Test
    void testReorderList() {
        ReorderList.ListNode head1 = solution.new ListNode(1);
        head1.next = solution.new ListNode(2);
        solution.reorderList(head1);
        assertEquals(1, head1.val);
        assertEquals(2, head1.next.val);
        
        ReorderList.ListNode head2 = solution.new ListNode(1);
        head2.next = solution.new ListNode(2);
        head2.next.next = solution.new ListNode(3);
        head2.next.next.next = solution.new ListNode(4);
        solution.reorderList(head2);
        assertEquals(1, head2.val);
        assertEquals(4, head2.next.val);
        assertEquals(2, head2.next.next.val);
        assertEquals(3, head2.next.next.next.val);
    }
}