import java.io.Serializable;

public abstract class Screw extends InnerThreaded implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String[] heads = {"Bugle", "Flat", "Oval", "Pan", "Round"};
	private String head;
	
	private String[] drives = {"6-Lobe", "Philips", "SLotted", "Square"};
	private String drive;
	
	private double length;
	
	// screw constructor
	public Screw(String hd, String dr, String dt, double len, String mat, String fin, double price, int fasteners) throws IllegalFastener {
		super(dt, mat, fin, price, fasteners);
		setHead(hd);
		setDrive(dr);
		setLength(len);
		
	} // end screw constructor

	// setHead constructor
	private void setHead(String hd) throws IllegalFastener {
		if (!(isIn(hd, heads)))
			throw new IllegalFastener("Invalid head");
		else
			this.head = hd;
	} // end screw constructor
	
	// setDrive constructor
	private void setDrive(String dr) throws IllegalFastener {
		if (!(isIn(dr, drives)))
			throw new IllegalFastener("Invalid drive");
		else
			this.drive = dr;
	} // end setDrive constructor
	
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
		String orderString = head + " head, " + drive + " drive, " + length + "\" long, " + super.toString();
		return orderString;
	} // end toString
	
} // end screw class
