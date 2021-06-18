package Bank;

public class Account {
  private final int accountNumber;
  private String accountType;
  private double balance;
  private final User user;

  public Account(int accountNumber, String accountType, double balance, User user) {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.balance = balance;
    this.user = user;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public String getAccountType() {
    return accountType;
  }

  public double getBalance() {
    return balance;
  }

  public User getUser() {
    return user;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double deposit(double balance) {
    this.setBalance(this.balance + Math.abs(balance));
    return this.balance;
  }

  public double withdrawal(double balance) {
    this.setBalance(this.balance - Math.abs(balance));
    return this.balance;
  }
}
