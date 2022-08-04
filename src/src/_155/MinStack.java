package _155;

import java.util.Stack;

class MinStackElem {
    public int val;
    public int minValue;

    MinStackElem(int val, int minValue) {
        this.val = val;
        this.minValue = minValue;
    }
}

class MinStack {
    Stack<MinStackElem> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.size() > 0) {
            MinStackElem lastElem = stack.peek();
            stack.push(new MinStackElem(val, Math.min(lastElem.minValue, val)));
        } else {
            stack.push(new MinStackElem(val, val));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minValue;
    }
}
