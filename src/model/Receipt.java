package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The receipt of a sale
 */
public class Receipt
{
    private SaleDTO sale;
    
    /**
     * Creates a new instance.
     *
     * @param sale The sale proved by this receipt.
     */
    public Receipt(SaleDTO sale)
    {
        this.sale = sale;
    }

    /**
     * Creates a formated string with the entire content of the receipt.
     *
     * @return The formatted receipt with details of sale.
     */
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("-".repeat(60) + "\n");
        receipt.append("-".repeat(60) + "\n");
        receipt.append("Beginning of receipt\n");
        receipt.append("-".repeat(60) + "\n");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime timeOfSale = LocalDateTime.now();
        receipt.append("Time of Sale: ").append(timeOfSale.format(timeFormatter)).append("\n\n");

        receipt.append(sale.toString()); 

        receipt.append("-".repeat(60)).append("\n");
        return receipt.toString();
    }
}
