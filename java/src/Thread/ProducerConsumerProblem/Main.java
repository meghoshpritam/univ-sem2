package Thread.ProducerConsumerProblem;

public class Main {
  public static void main(String[] args)
  {
    Producer producer = new Producer(9);
    
    Consumer consumer = new Consumer(producer);
    Thread thread1 = new Thread(producer);
    Thread thread2 = new Thread(consumer);
    
    thread2.start();
    thread1.start();
  }
}
