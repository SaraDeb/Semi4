
package integration;
import model.Sale;


public class ExternalInventorySystem {
    private Sale sale;
    
    /**
     * it updates the inventory, i.e information about the sale that will be sent to External InventorySystem
     * @param sale , the sale
     */
    public void UpdateInventory(Sale sale) {
        this.sale = sale;
    }
}
