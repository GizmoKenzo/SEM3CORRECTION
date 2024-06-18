package model;

import java.util.List;

/**
* Contains information about the one particular sale.
*/
public class SaleDTO {
    private List<ItemDTO> items;
    private double totalPrice;
    private double totalVAT;

     /**
     * Creates a new instance representing a sale.
     * 
     * @param items list of items in the sale.
     * @param totalPrice the total price of the sale including VAT.
     * @param totalVAT the total VAT of the sale.
     */
    public SaleDTO(List<ItemDTO> items, double totalPrice, double totalVAT) {
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
    }

     /**
     * Returns the list of items in the sale.
     *
     * @return the list of items.
     */
    public List<ItemDTO> getItems() {
        return items;
    }

     /**
     * Returns the total price of the sale.
     *
     * @return the total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

     /**
     * Returns the total VAT of the sale.
     *
     * @return the total VAT.
     */
    public double getTotalVAT() {
        return totalVAT;
    }

     /**
     * Returns a string representation of the particular sale.
     * The string includes details of the items, total price and total VAT.
     *
     * @return string representing the details of the sale.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Sale Details:\n");
        string.append("Items:\n");
        for (ItemDTO item : items) {
            string.append(item.toString()).append("\n");
        }
        string.append(String.format("Total Price (including VAT): %.2f SEK\n", totalPrice));
        string.append(String.format("Total VAT: %.2f SEK\n", totalVAT));
        return string.toString();
    }
}

