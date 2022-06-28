import java.text.DecimalFormat;
import java.util.Scanner;
public class Account {
    private int customerNumber;
    private int pinNumber;
    private double CheckingAccountBalance=0;
    private double SavingsAccountBalance =0;
    private String savingsAccTransactionHistory= "";
    private String checkingAccTransactionHistory = "";
    Scanner inp = new Scanner(System.in);
    DecimalFormat amntFormat = new DecimalFormat("#.00");
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    public int getCustomerNumber() {
        return customerNumber;
    }
    public void  setPINNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
    public int getPINNumber() {
        return pinNumber;
    }
    public double getCheckingBalance() {
        return CheckingAccountBalance;
    }
    public double getSavingBalance() {
        return SavingsAccountBalance;
    }
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + amntFormat.format(CheckingAccountBalance));
        System.out.println("Enter Amount you want to withdraw from Checking Account: ");
        double amountToWithdraw = inp.nextDouble();
        if(amountToWithdraw<0) {
            System.out.println("Amount cannot be Negative");
            getCheckingWithdrawInput();
        } else if((CheckingAccountBalance - amountToWithdraw)>=0) {
            calcCheckingWithdraw(amountToWithdraw);
            System.out.println("Now your checking Account Balance is: "+ amntFormat.format(CheckingAccountBalance));
        } else {
            System.out.println("No enough balance to withdraw");
        }
    }
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + amntFormat.format(SavingsAccountBalance));
        System.out.println("Enter Amount you want to withdraw from Savings Account: ");
        double amountToWithdraw = inp.nextDouble();
        if(amountToWithdraw<0) {
            System.out.println("Amount cannot be Negative");
            getSavingWithdrawInput();
        } else if((SavingsAccountBalance - amountToWithdraw)>=0) {
            calcSavingsWithdraw(amountToWithdraw);
            System.out.println("Now your Savings Account Balance is: "+ amntFormat.format(SavingsAccountBalance));
        } else {
            System.out.println("No enough balance to withdraw");
        }
    }
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + amntFormat.format(CheckingAccountBalance));
        System.out.println("Enter amount you want to deposit in Checking Account: ");
        double amountToDeposit = inp.nextDouble();
        if((CheckingAccountBalance + amountToDeposit) >= 0) {
            calcCheckingDeposit(amountToDeposit);
            System.out.println("Now your Checking Account Balance: " + amntFormat.format(CheckingAccountBalance));

        } else {
            System.out.println("Amount could not be Negative.");
        }
    }
    public void getSavingDepositInput() {
        System.out.println("Savings Account Balance: " + amntFormat.format(SavingsAccountBalance));
        System.out.println("Enter amount you want to deposit in Savings Account: ");
        double amountToDeposit = inp.nextDouble();
        if((SavingsAccountBalance + amountToDeposit) >= 0) {
            calcSavingsDeposit(amountToDeposit);
            System.out.println("Now your Savings Account Balance: " + amntFormat.format(SavingsAccountBalance));
        } else {
            System.out.println("Amount could not be Negative.");
        }
    }
    public double calcCheckingWithdraw(double amount) {
        CheckingAccountBalance = (CheckingAccountBalance - amount);
        checkingAccTransactionHistory += "\nAmount debited from your Checking Account : " + amount;
        return CheckingAccountBalance;
    }
    public double calcSavingsWithdraw(double amount) {
        SavingsAccountBalance = SavingsAccountBalance - amount;
        savingsAccTransactionHistory += "\nAmount debited from your Savings Account : " + amount;
        return SavingsAccountBalance;
    }
    public double calcCheckingDeposit(double amount) {
        CheckingAccountBalance = (CheckingAccountBalance + amount);
        checkingAccTransactionHistory += "\nAmount credited to your Checking Account : " + amount;
        return CheckingAccountBalance;
    }
    public double calcSavingsDeposit(double amount) {
        SavingsAccountBalance = SavingsAccountBalance + amount;
        savingsAccTransactionHistory += "\nAmount credited to your Savings Account : " + amount;
        return SavingsAccountBalance;
    }
    public String getCheckingAccTransactionHistory() {
        return checkingAccTransactionHistory;
    }
    public String getSavingsAccTransactionHistory() {
        return savingsAccTransactionHistory;
    }
}