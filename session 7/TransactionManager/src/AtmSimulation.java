import java.util.Scanner;

public class AtmSimulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TransactionManager atm = new TransactionManager();

        int menu;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check Balance");
            System.out.println("4. Total Deposits");
            System.out.println("5. Total Withdrawals");
            System.out.println("6. Transaction History");
            System.out.println("7. Latest Transaction (Stack)");
            System.out.println("8. Transactions in Order (Queue)");
            System.out.println("0. Exit");
            System.out.print("Select Menu: ");

            menu = input.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Input amount: ");
                    atm.deposit(input.nextInt());
                    break;
                case 2:
                    System.out.print("Input amount: ");
                    atm.withdraw(input.nextInt());
                    break;
                case 3:
                    System.out.println("Balance: " + atm.getBalance());
                    break;
                case 4:
                    atm.showTotalDeposits();
                    break;
                case 5:
                    atm.showTotalWithdrawals();
                    break;
                case 6:
                    atm.showTransactions();
                    break;
                case 7:
                    atm.showLatestTransaction();
                    break;
                case 8:
                    atm.showQueue();
                    break;
                case 0:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid menu.");
            }
        } while (menu != 0);

        input.close();
    }
}
