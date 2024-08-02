/*
  Problem: Min Stack
  Link: https://neetcode.io/problems/minimum-stack

  Problem Statement: 
  Design a stack class that supports the push, pop, top, and getMin operations.
  
  MinStack() initializes the stack object.
  void push(int val) pushes the element val onto the stack.
  void pop() removes the element on the top of the stack.
  int top() gets the top element of the stack.
  int getMin() retrieves the minimum element in the stack.
  Each function should run in O(1) time.
  
  Example 1:
  
  Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
  
  Output: [null,null,null,null,0,null,2,1]
  
  Explanation:
  MinStack minStack = new MinStack();
  minStack.push(1);
  minStack.push(2);
  minStack.push(0);
  minStack.getMin(); // return 0
  minStack.pop();
  minStack.top();    // return 2
  minStack.getMin(); // return 1
  Constraints:
  
  -2^31 <= val <= 2^31 - 1.
  pop, top and getMin will always be called on non-empty stacks.

*/
class MinStack {
    /*
        To find min in O(1) time, find new minimum value when new value is pushed to stack
        and push old minValue to minStack, when an element is popped from stack, check if its 
        equal to peek element in minStack, if yes then pop element from minStack as well
        and assign top element of minStack as new miniumn value

        eg: consider stack: [3, 4, 1, 2, 0, 5, -1]
            minStack will be: [3, 1, 0, -1]
    */
    Stack<Integer> stack;
    Stack<Integer> minStack; 
    int min = Integer.MAX_VALUE; // -400 -300
    public MinStack() {
        stack = new Stack<>(); // -100 -200 -300 -400
        minStack = new Stack<>(); // -100 -200 -300 -400
    }
    
    public void push(int val) {
        stack.push(val);
        if(val<=min) {
            min = val;
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.pop().equals(minStack.peek())) {
            minStack.pop();
            if(minStack.size() > 0) min = minStack.peek();
            else min = Integer.MAX_VALUE;
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
