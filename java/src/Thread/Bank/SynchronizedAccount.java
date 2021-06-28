package Thread.Bank;

public class SynchronizedAccount implements Runnable {
  private final Account account;

  public SynchronizedAccount(int accountBalance) {
    this.account = new Account(accountBalance);
  }

  @Override
  public void run() {
    for (int idx = 0; idx < 5; idx++) {
      makeWithdrawal((int) (Math.random() * account.getBalance()));
      if (account.getBalance() < 0) {
        System.out.println("account is overdrawn!");
      }
    }
  }

  private synchronized void makeWithdrawal(int amt) {
    System.out.println(Thread.currentThread().getName() + " is going to withdraw, " + amt);
    if (account.getBalance() >= amt) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException ignored) {
      }
      account.withdraw(amt);
      System.out.println(
          Thread.currentThread().getName() + " completes the withdrawal, remaining balance: " + account.getBalance());
    } else {
      System.out.println("Not enough in account for " + Thread.currentThread().getName()
          + " to withdraw, current balance: " + account.getBalance());
    }
  }
}
