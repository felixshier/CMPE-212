import java.io.Serializable;

public class CarriageBolt extends Bolt implements Serializable {

	private static final long serialVersionUID = 1L;

	// carriage bolt constructor
	public CarriageBolt(double len, String dt, String mat, String fin, double price, int fasteners) throws IllegalFastener {
		super(dt, len, mat, fin, price, fasteners);
	} // end carriage bolt constructor
	
	@Override
	public String toString() {
		String orderString = "Carriage bolt, " + super.toString();
		return orderString;
	} // end toString

} // end carriageBolt class
