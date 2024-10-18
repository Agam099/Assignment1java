// Sale.java
package src.com.example.sales;

import java.time.LocalDate;

public class Sale {
    private int saleId;
    private LocalDate saleDate;
    private String customerName;
    private double totalAmount;

    public Sale(int saleId, LocalDate saleDate, String customerName, double totalAmount) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}