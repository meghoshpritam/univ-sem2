package Bank;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

public class Main {
  private static int latestAccountNumber = 1;
  private static int latestUserAccountNumber = 1;
  private static final Scanner scanner = new Scanner(System.in);

  private static String getUserInput() {
    String input = scanner.nextLine();
    return input;
  }

  private static String getUserInput(String message) {
    System.out.print(message);
    return Main.getUserInput();
  }

  private static int getUserInputInt() {
    int input = scanner.nextInt();
    scanner.nextLine();
    return input;
  }

  private static int getUserInputInt(String message) {
    System.out.print(message);
    return Main.getUserInputInt();
  }

  private static double getUserInputDouble() {
    double input = scanner.nextDouble();
    scanner.nextLine();
    return input;
  }

  private static double getUserInputDouble(String message) {
    System.out.print(message);
    return Main.getUserInputDouble();
  }

  private static boolean isAccount(ArrayList<Account> accounts, int accountNumber) {
    for (Account acc : accounts) {
      if (accountNumber == acc.getAccountNumber()) {
        return true;
      }
    }
    return false;
  }

  private static Account getAccount(ArrayList<Account> accounts, int accountNumber) {
    for (Account acc : accounts) {
      if (accountNumber == acc.getAccountNumber()) {
        return acc;
      }
    }
    return null;
  }

