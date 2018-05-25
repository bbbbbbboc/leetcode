// 716. Max Stack

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        int prevMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        int currMax = x > prevMax ? x : prevMax;
        
        stack.push(x);
        maxStack.push(currMax);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        
        stack.pop();
        maxStack.pop();
        
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */