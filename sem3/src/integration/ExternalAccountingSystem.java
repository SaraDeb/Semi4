
package integration;
import model.Sale;


public class ExternalAccountingSystem {
    private Sale sale;
    
    
    /**
     * information is sent to bookkeep,
     * @param sale, the sale
     */
    public void bookKeep(Sale sale) {
        this.sale = sale;
    }
}
