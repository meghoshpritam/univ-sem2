package Thread.ThreadWithPriority;

public class Main {
  public static void print(int number, int lim) {
    System.out.printf("Thread %d is started\n", number);
    for (int idx = 0; idx < lim; idx++) {
      for (int idx2 = 0; idx2 < lim; idx2++)
        for (int idx3 = 0; idx3 < lim; idx3++)
          ;
      if (idx % (lim / 10) == 0)
        System.out.println("Thread " + number + "\t " + idx);
    }
    System.out.printf("Thread %d is end\n", number);
  }

  public static void showPriority(Thread thread) {
    System.out.println(thread.getName() + " priority is: " + thread.getPriority());
  }

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> print(1, 150000));

    Thread thread2 = new Thread(() -> print(2, 200000));

    Thread thread3 = new Thread(() -> print(3, 200000));

    thread1.setName("Thread 1");
    thread2.setName("Thread 2");
    thread3.setName("Thread 3");

    thread1.setPriority(10); // lowest priority
    thread2.setPriority(3);
    thread3.setPriority(1); // highest priority

    showPriority(thread1);
    showPriority(thread2);
    showPriority(thread3);

    System.out.println("\n-----------------------\n");

    thread1.start();
    thread2.start();
    thread3.start();
  }
}