  public static void operations(ArrayList<Account> accounts, String operation) {
    switch (operation) {
      case "createAccount": {

        // collect user details
        String name = Main.getUserInput("Enter customer name: ");
        String city = Main.getUserInput("Enter customer city: ");
        String state = Main.getUserInput("Enter customer state: ");
        String country = Main.getUserInput("Enter customer country: ");
        String pinCode = Main.getUserInput("Enter customer pinCode: ");
        String email = Main.getUserInput("Enter customer email: ");
        String phone = Main.getUserInput("Enter customer phone: ");

        // select the account type 
        System.out.println("Available account types:");
        System.out.println("1. Current Account");
        System.out.println("1. Saving Account");
        int type = Main.getUserInputInt("Select type of account you wanna create: ");

        // balance
        double balance = Main.getUserInputDouble("Enter account customer want to deposit: ");

        User user = new User(Main.latestUserAccountNumber, name, city, state, country, pinCode, email, phone);

        accounts.add(new Account(Main.latestAccountNumber, type == 1 ? "current" : "saving", balance >= 0 ? balance : 0, user));
        Main.latestUserAccountNumber += 1;
        Main.latestAccountNumber += 1;

        System.out.println(name + "'s account us created. new account number is: " + (Main.latestUserAccountNumber - 1));
        break;
      }
      case "checkBalance": {

        int accNum = Main.getUserInputInt("Enter customer account number: ");

        boolean found = false;
        for (Account acc : accounts) {
          if (accNum == acc.getAccountNumber()) {
            System.out.println("The balance of the account " + accNum + " is: " + acc.getBalance());
            found = true;
            break;
          }
        }
        if (!found) {
          System.out.println(accNum + ", account doesn't exist");
        }
        break;
      }
      case "withdrawal": {
        int accNum = Main.getUserInputInt("Enter customer account number: ");

        boolean found = false;
        double balance = 0;

        for (Account acc : accounts) {
          if (accNum == acc.getAccountNumber()) {
            found = true;
            balance = acc.getBalance();
            break;
          }
        }
        if (!found) {
          System.out.println(accNum + ", account doesn't exist");
          break;
        }

        double amount = Main.getUserInputDouble("Enter amount for for withdrawal: ");
        if (amount > balance) {
          System.out.println("The current account balance is: " + balance + "You can't withdrawal " + amount);
          break;
        }

        for (Account acc : accounts) {
          if (accNum == acc.getAccountNumber()) {
            balance = acc.deposit(amount);
            System.out.println(amount + " is withdrawal, current balance is: " + balance);
            break;
          }
        }
        break;
      }
      case "deposit": {
        int accNum = Main.getUserInputInt("Enter customer account number: ");

        boolean found = false;
        for (Account acc : accounts) {
          if (accNum == acc.getAccountNumber()) {
            found = true;
            break;
          }
        }
        if (!found) {
          System.out.println(accNum + ", account doesn't exist");
          break;
        }

        double amount = Main.getUserInputDouble("Enter amount for deposit");
        for (Account acc : accounts) {
          if (accNum == acc.getAccountNumber()) {
            double balance = acc.deposit(amount);
            System.out.println(amount + " added successfully, current balance is: " + balance);
            break;
          }
        }
        break;
      }
      case "updateUser": {
        int accNum = Main.getUserInputInt("Enter customer account number: ");

        if (!isAccount(accounts, accNum)) {
          System.out.println(accNum + ", account doesn't exist");
          break;
        }

        // select the account type 
        System.out.println("Available User details update options:");
        System.out.println("1. Change Name");
        System.out.println("2. Change address line1");
        System.out.println("3. Change address line2");
        System.out.println("4. Change city");
        System.out.println("5. Change State");
        System.out.println("6. Saving country");
        System.out.println("7. Saving pinCode");
        System.out.println("8. Saving identity type");
        System.out.println("9. Saving identity document number");
        System.out.println("10. Saving email");
        System.out.println("11. Saving phone");
        int op = Main.getUserInputInt("Enter the operation number: ");
        User selectedUser = Objects.requireNonNull(getAccount(accounts, accNum)).getUser();
        switch (op) {
          case 1: {
            String name = getUserInput("Enter Customer Name: ");
            selectedUser.setName(name);
            System.out.println("New name updated successfully");
            break;
          }
          case 2: {
            String address = getUserInput("Enter Customer address line1: ");
            selectedUser.setAddressLine1(address);
            System.out.println("New address line1 updated successfully");
            break;
          }
          case 3: {
            String address = getUserInput("Enter Customer address line2: ");
            selectedUser.setAddressLine2(address);
            System.out.println("New address line2 updated successfully");
            break;
          }
          case 4: {
            String city = getUserInput("Enter Customer city: ");
            selectedUser.setCity(city);
            System.out.println("New city updated successfully");
            break;
          }
          case 5: {
            String state = getUserInput("Enter Customer state: ");
            selectedUser.setState(state);
            System.out.println("New state updated successfully");
            break;
          }
          case 6: {
            String country = getUserInput("Enter Customer country: ");
            selectedUser.setCountry(country);
            System.out.println("New country updated successfully");
            break;
          }
          case 7: {
            String pinCode = getUserInput("Enter Customer pin code: ");
            selectedUser.setPinCode(pinCode);
            System.out.println("New pin code updated successfully");
            break;
          }
          case 8: {
            String identityType = getUserInput("Enter Customer identity type: ");
            selectedUser.setIdentityTyp(identityType);
            System.out.println("New identity type updated successfully");
            break;
          }
          case 9: {
            String identityDoc = getUserInput("Enter Customer identity document: ");
            selectedUser.setIdentityDoc(identityDoc);
            System.out.println("New identity document updated successfully");
            break;
          }
          case 10: {
            String email = getUserInput("Enter Customer email: ");
            selectedUser.setEmail(email);
            System.out.println("New email updated successfully");
            break;
          }
          case 11: {
            String phone = getUserInput("Enter Customer phone: ");
            selectedUser.setPhone(phone);
            System.out.println("New phone updated successfully");
            break;
          }
        }
      }
      case "accounts": {
        if (accounts.size() <= 0) {
          System.out.println("No user account available!");
          break;
        }
        System.out.println("The accounts of our bank");
        for (Account acc : accounts) {
          System.out.println("\n\nAccount Number: " + acc.getAccountNumber());
          System.out.println("User Name: " + acc.getUser().getName());
          System.out.println("Balance: " + acc.getBalance());
        }
        break;
      }
      case "userDetails": {
        int accNum = Main.getUserInputInt("Enter customer account number: ");
        if (!isAccount(accounts, accNum)) {
          System.out.println(accNum + ", account doesn't exist");
          break;
        }

        Account acc = getAccount(accounts, accNum);

        System.out.println("Account Number: " + acc.getAccountNumber());
        System.out.println("Account Balance: " + acc.getBalance());
        System.out.println("Account Type: " + acc.getAccountType());
        User user = acc.getUser();
        System.out.println("User name: " + user.getName());
        System.out.println("User address line1: " + user.getAddressLine1());
        System.out.println("User address line2: " + user.getAddressLine2());
        System.out.println("User city: " + user.getCity());
        System.out.println("User state: " + user.getState());
        System.out.println("User country: " + user.getCountry());
        System.out.println("User pin code: " + user.getPinCode());
        System.out.println("User identity type: " + user.getIdentityTyp());
        System.out.println("User identity document: " + user.getIdentityDoc());
        System.out.println("User email: " + user.getEmail());
        System.out.println("User phone: " + user.getPhone());
        break;
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Account> accounts = new ArrayList<Account>();

    boolean loop = true;

    while (loop) {
      System.out.println("\n\n=====================================================");
      System.out.println("Banking Menu: ");
      System.out.println("1. create a new account ");
      System.out.println("2. check balance ");
      System.out.println("3. withdrawal balance ");
      System.out.println("4. deposit balance ");
      System.out.println("5. update user details ");
      System.out.println("6. check all account ");
      System.out.println("7. check account details ");
      System.out.println("8. exit ");
      int option = getUserInputInt("Enter your option: ");
      System.out.println(">>-----------------------------------------------------<<");

      switch (option) {
        case 1:
          operations(accounts, "createAccount");
          break;
        case 2:
          operations(accounts, "checkBalance");
          break;
        case 3:
          operations(accounts, "withdrawal");
          break;
        case 4:
          operations(accounts, "deposit");
          break;
        case 5:
          operations(accounts, "updateUser");
          break;
        case 6:
          operations(accounts, "accounts");
          break;
        case 7:
          operations(accounts, "userDetails");
          break;
        default:
          System.out.println("Thank you");
          loop = false;
      }
    }
    scanner.close();
  }
}
