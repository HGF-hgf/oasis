import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    /**
     * abc.
     */
    public Customer() {
        this.idNumber = 0;
        this.fullName = "";
    }

    /**
     * abc.
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * abc.
     */
    public long getIdNumber() {
        return this.idNumber;
    }

    /**
     * abc.
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * abc.
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * abc.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * abc.
     */
    public List<Account> getAccountList() {
        return this.accountList;
    }

    /**
     * abc.
     */
    public void addAccount(Account account) {
        this.accountList.add(account);
    }

    /**
     * abc.
     */
    public void removeAccount(Account account) {
        this.accountList.remove(account);
    }

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("D:/java/bank/bank.txt");
            Bank bank = new Bank();
            bank.readCustomerList(inputStream);
            // Create a new Account
            System.out.println(bank.getCustomerList().size());
            // Add some transactions to the account
            Customer customer = new Customer(123456789, "Nguyễn Thị A");
            //customer.removeAccount(customer.getAccountList().get(0));
            System.out.println(customer.getAccountList().size());
//            Transaction depositTransaction = new Transaction(2,5000.0, 1000.0, 6000.0);
//            account.addTransaction(depositTransaction);
//            account.doDepositing(1000.0);
//
//            Transaction withdrawTransaction = new Transaction(3, 6000.0,500.0, 5500.0);
//            account.addTransaction(withdrawTransaction);
//            account.doWithdrawing(500.0);
//
//            // Get the transaction history
//            String transactionHistory = account.getTransactionHistory();
//            System.out.println(transactionHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}