import java.io.Serializable;

public class WoodScrew extends Screw implements Serializable{

	private static final long serialVersionUID = 1L;

	private String[] points = {"Double cut", "Sharp", "Type 17"};
	private String point;
	
	// woodScrew constructor
	public WoodScrew(Double len, String dt, String mat, String fin, String hd, String dr, String pt, double price, int fasteners) throws IllegalFastener {
		super(hd, dr, dt, len, mat, fin, price, fasteners);
		setPoint(pt);
	} // end woodScrew constructor
	
	// setPoint constructor
	private void setPoint(String pt) throws IllegalFastener {
		if (!(isIn(pt, points)))
			throw new IllegalFastener("Invalid point");
		else
			this.point = pt;
	} // end setPoint constructor
	
	@Override
	public String toString() {
		String orderString = "Wood screw, "  + point + " point, " + super.toString();
		return orderString;
	}

} // end woodScrew class
