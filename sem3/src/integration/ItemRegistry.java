package integration;

import java.util.ArrayList;
import java.util.List;


/**
 *creates a list for  all items in the store.
  */
public class ItemRegistry {
	private List<ItemDTO> items = new ArrayList<>();
	
	ItemRegistry() {
		addItems();
	}
	
	/**
	 * Finds an item in the registry with an identifier that matches the one entered by the cashier.
	 * @param itemID ,the id of the item that is entered. 
	 * @return The item in the registry with the matching id.
     * @throws integration.ItemRegistryException
	 */
        
      	public ItemDTO findItem(String itemID) throws ItemNotFoundException {
	
          	
            for (ItemDTO item : items) {
		if(item.getID().equals(itemID))
                    if(item.getID().equals("TE"))
                    throw new ItemRegistryException (itemID);
                            
                    else
                    return new ItemDTO(item);
		}
            
		throw new ItemNotFoundException(itemID);
	}
        
        
        /**
         * @param index, the index in the array where the items are taken from
         * @return the index
         */
        public ItemDTO getItem(int index){
            return items.get(index);
        }
	
	/**
	 * Adds items to the registry, in this case tee, cinnamon rolls and pepsi
         * 12% moms of the item,
	 */
	private void addItems() {
		items.add(new ItemDTO (10, "te", 0.12, "TE"));   
		items.add(new ItemDTO (15, "kanelbulle", 0.12, "KB")); 
		items.add(new ItemDTO (20, "pepsi", 0.12, "PS")); 
	}
}
