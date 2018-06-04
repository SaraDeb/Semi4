
package integration;
import model.Receipt;

/**
 * the printer to be used for printing receipt.
 */

public class Printer {
    
    /**
     * prints receipt.
     * @param receipt , what will be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.createReceiptString());  
    }
}
