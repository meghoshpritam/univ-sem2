package Thread.Bank;

public class Account {
  private int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public void withdraw(int amount) {
    balance = balance - amount;
  }
}
