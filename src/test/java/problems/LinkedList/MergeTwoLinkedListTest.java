package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeTwoLinkedListTest {
    private final MergeTwoLinkedList solution = new MergeTwoLinkedList();

    @Test
    void testMergeTwoLists() {
        assertNull(solution.mergeTwoLists(null, null));
        
        MergeTwoLinkedList.ListNode list2 = solution.new ListNode(0);
        MergeTwoLinkedList.ListNode result1 = solution.mergeTwoLists(null, list2);
        assertEquals(0, result1.val);
        
        MergeTwoLinkedList.ListNode list1 = solution.new ListNode(1);
        list1.next = solution.new ListNode(2);
        MergeTwoLinkedList.ListNode list3 = solution.new ListNode(1);
        list3.next = solution.new ListNode(3);
        MergeTwoLinkedList.ListNode result2 = solution.mergeTwoLists(list1, list3);
        assertEquals(1, result2.val);
        assertEquals(1, result2.next.val);
    }
}