package Thread.MultiThread;

public class Main {
  public static String formatTime(long milliseconds) {
    String time = "";
    int seconds = (int) (milliseconds / 1000) % 60;
    int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
    int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);

    if (hours > 1)
      time += (hours + "hours ");
    else if (hours > 0)
      time += (hours + "hour ");

    if (minutes > 1)
      time += (minutes + "minutes ");
    else if (minutes > 0)
      time += (minutes + "minute ");

    if (seconds > 1)
      time += (seconds + "seconds");
    else if (seconds > 0)
      time += (seconds + "second");

    return time;
  }

  public static void main(String[] args) {
    long totalRunningTime = System.currentTimeMillis();

    Matrix matrix1 = new Matrix(1000, 1000);
    Matrix matrix2 = new Matrix(1000, 3000);

    System.out.print("Multiplying, MatA" + matrix1.getRow() + "x" + matrix1.getCol());
    System.out.print(" X MatB" + matrix2.getRow() + "x" + matrix2.getCol());
    System.out.println(" started...");
    
    long executionTimeThread = System.currentTimeMillis();
    Matrix mulThread = Matrix.multiplicationWithThread(matrix1, matrix2);
    executionTimeThread = System.currentTimeMillis() - executionTimeThread;

    long executionTime = System.currentTimeMillis();
    Matrix mul = Matrix.multiplication(matrix1, matrix2);
    executionTime = System.currentTimeMillis() - executionTime;

//    System.out.println("\nMatrix1::");
//    matrix1.showMatrix();
//    System.out.println("\nMatrix2::");
//    matrix2.showMatrix();

    System.out.println("\nMatrix Multiplication with thread::");
//    mulThread.showMatrix();
    System.out.println("Time to execute using thread:: " + formatTime(executionTimeThread));

    System.out.println("\nMatrix Multiplication::");
//    mul.showMatrix();
    System.out.println("Time to execute:: " + formatTime(executionTime));

    totalRunningTime = System.currentTimeMillis() - totalRunningTime;
    System.out.println("Time to execute:: " + formatTime(totalRunningTime));
  }
}
