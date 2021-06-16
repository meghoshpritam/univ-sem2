package Pack;

import Basic.Sum;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter numbers for addition separated by comma(','): ");
    String input = scanner.nextLine();
    String[] numbers = input.split(",");

    for (int idx = 0; idx < numbers.length; idx++) {
      numbers[idx] = numbers[idx].trim();
    }

    Sum.main(numbers);
  }
}
