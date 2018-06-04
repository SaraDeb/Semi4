package model;

import java.time.LocalDateTime;
import integration.ItemDTO;
import integration.Printer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
/**
 * Collects all information regarding a particular sale.
 */
public class Sale {
    private final LocalDateTime saleTime;
    private List<ItemDTO> registeredItems = new ArrayList<>();
    private int runningTotal;
    private int changeAmount;
    private List <RevenueObserver> revenueObservers = new ArrayList<>();
    private double totalTaxes;
    
    /**
     * Creates a new instance, and records the time it was created. This will be the time recorded
     * on the receipt.
     */
    public Sale() {
        saleTime = LocalDateTime.now();
        runningTotal = 0;
    }
    
    public void addRevenueObserver(RevenueObserver revenueObserver) {
    revenueObservers.add(revenueObserver);
 }
    
    /**
     * notify the observer to update the total amount.
     */
    
    private void notifyObservers() {
    for (RevenueObserver revenueObserever : revenueObservers){
         revenueObserever.updateRevenue(runningTotal);
 }
    }
    
    


    /**
     * Checks if an item exists in registeredItems.
     * @param itemToFind the item that will be checked.
     * @return whether or not an item in the current sale has the same ID as itemToCheck.
     */
    private boolean itemExists(ItemDTO itemToCheck){
        for (ItemDTO currentItem : registeredItems)
            if (itemToCheck.equals(currentItem))
                return true;
        return false;
    }
    
    /**
     * Gets the item in the current sale with the same ID as itemToFind.
     * @param itemToFind the item that is to be found.
     * @return the current item.
     */
    private ItemDTO findItem(ItemDTO itemToFind) {
        for (ItemDTO currentItem : registeredItems)
                if (itemToFind.equals(currentItem))
                return currentItem;
        return null;
    }
    
    /**
     * Updates the quantity of an item in the current sale.
     * @param registeredItem the item to update the quantity.
     * @param quantity the new quantity of the item.
     */
    private void updateQuantity(ItemDTO registeredItem, int quantity) {
         registeredItems.set(registeredItems.indexOf(findItem(registeredItem)), new ItemDTO(registeredItem, findItem(registeredItem).getQuantity() + quantity));
    }
    
    /**
     * Increases and updates the list by holding registered items of the current sale and adding a new item to it. 
     * @param registeredItem the item to be added to the current sale
     * @return the information of the latest registered item's price, description, current running total
     */
    public String addItem(ItemDTO registeredItem) {
        if (!itemExists(registeredItem)){
            runningTotal += registeredItem.getPrice();
            registeredItems.add(registeredItem);
        }
        else {
            runningTotal += registeredItem.getPrice();
            updateQuantity(registeredItem, 1);
        }
    	SaleInformation newSaleInfo = new SaleInformation(registeredItem.getPrice(), registeredItem.getDescription(), runningTotal);
    	return newSaleInfo.toString();
    }
    
    /**
     * additems for more than one item.
     * @param registeredItem items that wil be added to the current sale.
     * @param quantity the amount of items in the current sale
     * @return info of the item's price and description, and running total
     * 
     */
        
    public String addItems(ItemDTO registeredItem, int quantity) {
        if (!itemExists(registeredItem)){
            runningTotal += registeredItem.getPrice() * quantity;
            registeredItems.add(new ItemDTO(registeredItem, quantity));
        }
        else {
            runningTotal += registeredItem.getPrice() * quantity;
            updateQuantity(registeredItem, quantity);
        }
    	SaleInformation newSaleInfo = new SaleInformation(registeredItem.getPrice(), registeredItem.getDescription(), runningTotal);
    	return newSaleInfo.toString();
    }
    
    /**
     * the tital taxes calculated.
     * @return totaltaxes
     * 
     */
    public double calculateTaxes() {
        double totalTaxes = 0;
        for (ItemDTO currentItem : registeredItems) {
            totalTaxes += currentItem.getPrice() * currentItem.getTax() * currentItem.getQuantity();
        }
        return totalTaxes;
    }
    
    
    /**
     * It calculates the change the customer will get, i.e "the amount the customer paid minus- the price 
     * @param paidAmount
     * @return changeAmount
     */
    public int calculateChange(int paidAmount) throws InvalidPaymentException {
      if (paidAmount - runningTotal < 0)  {   
      throw new InvalidPaymentException (paidAmount, runningTotal);
     
      }
       notifyObservers();
        return changeAmount = paidAmount - runningTotal;
       
       // return changeAmount;
    }
    
    
    /**
     * Print the receipt for the payment
     * @param printer 
     */
    public void printReceipt (Printer printer) {
        Receipt receipt = new Receipt(this);
        printer.printReceipt(receipt);
    }
    
    /**
     * get the total price
     * @return runnigTotal
     */
    public int getRunningTotal() {
        return runningTotal;
    }
    /**
     * get the change after the payment
     * @return changeAmount
     */
    public int getChange() {
        return changeAmount;
    }
   
    
    /**
    * @return the total taxes.
    **/  
    public double getTotalTaxes(){
    return totalTaxes;    
    }
    /**
     * checks in the array those items that are wanted
     * @return itemArray
     */
   /* public ItemDTO[] getItems() {
        ItemDTO[] itemArray = new ItemDTO[registeredItems.size()];
        for (int i = 0; i < registeredItems.size(); i++) {
            itemArray[i] = registeredItems.get(i);
        }
        return itemArray;
    }*/
    
  
    
    /**
     * @return the item that are registered.
     */
    public List<ItemDTO> getItems(){
        return registeredItems;
        }
    
    /**
     * @return the sale time, when the sale has started
     */
    public LocalDateTime getSaleTime() {
        return saleTime;
    }
}
