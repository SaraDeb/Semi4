package controller;

import model.Sale;
import model.Receipt;
import integration.Printer;
import integration.ItemDTO;
import integration.RegistryCreator;
import integration.ItemRegistry;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.InvalidPaymentException;
import model.RevenueObserver;

/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private Sale sale;
    private ItemRegistry itemRegistry;
    private ExternalAccountingSystem accounting;
    private ExternalInventorySystem inventory;
    private Printer printer;
    private RevenueObserver revenueObserver;
    private final List <RevenueObserver> revenueObservers = new ArrayList<>();
    
    /**
     * new instances are created here,
     * @param regCreator creates registers
     * @param printer prints the recipt
     * @param inventory used for external inventory system.
     * @param accounting  uded for external accounting system.
     */
    public Controller(RegistryCreator regCreator, Printer printer, ExternalInventorySystem inventory, ExternalAccountingSystem accounting) {
    	this.itemRegistry = regCreator.getItemRegistry();
        this.printer = printer;
        this.accounting = new ExternalAccountingSystem();
        this.inventory = new ExternalInventorySystem();
        
    }
    
    /**
     * creates instance with registry
     * @param regCreator creates register
     */
    public Controller(RegistryCreator regCreator) {
    	this.itemRegistry = regCreator.getItemRegistry();
    }
    
    /**
     * Creates an empty instance of {@link Sale}, which will be used for all information regarding
     * the sale that is now started.
     * The specified observer will be notified when a sale has started.
     */
   // public void startSale(RevenueObserver revenueObserver) {
    
    public void startSale (){    
    sale = new Sale();
        for(RevenueObserver revnueObserver: revenueObservers)
        {
        sale.addRevenueObserver(revnueObserver);
    }
    
    }
    /**
     * After itemID is entered, it will find the matching item and returns information about the sale.
     * @param itemID id for the items. 
     * @return Updated sale information, price and description.
     */
    public String enterItemID(String itemID)throws ItemNotFoundException {
    	ItemDTO registeredItem = itemRegistry.findItem(itemID);
    	return sale.addItem(registeredItem);
    }
    
    
    /**
    * Thrown when the specified identifier is found
    */
    
    
    
    /**
     * Takes an entered itemID with quantity and then finds the matching item to Sale
     * @param itemID id for the items. 
     * @param quantity the amount of item the customer bought
     * @return Updated sale information
     */ 
        public String enterItemIDAndQuantity(String itemID, int quantity) throws ItemNotFoundException {
        ItemDTO registeredItem = itemRegistry.findItem(itemID);
        return sale.addItems(registeredItem, quantity);
    }
    
    /**
     * calculates the tax after item registration.
     * @return the total calculated tax.
     */
    public double indicateAllItemsRegistered() {
        return sale.calculateTaxes();
    }
    
    
    /**
     * the amount paid cash, calculates the change and print a receipt.
     * @param paidAmount amount of money that will be payed
     * @return  the change after the payment
     */
    public int enterPaidCash(int paidAmount) throws InvalidPaymentException {
        int changeAmount = sale.calculateChange(paidAmount);
        //System.out.println(new Receipt(sale).createReceiptString());
        sale.printReceipt(printer);
 
        accounting.bookKeep(sale);
        inventory.UpdateInventory(sale);
        return changeAmount;
    }
    
  
    
    public void addRevenueObserver(RevenueObserver revenueObserver) {
    revenueObservers.add(revenueObserver);
    }
}
