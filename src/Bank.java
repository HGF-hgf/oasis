import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * abc.
     */
    public void readCustomerList(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            Customer customer = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (!isNumeric(parts[0])) {
                    if (customer != null) {
                        customerList.add(customer);
                    }
                    String name = parts[0] + " " + parts[1] + " " + parts[2];
                    String id = parts[3];
                    long id2 = (long) Double.parseDouble(id);
                    customer = new Customer(id2, name);
                } else {
                    String accountString = parts[0];
                    long accountNumber = Long.parseLong(accountString);
                    String accountType = parts[1];
                    String balanceString = parts[2];
                    double balance = Double.parseDouble(balanceString);
                    if (accountType.equals("CHECKING")) {
                        assert customer != null;
                        customer.addAccount(new CheckingAccount(accountNumber, balance));
                    } else if (accountType.equals("SAVINGS")) {
                        assert customer != null;
                        customer.addAccount(new SavingsAccount(accountNumber, balance));
                    }
                }
            }
            if (customer != null) {
                customerList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * abc.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparing(Customer::getIdNumber));
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customerList) {
            sb.append("Số CMND: ").append(customer.getIdNumber()).append(". Họ tên: ")
                    .append(customer.getFullName()).append(".\n");
        }
        return sb.toString();
    }

    /**
     * abc.
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort(Comparator.comparing(Customer::getFullName));
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customerList) {
            sb.append("Số CMND: ").append(customer.getIdNumber()).append(". Họ tên: ")
                    .append(customer.getFullName()).append(".\n");
        }
        return sb.toString();
    }

    /**
     * abc.
     */
    List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * abc.
     */

    public boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
