package problems.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CopyListWithRandomPointerTest {
    private final CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

    @Test
    void testCopyRandomList() {
        assertNull(solution.copyRandomList(null));
        
        CopyListWithRandomPointer.Node head = solution.new Node(7);
        head.next = solution.new Node(13);
        head.next.random = head;
        CopyListWithRandomPointer.Node result = solution.copyRandomList(head);
        assertEquals(7, result.val);
        assertEquals(13, result.next.val);
        assertEquals(result, result.next.random);
        
        CopyListWithRandomPointer.Node single = solution.new Node(1);
        single.random = single;
        CopyListWithRandomPointer.Node result2 = solution.copyRandomList(single);
        assertEquals(1, result2.val);
        assertEquals(result2, result2.random);
    }
}