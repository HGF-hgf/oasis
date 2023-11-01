public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 5000.0;
    private static final double MAX_WITHDRAW_AMOUNT = 1000.0;

    /**
     * abc.
     */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * abc.
     */
    @Override
    public void deposit(double amount) {
        try {
            if (amount < 0) {
                throw new InvalidFundingAmountException(amount);
            }
            doDepositing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
            if (balance - amount < MIN_BALANCE) {
                throw new InsufficientFundsException(amount);
            }
            if (amount > MAX_WITHDRAW_AMOUNT) {
                throw new InvalidFundingAmountException(amount);
            }
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
