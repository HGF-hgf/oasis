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

}