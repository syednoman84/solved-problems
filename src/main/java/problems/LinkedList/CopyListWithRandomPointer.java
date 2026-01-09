package problems.LinkedList;

/*
 * 138. Copy List with Random Pointer
 * Medium
 *
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Constraints:
 * - 0 <= n <= 1000
 * - -10^4 <= Node.val <= 10^4
 * - Node.random is null or is pointing to some node in the linked list.
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
      
        // Step 1: Duplicate each node such that old1->new1->old2->new2 ...
        Node curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
      
        // Step 2: Random pointer of new = Random pointer of old's next
        curr = head;
        Node nextNode = head.next;
        while(nextNode != null) {
            nextNode.random = curr.random == null ? null : curr.random.next;
            if(nextNode.next == null)
                break;
            nextNode = nextNode.next.next;
            curr = curr.next.next;
        }
      
        // Step 3: Seperate the the nodes to form old1->old2.. & new1->new2..
        Node p = head, c = head.next, n = null;
        Node newListHead = c;
        while(p != null) {
            n = c.next;
            p.next = n;
            if (n == null)
                break;
            c.next = n.next;
            p = p.next;
            c = c.next;
        }

        return newListHead;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        
        // Test case 1: head = [[3,null],[3,0],[3,null]]
        Node head = new CopyListWithRandomPointer().new Node(3);
        head.next = new CopyListWithRandomPointer().new Node(3);
        head.next.next = new CopyListWithRandomPointer().new Node(3);
        head.next.random = head;
        
        Node result = solution.copyRandomList(head);
        boolean expected = true;
        boolean actual = result != null && result.val == 3 && result.next.random == result;
        String status = actual == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + actual + " [" + status + "]");
    }

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
