package autocustomer;

public class AutoCustomer {
    private String customerType;
    private double invoiceTotal;
    private double dNewInvTotal;

    // Constructor
    public AutoCustomer(String customerType, double invoiceTotal) {
        this.customerType = customerType;
        this.invoiceTotal = invoiceTotal;
        this.dNewInvTotal = 0;
    }

    // Method to calculate discount based on customer type
    public double calculateDiscount() {
        if (customerType.equalsIgnoreCase("employee")) {
            dNewInvTotal = invoiceTotal * 0.92;  // 8% discount for employees
        } else if (customerType.equalsIgnoreCase("manager")) {
            dNewInvTotal = invoiceTotal * 0.88;  // 12% discount for managers
        } else {
            dNewInvTotal = invoiceTotal;  // No discount for other customer types
        }
        return dNewInvTotal;
    }
}
