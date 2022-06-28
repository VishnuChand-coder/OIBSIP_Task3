import java.util.Scanner;
import java.util.HashMap;
import java.io.IOException;
import java.text.DecimalFormat;
public class AtmMenu extends Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat amountFormat = new DecimalFormat("0.00");
    HashMap<Integer, Integer> customerNumAndPin = new HashMap<Integer, Integer>();
    public void getLogin() throws IOException {
        int a = 1;
        do {
            try {
                //customerNumAndPin.put(1231234, 5234);
                System.out.println("\n\n\t\t******-- Welcome to ATM --******");
                System.out.println("1. New User(I don't have credentials to login)");
                System.out.println("2. Old User(I have my own credentials to login)");
                System.out.println("Enter your choice: ");
                int userChoice = input.nextInt();
                if(userChoice==1) {
                    System.out.println("Kindly Generate your own credentials");
                    System.out.println("Enter your customer Number: ");
                    int custNum = input.nextInt();
                    System.out.println("Generate your PIN Number: ");
                    int pinNum = input.nextInt();
                    customerNumAndPin.put(custNum, pinNum);
                }
                System.out.println("Enter your Customer Number: ");
                setCustomerNumber(input.nextInt());
                System.out.println("Enter your PIN Number: ");
                setPINNumber(input.nextInt());
            } catch(Exception e) {
                System.out.println("\nInvalid Character(s). Kindly enter numbers only..\n");
                a=2;
            }
            int customerNumber = getCustomerNumber();
            int pinNumber = getPINNumber();
            if(customerNumAndPin.containsKey(customerNumber) && customerNumAndPin.get(customerNumber)==pinNumber) {
                getAccoutType();
            } else {
                System.out.println("\n\t-----Ivalid login Credentials-----\n");
                System.out.println("Kindly Enter your login credentials accurately\n");
            }
        } while(a==1);
    }
    public void getAccoutType() {
        System.out.println("Choose any one of the following accounts which you want to access(Select 0 to exit): ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("0. Exit");
        int selectedOption = input.nextInt();
        switch(selectedOption) {
            case 0:
                System.out.println("Thank You for using ATM, visit again!!");
                System.exit(0);
                break;
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            default:
                System.out.println("\n\t#####--INVALID CHOICE--#####\n");
                getAccoutType();
        }
    }
    public void getChecking() {
        System.out.println("-----Checking Account-----");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transaction History");
        System.out.println("0. Exit");
        System.out.println("\nPlease Enter your choice(Enter 0 to exit): ");
        int selected = input.nextInt();
        switch(selected) {
            case 0:
                System.out.println("Thank You for using ATM, visit again!!");
                System.exit(0);
                break;
            case 1:
                System.out.println("Checking Account Balance: " + amountFormat.format(getCheckingBalance()));
                getAccoutType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccoutType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccoutType();
                break;
            case 4:
                System.out.println(getCheckingAccTransactionHistory());
                System.out.println("Checking Account Balance: " + amountFormat.format(getCheckingBalance()));
                getAccoutType();
                break;
            default:
                System.out.println("\n\t#####--INVALID CHOICE--#####\n");
                getChecking();
        }
    }
    public void getSaving() {
        System.out.println("-----Savings Account-----");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Transaction History");
        System.out.println("0. Exit");
        System.out.println("\nPlease Enter your choice(Enter 0 to exit): ");
        int choice = input.nextInt();
        switch(choice) {
            case 0:
                System.out.println("Thank You for using ATM, visit again!!");
                System.exit(0);
                break;
            case 1:
                System.out.println("Savings Account Balance: " + amountFormat.format(getSavingBalance()));
                getAccoutType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccoutType();
                break;
            case 3:
                getSavingDepositInput();
                getAccoutType();
                break;
            case 4:
                System.out.println(getSavingsAccTransactionHistory());
                System.out.println("Saving Account Balance: " + amountFormat.format(getSavingBalance()));
                getAccoutType();
                break;
            default:
                System.out.println("\n\t#####--INVALID CHOICE--#####\n");
                getSaving();
        }
    }
}
