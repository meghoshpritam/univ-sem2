package InterfaceStack;

public class Stack implements iStack {
    private int top;
    private final int[] stack;

    public Stack(int size) {
        top = -1;
        stack = new int[size];
    }

    public Stack() {
        this(10);
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int number) {
        if (stack.length - 1 <= top)
            throw new OutOfMemoryError("Stack Overflow!!");

        stack[top += 1] = number;
    }

    public int pop() {
        if (top < 0)
            throw new OutOfMemoryError("Stack Underflow!!");

        top -= 1;
        return stack[top + 1];
    }

    public Integer peek() {
        if (top < 0)
            return null;

        return stack[top];
    }

    public void state() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Stack Status:");
        System.out.println("top");
        for (int idx = top; idx > -1; idx--) {
            System.out.println(stack[idx]);
        }
        System.out.println("bottom");
    }
}
