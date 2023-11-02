import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /**
     * abc.
     */
    public Account() {
        this.accountNumber = 0;
        this.balance = 0;
    }

    /**
     * abc.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * abc.
     */
    public long getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * abc.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * abc.
     */
    public void doWithdrawing(double amount) throws InsufficientFundsException, InvalidFundingAmountException {
            if (amount < 0) {
                throw new InvalidFundingAmountException(amount);
            } else if (amount > this.balance) {
                throw new InsufficientFundsException(amount);
            }
            this.balance -= amount;
        }

    /**
     * abc.
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            this.balance += amount;
        }
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    /**
     * abc.
     */
    public String getTransactionHistory() {
        StringBuilder result = new StringBuilder("Lịch sử giao dịch của tài khoản "
                + this.accountNumber + ":\n");
        for (Transaction transaction : this.transactionList) {
            result.append(transaction.getTransactionSummary()).append("\n");
        }
        return result.toString();
    }

    /**
     * abc.
     */
    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
    }

    /**
     * abc.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}