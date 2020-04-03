package personnel;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
import java.time.DateTimeException;
import java.time.LocalDate;
	import java.sql.SQLException;
	import java.sql.ResultSet;
	
	
	 public class JDBC implements Passerelle  {

	public static void main(String[] args) throws SQLException {

//		  String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
//		  String Username = "root";
//	      String password = "";
//	      Connection connection = null;
//	      
//	      Statement myStmt = null;
//	      try {
//	         System.out.println("Connecting to database...............");
//	         System.out.println(JdbcURL);
//	         Class.forName("com.mysql.cj.jdbc.Driver"); 
//	         connection = DriverManager.getConnection(JdbcURL, Username, password);
//	         System.out.println("Connection is successful!!!!!!");
//	         
//	         // 2. Create a statement
//	            myStmt = connection.createStatement();
//	 
//	            // 3. Execute SQL query
//	            String sql = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, DateDepart, Level)";
//	            //insert
//	            String insert = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, DateDepart, Level)"
//	                    + " values ('test','toto','test@test.com','test','2020-03-19','2020-04-19','0')";
//	 
//	            myStmt.executeUpdate(insert);
//	            
//	            System.out.println("Insert complete.");
//	            
//	            //update
////	            String update = "update employe set Mail='demo@test.com' where nom='toto'";
////	            
////	            int rowsAffected = myStmt.executeUpdate(update);
////	 
////	            System.out.println("Rows affected: " + rowsAffected);
////	            System.out.println("Update complete.");
//	            
//	            //delete
//	            
////	            String delete = "delete from employe where nom='toto'";
////	            
////	            int rowsAffected1 = myStmt.executeUpdate(delete);
////	 
////	            System.out.println("Rows affected: " + rowsAffected1);
////	            System.out.println("Delete complete.");
//	 
//	      }
//	      catch (ClassNotFoundException e) {
//	            e.printStackTrace();
//	      }
//	      catch(SQLException e) {
//	         e.printStackTrace();
//	      }finally {
//	            if (myStmt != null) {
//	                myStmt.close();
//	            }
//	 
//	            if (connection != null) {
//	                connection.close();
//	            }
//	   }
	}

	@Override
	public GestionPersonnel getGestionPersonnel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void enregistrerEmploye(Employe employe) throws SQLException
	{
		  String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         
	            myStmt = connection.createStatement();
	 
	            String nom = employe.getNom();
	            String prenom = employe.getPrenom();
	            String mail = employe.getMail();
	        	// Comment récupérer le mot de passe sans getPassword?
	            String motdepasse = employe.getPassword();
	            LocalDate dateArrivee = employe.getDateArrivee();
	            LocalDate dateDepart = employe.getDateDepart();
	            int level = 0;
	            
	            /*
	            if (employe.estAdmin(employe.getLigue())) {
	            	level = 1;
	            }
	            if (employe.estRoot()) {
	            	level = 2;
	            }
	            */
	            String insert;
	            if (dateDepart == null) {
	            	insert = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, Level)"
		                    + " values ('"+ nom + "','"+prenom+"','"+ mail +"','"+motdepasse+"',"
		                    		+ "'"+ dateArrivee +"','"+ level +"')";
	            }
	            else {
	            	insert = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, DateDepart, Level)"
	                    + " values ('"+ nom + "','"+prenom+"','"+ mail +"','"+motdepasse+"',"
	                    		+ "'"+ dateArrivee +"', '"+dateDepart+"','"+ level +"')";
	            }
	            myStmt.executeUpdate(insert);
	      
	            
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
	
	public static void supprimerEmploye(Employe employe) throws SQLException
	{
		  String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         
	            myStmt = connection.createStatement();
	 
	            String nom = employe.getNom();
	            String prenom = employe.getPrenom();
	            String mail = employe.getMail();
	        	// Comment récupérer le mot de passe sans getPassword?
	            String motdepasse = employe.getPassword();
	            LocalDate dateArrivee = employe.getDateArrivee();
	            LocalDate dateDepart = employe.getDateDepart();
	            int level = 0;
	            boolean Root = employe.estRoot();
	            
	            
	            /*
	            if (employe.estAdmin(employe.getLigue())) {
	            	level = 1;
	            }
	            if (employe.estRoot()) {
	            	level = 2;
	            }
	            */
	            String delete;
	            if (level == 1) {
	 	            delete = "delete from employe where"+(""+ nom + ""+prenom  + ""+ mail +""+ dateArrivee +""+ level+"")+""; 
	 	            myStmt.executeUpdate(delete);
	 	            //Faut que le root soit admin à la place de l'admin mais j'ai pas trouver comment fauire
	            }
	            else {
		 	            delete = "delete from employe where"+(""+ nom + ""+prenom  + ""+ mail +""+ dateArrivee +""+ level+"")+""; 
		 	            myStmt.executeUpdate(delete);
	            }
	            myStmt.executeUpdate(delete);
	      
	            
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
	
	public static void enregistrerLigue(String ligue) throws SQLException
	{
		  String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         
	            myStmt = connection.createStatement();
	            
	            
	            String insert = "insert into ligue " + " (NomLigue)"
	                    + " values ('"+ ligue +"')";
	 
	            myStmt.executeUpdate(insert);
	            
	      }
	      catch (ClassNotFoundException e) {
	            e.printStackTrace();
	      }
	      catch(DateTimeException e) {
	    	  System.out.println("Invalide values");
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
	
	public static void modifierLigue(Ligue ligue) throws SQLException
	{
		  String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         
	            myStmt = connection.createStatement();
	            
	            
	            String update = "update ligue " + "(NomLigue)" + "set nomLigue="+ligue+"= "+"where"+"(NomLigue)"+" ";
	 
	            myStmt.executeUpdate(update);
	            
	      }
	      catch (ClassNotFoundException e) {
	            e.printStackTrace();
	      }
	      catch(DateTimeException e) {
	    	  System.out.println("Invalide values");
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
	
	public static void supprimerLigue(Ligue ligue) throws SQLException
	{
		  String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         
	            myStmt = connection.createStatement();
	            
	            
	            String drop = "drop table "+ligue+"";
	 
	            myStmt.executeUpdate(drop);
	            
	      }
	      catch (ClassNotFoundException e) {
	            e.printStackTrace();
	      }
	      catch(DateTimeException e) {
	    	  System.out.println("Invalide values");
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

