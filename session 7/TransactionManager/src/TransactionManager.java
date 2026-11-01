import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class TransactionManager {
    private int balance = 1000000;

    private ArrayList<Integer> transactions = new ArrayList<>();
    private Stack<Integer> transactionStack = new Stack<>();
    private Queue<Integer> transactionQueue = new LinkedList<>();

    public int getBalance() {
        return balance;
    }


    private void addTransaction(int amount) {
        transactions.add(amount);
        transactionStack.push(amount);
        transactionQueue.offer(amount);
    }


    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        balance += amount;
        addTransaction(amount);
        System.out.println("Deposit successful.");
    }


    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance: " + balance);
        } else {
            balance -= amount;
            addTransaction(-amount);
            System.out.println("Withdrawal successful.");
        }
    }


    public void showTotalDeposits() {
        int total = 0;

        for (int amount : transactions) {
            if (amount > 0) {
                total += amount;
            }
        }

        System.out.println("Total Deposits: " + total);
    }


    public void showTotalWithdrawals() {
        int total = 0;

        for (int amount : transactions) {
            if (amount < 0) {
                total += -amount;
            }
        }

        System.out.println("Total Withdrawals: " + total);
    }


    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (int i = 0; i < transactions.size(); i++) {
            int amount = transactions.get(i);

            if (amount > 0) {
                System.out.println((i + 1) + ". Deposit: " + amount);
            } else {
                System.out.println((i + 1) + ". Withdrawal: " + (-amount));
            }
        }
    }


    public void showLatestTransaction() {
        if (transactionStack.empty()) {
            System.out.println("No transactions yet.");
            return;
        }

        int amount = transactionStack.peek();

        System.out.println("Latest transaction: " +
            (amount > 0 ? "Deposit " : "Withdrawal ") +
            Math.abs(amount));
    }

    public void showQueue() {
        if (transactionQueue.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (int amount : transactionQueue) {
            System.out.println(
                (amount > 0 ? "Deposit: " : "Withdrawal: ")
                + Math.abs(amount)
            );
        }
    }
}
