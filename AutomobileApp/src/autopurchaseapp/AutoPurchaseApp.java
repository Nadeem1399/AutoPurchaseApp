package autopurchaseapp;

import javax.swing.*;

import autocustomer.AutoCustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoPurchaseApp {
    public static void main(String[] args) {
        // Create a JFrame for the GUI
        JFrame frame = new JFrame("Automobile Purchase Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Customer Type Label and Input Field
        JLabel labelCustomerType = new JLabel("Enter Customer Type (Employee/Manager):");
        labelCustomerType.setBounds(10, 20, 250, 25);
        frame.add(labelCustomerType);

        JTextField customerTypeField = new JTextField();
        customerTypeField.setBounds(250, 20, 120, 25);
        frame.add(customerTypeField);

        // Invoice Total Label and Input Field
        JLabel labelInvoiceTotal = new JLabel("Enter Invoice Total ($):");
        labelInvoiceTotal.setBounds(10, 60, 200, 25);
        frame.add(labelInvoiceTotal);

        JTextField invoiceTotalField = new JTextField();
        invoiceTotalField.setBounds(250, 60, 120, 25);
        frame.add(invoiceTotalField);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate Discount");
        calculateButton.setBounds(100, 100, 200, 30);
        frame.add(calculateButton);

        // Result Label
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 150, 350, 25);
        frame.add(resultLabel);

        // ActionListener for Calculate Button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the input values
                    String customerType = customerTypeField.getText().trim();
                    double invoiceTotal = Double.parseDouble(invoiceTotalField.getText().trim());

                    // Create an AutoCustomer object
                    AutoCustomer customer = new AutoCustomer(customerType, invoiceTotal);

                    // Calculate the new invoice total with the discount
                    double newInvoiceTotal = customer.calculateDiscount();

                    // Display the result in the GUI
                    resultLabel.setText(String.format("Discounted Invoice Total: $%.2f", newInvoiceTotal));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter valid data for invoice total.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
