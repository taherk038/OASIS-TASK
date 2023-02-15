import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;

public class ATM {
  private static String username = "user";
  private static String password = "user123";
  private static double balance = 1000;
  private static ArrayList<String> transactionHistory = new ArrayList<String>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String inputUsername = scanner.nextLine();

    Console console = System.console();
    String inputPassword;
    if (console == null) {
      System.out.println("Unable to get console. Please enter password: ");
      inputPassword = scanner.nextLine();
    } else {
      char[] passwordArray = console.readPassword("Enter password: ");
      inputPassword = new String(passwordArray);
    }

    if (inputUsername.equals(username) && inputPassword.equals(password)) {
      System.out.println("Login successful!");
      boolean quit = false;

      while (!quit) {
        System.out.println("1. Transaction history");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        System.out.print("Enter option: ");
        int option = scanner.nextInt();

        switch (option) {
          case 1:
            transactionHistory();
            break;
          case 2:
            withdraw();
            break;
          case 3:
            deposit();
            break;
          case 4:
            transfer();
            break;
          case 5:
            quit = true;
            System.out.println("Goodbye!");
            break;
          default:
            System.out.println("Invalid option. Please try again.");
        }
      }
    } else {
      System.out.println("Invalid username or password. Please try again.");
    }
  }

  private static void transactionHistory() {
    System.out.println("Transaction history:");
    if (transactionHistory.size() == 0) {
      System.out.println("No transactions yet.");
    } else {
      for (String transaction : transactionHistory) {
        System.out.println(transaction);
      }
    }
  }

  private static void withdraw() {
    System.out.print("Enter amount to withdraw: ");
    Scanner scanner = new Scanner(System.in);
    double amount = scanner.nextDouble();

    if (amount > balance) {
      System.out.println("Insufficient funds. Please try again.");
    } else {
      balance -= amount;
      String transaction = String.format("Withdrawn %.2f. New balance: %.2f", amount, balance);
      transactionHistory.add(transaction);
      System.out.println(transaction);
    }
  }


  private static void deposit() {
    System.out.print("Enter amount to deposit: ");
    Scanner scanner = new Scanner(System.in);
    double amount = scanner.nextDouble();

    balance += amount;
    System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
  }

  private static void transfer() {
    System.out.print("Enter recipient's account number: ");
    Scanner scanner = new Scanner(System.in);
    String accountNumber = scanner.nextLine();

    System.out.print("Enter amount to transfer: ");
    double amount = scanner.nextDouble();

    if (amount > balance) {
      System.out.println("Insufficient funds. Please try again.");
    } else {
      balance -= amount;

      System.out.printf("Transferred %.2f to account %s. New balance: %.2f%n", amount, accountNumber, balance);
    }
  }
}