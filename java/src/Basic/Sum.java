package Basic;

public class Sum {
  public static void main(String[] args) {
    int sum = 0;

    if (args.length < 1) {
      System.out.println("Argument is missing!");
      return;
    }
      
    for (String arg : args) {
      sum += Integer.parseInt(arg);
      System.out.printf("%s + ", arg);
    }

    System.out.printf("\b\b= %d", sum);
  }
}
