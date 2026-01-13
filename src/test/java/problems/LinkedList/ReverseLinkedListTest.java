package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {
    private final ReverseLinkedList solution = new ReverseLinkedList();

    @Test
    void testReverseList() {
        assertNull(solution.reverseList(null));
        
        ReverseLinkedList.ListNode single = solution.new ListNode(1);
        ReverseLinkedList.ListNode result1 = solution.reverseList(single);
        assertEquals(1, result1.val);
        
        ReverseLinkedList.ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        ReverseLinkedList.ListNode result2 = solution.reverseList(head);
        assertEquals(2, result2.val);
        assertEquals(1, result2.next.val);
    }
}