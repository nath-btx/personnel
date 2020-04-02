package personnel;

public class dateDepartException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public dateDepartException() {
//		super("la date de départ ne peut pas être avant la date d'arrivée");
		super("la date d'arrivée ne peut pas être après la date de depart");

	}

}
