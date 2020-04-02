package personnel;

public class dateArriveeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public dateArriveeException() {
//		super("la date d'arrivée ne peut pas être après la date de depart");
		super("la date de départ ne peut pas être avant la date d'arrivée");

		
	}
	
}
