package view;

import controller.Controller;
import model.*;

/**
 * This program has no view, instead
 * this class is a placeholder for the entire view.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance. 
     *
     * @param contr The controller that is used for all operations.
     */
    public View(Controller contr)
    {
        this.contr = contr;
    }

    /**
     * Simulates user interactions that trigger all
     * system operations.
     */
    public void runSale(){
    	System.out.println("Sale have now started:");
        System.out.println("");
        contr.startingSale();

        int itemID = 345031;
        ItemDTO item1 = new ItemDTO(itemID, "TOMATO", "Fresh organic tomatoes", 1, new AmountOfMoney(15.00), 5.0);
        ItemDTO scannedItem = contr.scanItem(item1);
        System.out.println("Scanning item: \n" + scannedItem);
        System.out.println(contr.showVatForEveryItem() + "\n");
        System.out.println("");

        System.out.println("Increasing quantity on the same item just scanned:");
        contr.increaseAmountSoldItem(new ItemDTO(345031, "TOMATO", "Fresh organic tomatoes", 1, new AmountOfMoney(15.00), 5.0));
        
        System.out.println(scannedItem);
        System.out.println(contr.showVatForEveryItem() + "\n");
        System.out.println("");

        ItemDTO item2 = new ItemDTO(345032, "WATERMELON", "Juicy summer watermelon", 1, new AmountOfMoney(29.90), 6.0);
        ItemDTO scannedAnotherItem = contr.scanItem(item2);
        System.out.println("Scanning item: \n" + scannedAnotherItem);
        System.out.println(contr.showVatForEveryItem() + "\n");
        System.out.println("");
        
        ChangeDTO changeDetails = contr.initiatePayment(new AmountOfMoney(100));
        System.out.println("Payment of " + changeDetails.getAmountReceived() + " received. Change: " + changeDetails.getChange() + " SEK");

        contr.completeSale();

        System.out.println(contr.recordTransaction());
        System.out.println(contr.notifyAccounting());
        System.out.println(contr.notifyInventoryRegistry());
    }
}