package problems.Stack;

/*
 * 155. Min Stack
 * Easy
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * - MinStack() initializes the stack object.
 * - void push(int val) pushes the element val onto the stack.
 * - void pop() removes the element on the top of the stack.
 * - int top() gets the top element of the stack.
 * - int getMin() retrieves the minimum element in the stack.
 *
 * Example 1:
 * Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output: [null,null,null,null,-3,null,0,-2]
 *
 * Constraints:
 * - -2^31 <= val <= 2^31 - 1
 * - Methods pop, top and getMin operations will always be called on non-empty stacks.
 * - At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */
import java.util.Stack;

class PairMinStack {
    int val;
    int min;
    
    PairMinStack(int v, int m) {
        val = v;
        min = m;
    }
}

public class MinStack {
    Stack<PairMinStack> st;
    
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.empty())
            st.push(new PairMinStack(val, val));
        else {
            int min = Math.min(st.peek().min, val);
            st.push(new PairMinStack(val, min));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        // Test case 1: push(-2), push(0), push(-3), getMin()
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int result1 = minStack.getMin();
        int expected1 = -3;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
