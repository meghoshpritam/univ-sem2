package Shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  private static String getUserInput() {
    String input = scanner.nextLine();
    return input;
  }

  private static String getUserInput(String message) {
    System.out.print(message);
    return getUserInput();
  }

  private static int getUserInputInt() {
    int input = scanner.nextInt();
    scanner.nextLine();
    return input;
  }

  private static int getUserInputInt(String message) {
    System.out.print(message);
    return getUserInputInt();
  }

  private static double getUserInputDouble() {
    double input = scanner.nextDouble();
    scanner.nextLine();
    return input;
  }

  private static double getUserInputDouble(String message) {
    System.out.print(message);
    return getUserInputDouble();
  }

  private static void operation(ArrayList<Laptop> laptops, ArrayList<SmartPhone> smartPhones) {
    System.out.println("Welcome to our store");
    System.out.println("We are dealing with smartphones and laptops");

    boolean loop = true;

    while (loop) {
      System.out.println();
      int option = getUserInputInt("Enter your option: ");
      switch (option) {
        case 7:
          loop = false;
          break;
        default:
          System.out.println("You enter an invalid option!");
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Laptop> laptops = new ArrayList<Laptop>();
    ArrayList<SmartPhone> smartPhones = new ArrayList<SmartPhone>();

    operation(laptops, smartPhones);

    scanner.close();
  }
}
