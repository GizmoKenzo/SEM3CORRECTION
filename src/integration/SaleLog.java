package integration;

import model.ItemDTO;
import model.Sale;

/**
 * Handles the logging and processing of ongoing sales including
 * notifying the accounting system and notyfing inventory to update itself.
 */
public class SaleLog {
    private Accounting accounting; 
    private InventoryRegistry inventoryRegistry;

    /**
     * Creates a new instance.
     *
     * @param inventoryRegistry The inventory registry to be notified and updated.
     * @param accounting The accounting system to be notified.
     */
    public SaleLog(InventoryRegistry inventoryRegistry, Accounting accounting) {
        this.inventoryRegistry = inventoryRegistry;
        this.accounting = accounting;
    }

    /**
     * Processes a completed sale by recording the transaction,
     * notifying the accounting system and notyfing inventory to be updated.
     * 
     * @param sale The sale to be processed.
     */
    public void processSale(Sale sale) {
        
        recordTransaction(sale);
        notifyAccounting(sale);
        notifyInventoryRegistry(sale);
    }

    public String recordTransaction(Sale sale) {

        return "Transaction recorded for sale of total price: " + sale.calculateTotalPrice() + " SEK";
    }

    public String notifyAccounting(Sale sale) {
        return accounting.recordSaleTransaction(sale);
    }

    public String notifyInventoryRegistry(Sale sale) {
        StringBuilder inventoryString = new StringBuilder();
        for (ItemDTO item : sale.getItems()) {
            inventoryString.append(inventoryRegistry.updateInventorySystem(item)).append("\n");
        }
        return inventoryString.toString().trim();
    }
}

