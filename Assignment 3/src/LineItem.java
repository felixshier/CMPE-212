
public class LineItem implements java.io.Serializable, Comparable<LineItem> {

	/**
	 * The LineItem class contains:
	 * 2 constructors (1 general) to construct an order
	 * a getPizza accessor that returns pizza
	 * a getNumber accessor that returns numPizzas
	 * a getCost accessor that returns the total cost of an order
	 * including a discount based on order size
	 * a toString method that prefixes the number ordered to the
	 * result of the Pizza toString to show a complete line item
	 * a compareTo method that compares the cost of two orders
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private final Pizza pizza;   // pizza
 	private int numPizzas;       // number of pizzas in order
	
	public LineItem(int numPs, Pizza p) throws IllegalPizza {
		if (p == null)
			throw new IllegalPizza("Invalid pizza order");
		pizza = p;
		if ((numPs < 1) || (numPs > 100))
			throw new IllegalPizza("Invalid pizza order");
		numPizzas = numPs;
	} //end LineItem constructor
	
	public LineItem(Pizza p) throws IllegalPizza {
		if (p == null)
			throw new IllegalPizza("Invalid pizza order");
		pizza = p;
		numPizzas = 1;
	} // end LineItem general constructor

	public Pizza getPizza() {
		return pizza;
	} // end getPizza accessor
	public void setNumber(int numPs) throws IllegalPizza {
		if ((numPs < 1) || (numPs > 100))
			throw new IllegalPizza("Invalid number of pizzas");
		numPizzas = numPs;
	} // end setNumber
	public int getNumber() {
		return numPizzas;
	} // end getNumber accessor
	
	public double getCost() {
		double totalCost = numPizzas*pizza.getCost();
		// applies a 5% discount for orders with 10-20 pizzas
		if (numPizzas >= 10 && numPizzas <= 20)
			totalCost *= 0.95;
		// applies a 10% discount for orders with more than 20 pizzas
		if (numPizzas > 20)
			totalCost *= 0.90;
		totalCost = (double)Math.round(totalCost*1000)/1000;
		return totalCost;
	} // end getTotalCost accessor
	
	@Override
	public String toString() {
		String orderString;
		if (numPizzas < 10)
			orderString = " " + numPizzas + " " + pizza.toString();
		else
			orderString = numPizzas + " " +pizza.toString();
		return orderString;
	} // end toString
	
	public int compareTo(LineItem item) {
		double dif = item.getCost() - this.getCost();
		if((dif < 1) && (dif > -1))
			return 0;
		return (int)dif;
	} // end compareTo
} // end LineItem class
