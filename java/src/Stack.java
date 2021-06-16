public class Stack {
  private int top;
  private int[] stack;

  public Stack(int size) {
    top = -1;
    stack = new int[size];
  }

  public Stack() {
    top = -1;
    stack = new int[10];
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
    
    for (int idx = 0; idx <= top; idx++) {
      System.out.printf("%d, ", stack[idx]);
    }
  }
}