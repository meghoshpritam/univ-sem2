package Thread.ProducerConsumerProblem;

class Producer extends Thread {
  private final StringBuffer buffer;
  private final int size;

  Producer(int size) {
    this.size = size;
    buffer = new StringBuffer(size);
  }

  public void run() {
    synchronized (buffer) {
      for (int idx = 0; idx < size; idx++) {
        try {
          buffer.append(idx + 1);
          System.out.println("Produced " + (idx + 1));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      System.out.println("Buffer is FUll\n");
      buffer.notify();
    }
  }

  public StringBuffer getBuffer() {
    return buffer;
  }
}