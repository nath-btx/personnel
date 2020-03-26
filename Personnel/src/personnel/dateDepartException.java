package personnel;

public class dateDepartException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public dateDepartException() {
		super("la date de depart ne peut pas etre avant la date d'arriver");
	}

}
