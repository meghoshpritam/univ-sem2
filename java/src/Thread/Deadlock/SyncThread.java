package Thread.Deadlock;

class SyncThread implements Runnable {
  private final Object obj1;
  private final Object obj2;
  private final Object obj3;

  public SyncThread(Object o1, Object o2, Object o3) {
    this.obj1 = o1;
    this.obj2 = o2;
    this.obj3 = o3;
  }

  public SyncThread(Object o1, Object o2) {
    this(o1, o2, new Object());
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println(name + " acquiring lock on: " + obj1);

    synchronized (obj1) {
      System.out.println(name + " acquired lock on: " + obj1);
      work(7000);
    }
    System.out.println(name + " released lock on: " + obj1);
    System.out.println(name + " acquiring lock on: " + obj2);

    synchronized (obj2) {
      System.out.println(name + " acquired lock on: " + obj2);
      work();
    }
    System.out.println(name + " released lock on: " + obj2);

    synchronized (obj3) {
      System.out.println(name + " acquired lock on: " + obj3);
        work(2500);
      synchronized (obj2) {
        System.out.println(name + " acquired lock on: " + obj2);
        work(2500);
      }
    }
    System.out.println(name + " released lock on: " + obj2);
    System.out.println(name + " released lock on: " + obj3);
    System.out.println(name + " finished execution.\n");
  }

  private void work(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }

  private void work() {
    this.work(5000);
  }
}