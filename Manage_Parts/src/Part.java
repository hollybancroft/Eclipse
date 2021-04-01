//Holly Bancroft
//6/20/2020
public class Part {

	private int partID;
	private String partDescription;
	private double partSellPrice;
	
	public static final int DEFAULT_ID = 0;
	public static final String DEFAULT_DESCRIPTION = "no part description";
	public static final double DEFAULT_SELL_PRICE = 0;
	
	public Part(int ID, String desc, double newSellPrice) {
		
		this.partID = DEFAULT_ID;
		this.partDescription = DEFAULT_DESCRIPTION;
		this.partSellPrice = DEFAULT_SELL_PRICE;
		
		this.setPartID(ID);
		this.setPartDescription(desc);
		this.setPartSellPrice(newSellPrice);
		
	}
	
	public Part(int ID) {
		this(ID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE);
	}
	
	public double getTotalCost() {
		return 0;
	}
	
	public int getPartID() {
		return partID;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public double getPartSellPrice() {
		return partSellPrice;
	}
	
	public void setPartID(int newId) {
		if(newId >= 0) {
			this.partID = newId;
		}
	}
	
	public void setPartDescription(String newDesc) {
		if(newDesc != null && newDesc.length() > 0) {
			this.partDescription = newDesc;
		}
	}
	
	public void setPartSellPrice (double newSellPrice) {
		if(newSellPrice >= 0) {
			this.partSellPrice = newSellPrice;
		}
	}
	
	
	
	
	@Override
	public String toString() {
		return getClass() + " Part ID: " + partID + " Part Description: " + partDescription + " Sell Price: " + partSellPrice;
		
	}
	
	
	
}
