package personnel;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.time.LocalDate;

/**
 * Représente une ligue. Chaque ligue est reliée Ã  une liste
 * d'employés dont un administrateur. Comme il n'est pas possible
 * de créer un employé sans l'affecter Ã  une ligue, le root est 
 * l'administrateur de la ligue jusqu'Ã  ce qu'un administrateur 
 * lui ait été affecté avec la fonction {@link #setAdministrateur}.
 */

public class Ligue implements Serializable, Comparable<Ligue>
{
	private static final long serialVersionUID = 1L;
	private String nom;
	private SortedSet<Employe> employes;
	private Employe administrateur;
	
	/**
	 * Crée une ligue.
	 * @param nom le nom de la ligue.
	 */
	
	public Ligue(String nom)
	{
		this.nom = nom;
		employes = new TreeSet<>();
		administrateur = GestionPersonnel.getGestionPersonnel().getRoot();
		GestionPersonnel.getGestionPersonnel().add(this);
	}

	/**
	 * Retourne le nom de la ligue.
	 * @return le nom de la ligue.
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom.
	 * @param nom le nouveau nom de la ligue.
	 */

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne l'administrateur de la ligue.
	 * @return l'administrateur de la ligue.
	 */
	
	public Employe getAdministrateur()
	{
		return administrateur;
	}

	/**
	 * Fait de administrateur l'administrateur de la ligue.
	 * LÃ¨ve DroitsInsuffisants si l'administrateur n'est pas 
	 * un employé de la ligue ou le root. Révoque les droits de l'ancien 
	 * administrateur.
	 * @param administrateur le nouvel administrateur de la ligue.
	 */
	
	public void setAdministrateur(Employe administrateur)
	{
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		if (administrateur != root && administrateur.getLigue() != this)
			throw new DroitsInsuffisants();
		this.administrateur = administrateur;
	}

	/**
	 * Retourne les employés de la ligue.
	 * @return les employés de la ligue dans l'ordre alphabétique.
	 */
	
	public SortedSet<Employe> getEmployes()
	{
		return Collections.unmodifiableSortedSet(employes);
	}

	/**
	 * Ajoute un employé dans la ligue. Cette méthode 
	 * est le seul moyen de créer un employé.
	 * @param nom le nom de l'employé.
	 * @param prenom le prénom de l'employé.
	 * @param mail l'adresse mail de l'employé.
	 * @param password le password de l'employé.
	 * @return l'employé créé. 
	 * @throws SQLException 
	 */

	public Employe addEmploye(String nom, String prenom, String mail, String password, LocalDate datearrivee) throws SQLException
	{
		Employe employe = new Employe(this, nom, prenom, mail, password, datearrivee);
		Enregistrer(employe);
		employes.add(employe);
		return employe;
	}
	
	void remove(Employe employe)
	{
		employes.remove(employe);
	}
	
	/**
	 * Supprime la ligue, entraÃ®ne la suppression de tous les employés
	 * de la ligue.
	 */
	
	public void remove()
	{
		GestionPersonnel.getGestionPersonnel().remove(this);
	}
	

	@Override
	public int compareTo(Ligue autre)
	{
		return getNom().compareTo(autre.getNom());
	}
	
	@Override
	public String toString()
	{
		return nom;
	}
	
	public void Enregistrer(Employe employe) throws SQLException
	{
		 String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         System.out.println("Connecting to database...............");
	         System.out.println(JdbcURL);
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!");
	         
	         // 2. Create a statement
	            myStmt = connection.createStatement();
	 
	            // 3. Execute SQL query
	            //insert
	            String nom = employe.getNom();
	            String prenom = employe.getPrenom();
	            String mail = employe.getMail();
	            LocalDate dateArrivee = employe.getDateArrivee();
	            LocalDate dateDepart = employe.getDateDepart();
	            int level = 0;
	            if(employe.estRoot()) {
	            	level = 2;
	            }
	            /*
	            if (employe.estAdmin(ligue)) {
	            	level = 1;
	            }
	            */
	            
	            
	            String insert = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, Level)"
	                    + " values ('"+ nom + "','"+prenom+"','"+ mail +"','mettre le mot de passe ici',"
	                    		+ "'"+ dateArrivee +"','"+ level +"')";
	 
	            myStmt.executeUpdate(insert);
	            
	            System.out.println("Insert complete."); 
	      }
	      catch (ClassNotFoundException e) {
	            e.printStackTrace();
	      }
	      catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	            if (myStmt != null) {
	                myStmt.close();
	            }
	 
	            if (connection != null) {
	                connection.close();
	            }
	   }
	

	}
}
