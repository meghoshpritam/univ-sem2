package String;

import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static String input(String message) {
    System.out.print(message);
    String input = scanner.nextLine();
    return input;
  }

  public static void main(String[] args) {
    String userName = input("Enter your name: ");

    if (userName.isEmpty()) {
      System.out.println("You didn't enter your name");
      return;
    }

    System.out.println("Your name: " + userName.toLowerCase());
    System.out.println("Your name: " + userName.toUpperCase());
    System.out.printf("Your name have %d charter\n", userName.length());
    System.out.printf("Your enter %d space in your name\n", userName.split(" ").length - 1);

    scanner.close();
  }
}
