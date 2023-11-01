public class CheckingAccount extends Account {
    /**
     * abc.
     */
    public CheckingAccount(long accountNumber, double balance) {
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

    /**
     * abc.
     */
    @Override
    public void withdraw(double amount) {
        try {
            if (amount < 0) {
                throw new InvalidFundingAmountException(amount);
            }
            doWithdrawing(amount);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
