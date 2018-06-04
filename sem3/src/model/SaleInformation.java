package model;

/**
 * contains information for the price, description and total cost.
 */
public class SaleInformation {
	private final int price;
	private final String descript;
	private final int runningTotal;
	
	/**
	 * 
	 * @param price for the item
	 * @param descript description for the item
	 * @param runningTotal total cost for the items
	 */
	public SaleInformation(int price, String descript, int runningTotal) {
		this.price = price;
		this.descript = descript;
		this.runningTotal = runningTotal;
	}
	
        @Override
	public String toString() {
            return price + ", " + descript + ", " + runningTotal;
	}
}
