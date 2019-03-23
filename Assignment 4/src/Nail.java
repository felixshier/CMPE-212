import java.io.Serializable;

public abstract class Nail extends Fastener implements Serializable{
 	
	private static final long serialVersionUID = 1L;
 	
	private String[] sizes = {"6D", "8D", "10D", "12D", "16D", "60D"};
	private String size;
	
	private double[] gauges = {2, 8, 9, 10.25, 11.5};
	private double gauge;
	
	private double[] lengths = {2, 2.5, 3, 3.25, 3.5, 6};
	private double length;
	
	// nail constructor
	public Nail(String sz, double len, double g, String fin, double price, int fasteners) throws IllegalFastener {
		super("Steel",  fin, price, fasteners);
		setSize(sz);
		setGauge(g);
		setLength(len);
	} // end nail constructor
	
	// size constructor
	private void setSize(String sz) throws IllegalFastener {
		if (!(isIn(sz, sizes)))
			throw new IllegalFastener("Invalid size");
		else
			this.size = sz;
	} // end size constructor
	
	// gauge constructor
	private void setGauge(double g) throws IllegalFastener {
		if (!(isIn(g, gauges)))
			throw new IllegalFastener("Invalid gauge");
		else
			this.gauge = g;
	} // end gauge constructor
	
	// setLength constructor
	private void setLength(double len) throws IllegalFastener {
		if (!(isIn(len, lengths)))
			throw new IllegalFastener("Invalid length");
		else
			this.length = len;
	} // end setLength constructor

	@Override
	public String toString() {
		String orderString = size + " size, " + length + "\"" + " long, " + gauge + " gauge, " + super.toString();
		return orderString;
	} // end toString

} // end nail class
