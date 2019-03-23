
// IllegalPizza Exception Class
public class IllegalPizza extends Exception {
	/**
	 * An Exception thrown by the Pizza object if parameters are not legal.
	 * 
	 * Exception thrown if: 
	 * null pizza, 
	 * invalid choice of size or topping,
	 * a pizza is made with pineapple or green peppers, 
	 * but no ham.
	 */
	private static final long serialVersionUID = 1L;
	
	// Exception with custom message 
	public IllegalPizza(String message) {
		super(message);
	}	
} // end IllegalPizza Exception Class