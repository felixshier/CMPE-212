import java.io.Serializable;

public abstract class InnerThreaded extends Fastener implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// List of all valid diameters and threads.
	private String[] dtList = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"};
	
	private String diameterAndThread;
	
	// diameter and thread size constructor
	public InnerThreaded(String dt, String mat, String fin, double price, int fasteners) throws IllegalFastener {
		super(mat, fin, price, fasteners);
		setDiameterAndThread(dt);
	} // end diameter and thread size constructor
	
	// diameterAndThread constructor
	private void setDiameterAndThread(String dt) throws IllegalFastener {
		if (!(isIn(dt, dtList)))
			throw new IllegalFastener("Invalid diameter and thread size");
		else
			this.diameterAndThread = dt;
	} // end diameterAndThread constructor
	
	@Override
	public String toString() {
		String orderString = this.diameterAndThread + " thread, " + super.toString();
		return orderString;
	} // end toString
	
} // end diameterAndThread class
