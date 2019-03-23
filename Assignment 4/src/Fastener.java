import java.io.*;

public abstract class Fastener extends isValid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String[] materials = {"Brass", "Stainless Steel", "Steel"};
	private String material;
	
	private String[] steelFinishes = {"Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc", "Bright"};
	private String[] brassAndStainlessSteelFinishes = {"Plain"};
	private String[] steelScrewFinishes = {"Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc", "Black Phosphate", "ACQ 1000 Hour", "Lubricated"};
	private String finish;
	
	private double unitPrice;
	
	private int numberPerUnit;
	
	// fastener constructor
	public Fastener(String mat, String fin, double price, int fasteners) throws IllegalFastener {
		setMaterial(mat);
		setFinish(mat, fin);
		setUnitPrice(price);
		setNumberPerUnit(fasteners);
	} // end fastener constructor
	
	// material constructor
	private void setMaterial(String mat) throws IllegalFastener {
		if (!(isIn(mat, materials)))
			throw new IllegalFastener("Invalid material");
		else
			this.material = mat;
	} // end material constructor
	
	// finish constructor
	private void setFinish(String mat, String fin) throws IllegalFastener {
		if ((mat.equals("Brass") || mat.equals("Stainless Steel")) && (isIn(fin, brassAndStainlessSteelFinishes)))
			this.finish = fin;
		else if (mat.equals("Steel") && (isIn(fin, steelFinishes)))
			this.finish = fin;
		else if (mat.contentEquals("Steel") && (isIn(fin, steelScrewFinishes)))
			this.finish = fin;
		else
			throw new IllegalFastener("Invalid finish");
	} // end finish constructor
	
	// unitPrice constructor
	private void setUnitPrice(double price) throws IllegalFastener {
		if (price < 0)
			throw new IllegalFastener("Invalid unit price");
		else this.unitPrice = price;
	} // end unitPrice constructor
	
	// numberPerUnit constructor
	private void setNumberPerUnit(int fasteners) throws IllegalFastener {
		if ((fasteners < 1) || (fasteners > 10000))
			throw new IllegalFastener("Number of fasteners must be between 1 and 10000");
		if ((fasteners != 1) && (fasteners % 5 != 0))
			throw new IllegalFastener("Number of fasteners must either be one or be divisible by 5");
		else
			this.numberPerUnit = fasteners;
	} // end numberPerUnit constructor
	
	// getOrderCost accessor
	public double getOrderCost(int orderSize) {
		double cost = orderSize * unitPrice;
		return cost;
	} // end getOrderCost accessor
	
	@Override
	public String toString() {
		
		String orderString = material + ", with a " + finish + " finish. " + numberPerUnit + " in a unit, " + unitPrice + " per unit.";
		
		return orderString;
	} // end toString
	
} // end fastener class
