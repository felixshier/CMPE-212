import java.io.Serializable;

public class CommonNail extends Nail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// common nail constructor
	public CommonNail(String sz, double len, double g, String fin, double price, int fasteners) throws IllegalFastener {
		super(sz, len, g, fin, price, fasteners);
	} // end common nail constructor
	
	@Override
	public String toString() {
		String orderString = "Common nail, " + super.toString();
		return orderString;
	} // end toString

} // end commonNail class
