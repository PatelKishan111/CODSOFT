import java.util.*;

class user_bank_account {

    int balance = 1000;

    void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance for withdrawal");
        } else {
            balance -= amount;
            if (balance < 300) {
                System.out.println("Maintain minimum balance of 300");
            } else {
                System.out.println("Withdraw Successful!!");
            }
        }
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit Successful!!");
    }

    void check_balance() {
        System.out.println("Your balance: " + balance);
    }
}

class ATM extends user_bank_account {

    private int input;

    void choice() {

        Scanner ans = new Scanner(System.in);

        System.out.println("Select the choice:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");

        try {
            input = ans.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter the value in integer");
            System.out.println();
            choice();
        }

        try {
            switch (input) {
                case 1:
                    System.out.println("Enter the amount you want to withdraw");
                    int withdraw_amount = ans.nextInt();
                    if (withdraw_amount > 7000) {
                        System.out.println("Limit of withdrawal at a time is 5000");
                        System.out.println();
                        choice();
                    }
                    super.withdraw(withdraw_amount);
                    System.out.println();
                    choice();

                case 2:
                    System.out.println("Enter the amount you want to deposit");
                    int deposit_amount = ans.nextInt();
                    if (deposit_amount > 10000) {
                        System.out.println("Limit of deposit at a time is 10000");
                        System.out.println();
                        choice();
                    }
                    super.deposit(deposit_amount);
                    System.out.println();
                    choice();

                case 3:
                    super.check_balance();
                    System.out.println();
                    choice();

                case 4:
                    System.out.println("Thank You for Visiting!! ");
                    System.exit(0);

                default:
                    System.out.println("Enter the correct choice\n");
                    choice();
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter the Integer value\n");
            choice();
        }
    }
}

public class atm_interface {
    public static void main(String[] args) {
        ATM a1 = new ATM();
        a1.choice();
    }
}