package Bank;

import java.util.ArrayList;

public class Branch {
  private String branchName;
  private ArrayList<Account> accounts;

  public Branch(String branchName) {
    this.accounts = new ArrayList<Account>();
    this.branchName = branchName;
  }

  protected String getBranchName() {
    return branchName;
  }

  protected void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  protected ArrayList<Account> getAccounts() {
    return accounts;
  }

  protected void setAccounts(ArrayList<Account> accounts) {
    this.accounts = accounts;
  }
}
