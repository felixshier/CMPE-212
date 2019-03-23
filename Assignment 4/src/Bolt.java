import java.io.Serializable;

public abstract class Bolt extends InnerThreaded implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double length;
	
	private String[] screwFinishes = {"Black Phosphate", "ACQ 1000 Hour", "Lubricated"};

	
	// bolt constructor
	public  Bolt(String dt, double len, String mat, String fin, double price, int fasteners) throws IllegalFastener {
		super(dt, mat, fin, price, fasteners);
		setLength(len);
		if ((isIn(fin, screwFinishes)))
			throw new IllegalFastener("Invalid finish");
	} // end bolt constructor
	
	// setLength constructor
	private void setLength(double len) throws IllegalFastener {
		if(len >= 0.5 && len <= 6 && len % 0.25 == 0)
			this.length = len;
		else if(len >= 6 && len <= 11 && len % 0.5 == 0)
			this.length = len;
		else if(len >= 11 && len <= 20 && len % 1 == 0)
			this.length = len;
		else
			throw new IllegalFastener("Invalid Length");
	} // end setLength constructor
	
	@Override
	public String toString() {
		String orderString =  length + "\"" + " long, " + super.toString();
		return orderString;
	} // end toString
	
} //  end bolt class
