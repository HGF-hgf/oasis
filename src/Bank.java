import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * abc.
     */
    public void readCustomerList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer currentCustomer = null;

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    // Skip empty lines
                    continue;
                }

                if (isNumeric(line.substring(0, 1))) {
                    // This is account data
                    if (currentCustomer != null) {
                        String[] parts = line.split(" ");
                        long accountNumber = Long.parseLong(parts[0]);
                        String accountType = parts[1];
                        double balance = Double.parseDouble(parts[2]);
                        if (Objects.equals(accountType, Account.CHECKING)) {
                            currentCustomer.addAccount(new CheckingAccount(accountNumber, balance));
                            System.out.println(currentCustomer.getIdNumber() + " " + currentCustomer.getFullName());
                            ;
                        } else if (Objects.equals(accountType, Account.SAVINGS)) {
                            currentCustomer.addAccount(new SavingsAccount(accountNumber, balance));
                            System.out.println(currentCustomer.getIdNumber() + " " + currentCustomer.getFullName());
                        }
                    }
                } else {
                    // This is customer data
                    if (currentCustomer != null) {
                        customerList.add(currentCustomer);
                    }
                    String[] parts = line.split(" ");
                    String fullName = parts[0] + " " + parts[1] + " " + parts[2];
                    long idNumber = Long.parseLong(parts[3]);
                    currentCustomer = new Customer(idNumber, fullName);
                }
            }

            // Add the last customer, if any
            if (currentCustomer != null) {
                customerList.add(currentCustomer);
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
