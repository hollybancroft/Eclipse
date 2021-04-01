//Holly Bancroft
//6/20/2020
public class PurchasedPart extends Part {

	private double handlingCost;
	private double purchasePrice;
	private String vendor;
	
	public static final String DEFAULT_VENDOR_NAME  = "no vendor name";
	public static final double DEFAULT_PURCHASE_PRICE = 0;
	public static final double DEFAULT_HANDLING_COST = 0;
	
	public PurchasedPart(int newID) {
		this(newID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_HANDLING_COST, 
				DEFAULT_PURCHASE_PRICE, DEFAULT_VENDOR_NAME);		
	}
	
	public PurchasedPart(int newID, double newHandlingCost, double newPurchPrice, String newVendor) {
		this(newID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, newHandlingCost, newPurchPrice, newVendor);
	}
	
	public PurchasedPart (int newID, String newDesc, double newSellPrice, double newHandlingCost,
			double newPurchPrice, String newVendor) {
		
		super(newID, newDesc, newSellPrice);
		
		this.handlingCost = DEFAULT_HANDLING_COST;
		this.purchasePrice = DEFAULT_PURCHASE_PRICE;
		this.vendor = DEFAULT_VENDOR_NAME;
		
		this.setHandlingCost(newHandlingCost);
		this.setPurchasePrice(newPurchPrice);
		this.setVendor(newVendor);
	}
	
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + purchasePrice + handlingCost;
	}
	
	public double getHandlingCost() {
		return handlingCost;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setHandlingCost(double newHandlingCost) {
		if(newHandlingCost >= 0) {
			this.handlingCost = newHandlingCost;
		}
	}
	
	public void setPurchasePrice(double newPurchPrice) {
		if (newPurchPrice >= 0) {
			this.purchasePrice = newPurchPrice;
		}
		
	}
	
	public void setVendor(String newVendor) {
		if(newVendor != null && newVendor.length() > 0) {
			this.vendor = newVendor;
		}
	}
	
	@Override
	public String toString() {
		
		return super.toString() + getClass() +
				" Handling Cost: " + handlingCost + " Purchase Price" + 
		purchasePrice + " Vendor: " + vendor;
	}
}

