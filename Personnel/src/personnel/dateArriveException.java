package personnel;

public class dateArriveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public dateArriveException() {
		super("la date d'arriver ne peut pas etre apres la date de depart");
	}
	
}
