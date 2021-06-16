package Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Own {

  public static float divide(float... args) {
    float result = 1;
    for (float arg : args) {
      if (arg == 0) {
        throw new ArithmeticException("Divisible by zero is not allowed");
      }
      result /= arg;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Float> numbers = new ArrayList<>();
    System.out.println("Divide numbers");


    System.out.print("Enter numbers separated by comma(,): ");
    String input = scanner.nextLine();

    String[] nums = input.split(",");
    for (String num : nums) {
      numbers.add(Float.parseFloat(num.trim()));
    }

    float result = 1;
    try {
      for (float num : numbers) {
        result = Own.divide(result, num);
        System.out.printf("%f divide successfully\n", num);
      }
    } catch (ArithmeticException error) {
      System.out.printf("%s , 0 is skip\n", error.getMessage());
    } finally {
      System.out.printf("Result: %f\n", result);
    }
  }
}
