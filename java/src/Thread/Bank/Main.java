package Thread.Bank;

public class Main {
  public static void main(String[] args) {
    SynchronizedAccount account = new SynchronizedAccount(1000);
    Thread user1 = new Thread(account);
    Thread user2 = new Thread(account);

    user1.setName("User 1");
    user2.setName("User 2");

    user1.start();
    user2.start();
  }
}
