package Thread.ProducerConsumerProblem;

class Consumer extends Thread {
  private final Producer producer;

  Consumer(Producer prod) {
    this.producer = prod;
  }

  public void run() {
    synchronized (producer.getBuffer()) {
      try {
        producer.getBuffer().wait();
      } catch (Exception e) {
        e.printStackTrace();
      }

      for (int idx = 0; idx < producer.getBuffer().length(); idx++) {
        System.out.println("Consumed: " + producer.getBuffer().charAt(idx));
      }

      System.out.println("Buffer is Empty\n");
    }
  }
}
