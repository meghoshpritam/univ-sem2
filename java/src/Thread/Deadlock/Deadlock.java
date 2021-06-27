package Thread.Deadlock;

class Deadlock {
  public static void main(String[] args) throws InterruptedException {
    Object obj1 = new Object();
    Object obj2 = new Object();
    Object obj3 = new Object();
    Thread t1 = new Thread(new SyncThread(obj1, obj2, obj3), "T1");
    Thread t2 = new Thread(new SyncThread(obj1, obj3), "T2");
    Thread t3 = new Thread(new SyncThread(obj2, obj3, obj1), "T3");
    t1.start();
    Thread.sleep(2000);
    t2.start();
    Thread.sleep(2000);
    t3.start();
  }
}