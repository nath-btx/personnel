	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.SQLException;
	
	
	
	public class databasesConnection {
	   public static void main(String[] args) {

	      String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe";
	      String Username = "root";
	      String password = "";
	      //probleme fuseau horaire avec W10 il faut changer la timezone de mysql avec SET @@global.time_zone = '+00:00'; et
	      // SET @@session.time_zone = '+00:00';
	      //puis SELECT @@global.time_zone, @@session.time_zone; pour verifier que la time zone a bien etait modifié
	      Connection connection;
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	      }
	      catch (ClassNotFoundException e) {
	            e.printStackTrace();
	      }
	      catch(SQLException e) {
	         e.printStackTrace();
	      }
	   }
	}