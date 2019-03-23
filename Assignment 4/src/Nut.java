import java.io.Serializable;

public abstract class Nut extends InnerThreaded implements Serializable {

	private static final long serialVersionUID = 1L;

	// nut constructor
	public Nut(String dt, String mat, String fin, double price, int fasteners) throws IllegalFastener {
		super(dt, mat, fin, price, fasteners);
	} // end nut constructor

} // end nut class
