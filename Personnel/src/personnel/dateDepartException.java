package personnel;

public class dateDepartException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public dateDepartException() {
//		super("la date de d�part ne peut pas �tre avant la date d'arriv�e");
		super("la date d'arriv�e ne peut pas �tre apr�s la date de depart");

	}

}
