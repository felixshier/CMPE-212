// Pizza class
public class Pizza implements java.io.Serializable {
	/**
	 * The Pizza class contains:
	 * two constructors (1 general) to construct pizzas 
	 * a toString method which describes the size and contents of a pizza
	 * a getCost accessor which calculates the cost of a pizza
	 * an equals method to determine equality of all attributes
	 * and a Clone method that clones a pizza
	 */
	private static final long serialVersionUID = 1L;
	
	// Pizza size & topping options
	private String size;
	private String cheese;
	
	private String pineapple;
	private String greenPepper;
	private String ham;
	private double cost;
	
	// constructs pizza & throws exceptions
	public Pizza(String pSize, String pCheese, String pPineapple, String pGreenPepper, String pHam) throws IllegalPizza {
		// sets the size choice
		if ((pSize == null) || (pCheese == null) || (pPineapple == null) || (pGreenPepper == null) || (pHam == null)) 
			throw new IllegalPizza("Invalid pizza");
		if (!(pSize.equals("Small")) && !(pSize.equals("Medium")) && !(pSize.equals("Large")))
			throw new IllegalPizza("Please choose a valid size option");
		size = pSize;
		// sets the cheese choice
		if (!(pCheese.equals("Single")) && !(pCheese.equals("Double")) && !(pCheese.contentEquals("Triple")))
			throw new IllegalPizza("Please choose a valid cheese option");
		cheese = pCheese;
		// sets the ham choice
		if (!(pHam.equals("None")) && !(pHam.equals("Single")))
			throw new IllegalPizza("Please choose a valid ham option");
		ham = pHam;
		//sets the pineapple choice
		if (!(pPineapple.equals("None")) && !(pPineapple.equals("Single")))
			throw new IllegalPizza("Please choose a valid pineapple option");
		if ((pHam.equals("None")) && (pPineapple.equals("Single")))
			throw new IllegalPizza("You may not have pineapple without ham");
		pineapple = pPineapple;
		//sets the green pepper choice
		if (!(pGreenPepper.equals("None")) && !(pGreenPepper.equals("Single")))
			throw new IllegalPizza("Please choose a valid green pepper option");
		if ((pHam.equals("None")) && (pGreenPepper.equals("Single")))
			throw new IllegalPizza("You may not have green peppers without ham");
		greenPepper = pGreenPepper;
		// calculates cost of pizza
		cost = getCost();
	} // end pizza constructor
	
	// constructs a small cheese pizza
	public Pizza() {
		size = "Small";
		cheese = "Single";
		ham = "Single";
		pineapple = "None";
		greenPepper = "None";
		cost = getCost();
	} // end small cheese pizza default constructor
	
	// calculates the cost of a pizza based on size & toppings
	public double getCost() {
		// initializes cost at zero
		double cost = 0.00;
		// updates cost based on size & toppings
		if (size.equals("Small"))
			cost = 7.00;
		if (size.equals("Medium"))
			cost = 9.00;
		if (size.equals("Large"))
			cost = 11.00;
		if (cheese.equals("Double"))
			cost += 1.50;
		if (cheese.equals("Triple"))
			cost += 3.00;
		if (ham.equals("Single"))
			cost += 1.50;
		if (pineapple.equals("Single"))
			cost += 1.50;
		if (greenPepper.equals("Single"))
			cost += 1.50;

		return cost;
	} // end getCost method
	
	// returns order size, toppings, & cost of pizza in a string
	@Override
	public String toString() {
		
		String orderString;
		String sizeString;
		String cheeseString;
		String hamString;
		String pineappleString;
		String greenPepperString;
		
		sizeString = size;
		cheeseString = cheese;
		
		if (ham.equals("None"))
			hamString = ".";
		else
			hamString = ", ham.";
		if (pineapple.equals("None"))
			pineappleString = "";
		else 
			pineappleString = ", pineapple";
		if (greenPepper.equals("None"))
			greenPepperString = "";
		else
			greenPepperString = ", green pepper";

		orderString= sizeString+" pizza, "+cheeseString+" cheese";         //general string
		orderString+=pineappleString+greenPepperString+hamString;          // add toppings to string
		orderString+=" Cost: "+"$"+String.format("%.2f", cost)+" each.";   // add cost
		
		return orderString;
	} // end toString
	
	//determines equality of all attributes of objects
	@Override
	public boolean equals(Object pizza) {
		if (!(pizza instanceof Pizza))
			return false;
		Pizza p = (Pizza) pizza;
		if (this.size.equals(p.size) && this.cheese.equals(p.cheese) && this.ham.equals(p.ham) && this.pineapple.equals(p.pineapple) && this.greenPepper.equals(p.greenPepper))
			return true;
		return false;
	} // end boolean equals
	
	//clones pizza with all attributes
	@Override
	public Pizza clone() {
		Pizza pClone = null;
		try { 
			pClone = new Pizza(this.size, this.cheese, this.pineapple, this.greenPepper, this.ham);
		} catch (IllegalPizza e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return pClone;
	}
} // end Pizza class
	


