
// a class created to check if input is valid

public class isValid {
	// checks if input is a valid string
	public boolean isIn(String val, String[] list) {
		for (String e : list) {
			if (e.equals(val))
				return true;
		}
		return false;
	} // ends isIn string version
	
	// checks if input is a valid double
	public boolean isIn(double val, double[] list) {
		for (double e : list) {
			if (e == val)
				return true;
		}
		return false;
	} // ends isIn double version
	
} // end isValid class
