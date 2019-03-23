import java.io.Serializable;

public class WingNut extends Nut implements Serializable {

	private static final long serialVersionUID = 1L;

	// wingNut constructor
	public WingNut(String dt, String mat, String fin, double price, int fasteners) throws IllegalFastener {
		super(dt, mat, fin, price, fasteners);
	} // end wingNut constructor
	
	@Override
	public String toString() {
		String orderString = "Wing nut, " + super.toString();
		return orderString;
	} // end toString

} // end wingNut class
