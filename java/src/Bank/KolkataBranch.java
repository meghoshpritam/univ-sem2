package Bank;

import java.util.ArrayList;

public class KolkataBranch extends Branch{
  private ArrayList<String> branchAssets;
  public KolkataBranch() {
    super("Kolkata Branch");
    this.branchAssets = new ArrayList<String>();
    this.branchAssets.add("Gold");
  }
  
  public ArrayList<Account> getAccounts() {
    return super.getAccounts();
  }

  public ArrayList<String> getBranchAssets() {
    return branchAssets;
  }

  public void setBranchAssets(ArrayList<String> branchAssets) {
    this.branchAssets = branchAssets;
  }
}
