package InterfaceStack;

public class Main implements iMain {
  
  public static void main(String[] args) {
    System.out.println("Stack representation using array");
    System.out.print("Create a state, Enter size of stack: ");
    int size = iMain.userInput();

    // initialize the stack
    Stack stack = new Stack(size);

    iMain.userPrompt(stack);
    scanner.close();
  }
}
