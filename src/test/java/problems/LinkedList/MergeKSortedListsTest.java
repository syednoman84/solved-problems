package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {
    private final MergeKSortedLists solution = new MergeKSortedLists();

    @Test
    void testMergeKLists() {
        assertNull(solution.mergeKLists(new MergeKSortedLists.ListNode[]{}));
        
        MergeKSortedLists.ListNode[] lists1 = {null};
        assertNull(solution.mergeKLists(lists1));
        
        MergeKSortedLists.ListNode list1 = solution.new ListNode(1);
        list1.next = solution.new ListNode(4);
        MergeKSortedLists.ListNode list2 = solution.new ListNode(1);
        list2.next = solution.new ListNode(3);
        MergeKSortedLists.ListNode[] lists2 = {list1, list2};
        MergeKSortedLists.ListNode result = solution.mergeKLists(lists2);
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
    }
}