//Holly Bancroft
//6/20/2020
public class ManufacturedPart extends Part {

	private double laborCost;
	private double materialCost;
	
	public static final double DEFAULT_LABOR_COST = 0;
	public static final double DEFAULT_MATERIAL_COST =  0;
	
	public ManufacturedPart(int newID) {
		this(newID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, DEFAULT_LABOR_COST, DEFAULT_MATERIAL_COST);
	}
	
	public ManufacturedPart(int newID, double newLaborCost, double newMaterialCost) {
		this(newID, DEFAULT_DESCRIPTION, DEFAULT_SELL_PRICE, newLaborCost, newMaterialCost);
	}
	
	public ManufacturedPart(int newID, String newDesc, double newSellPrice, double newLaborCost, double newMaterialCost) {
		
		super(newID, newDesc, newSellPrice);
		
		this.laborCost = DEFAULT_LABOR_COST;
		this.materialCost = DEFAULT_MATERIAL_COST;
		
		this.setLaborCost(newLaborCost);
		this.setMaterialCost(newMaterialCost);
		
	}
	@Override
	public double getTotalCost() {
		return super.getTotalCost() + laborCost + materialCost;
	}
	
	public double getLaborCost() {
		return laborCost;
	}
	
	public double getMaterialCost() {
		return materialCost;
	}
	
	public void setLaborCost(double newLaborCost) {
		if(newLaborCost >= 0) {
			this.laborCost = newLaborCost;
		}
	}
	
	public void setMaterialCost(double newMaterialCost) {
		if(newMaterialCost >= 0) {
			this.materialCost = newMaterialCost;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + getClass() + " Labor Cost: " + laborCost + 
				" Material Cost: " + materialCost;
	}
}
