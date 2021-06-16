package Stack;

import java.util.Scanner;

public class Main {
  public static void operations(Stack stack, String option, int value) {
    try {
      switch (option) {
        case "push":
          stack.push(value);
          System.out.printf("%d is push into stack!", value);
          break;
        default:
          System.out.println("Invalid operation");
      }
    } catch (OutOfMemoryError error) {
      System.out.println(error.getMessage());
    }
  }

  public static void operations(Stack stack, String option) {
    try {
      switch (option) {
        case "pop":
          int popValue = stack.pop();
          System.out.printf("%d is pop from stack!", popValue);
          break;
        case "peek":
          if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            break;
          }
          System.out.printf("%d is the top value of stack", stack.peek());
          break;
        case "empty":
          if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            break;
          }
          System.out.println("Stack is n't empty");
          break;
        case "state":
          System.out.println("Stack state:");
          stack.state();
        default:
          System.out.println("Invalid operation");
      }
    } catch (OutOfMemoryError error) {
      System.out.println(error.getMessage());
    }
  }

  public static int userInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static void userPrompt(Stack stack) {
    boolean loop = true;

    do {
      System.out.println("\n\nChoose from the following options:");
      System.out.println("1. push");
      System.out.println("2. pop");
      System.out.println("3. peek");
      System.out.println("4. check is empty");
      System.out.println("5. check the values");
      System.out.println("6. exit");
      System.out.print("Enter your choose: ");
      int option = Main.userInput();

      switch (option) {
        case 1:
          System.out.print("Enter the value to push: ");
          int value = Main.userInput();
          operations(stack, "push", value);
          break;
        case 2:
          operations(stack, "pop");
          break;
        case 3:
          operations(stack, "peek");
          break;
        case 4:
          operations(stack, "empty");
          break;
        case 5:
          operations(stack, "state");
          break;
        case 6:
          loop = false;
          break;
        default:
          System.out.println("Invalid operation");
      }
    } while (loop);
  }

  public static void main(String[] args) {
    System.out.println("Stack representation using array");
    System.out.print("Create a state, Enter size of stack: ");
    int size = Main.userInput();

    // initialize the stack
    Stack stack = new Stack(size);

    Main.userPrompt(stack);
  }
}
