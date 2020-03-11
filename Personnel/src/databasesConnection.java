	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.SQLException;
	
	
	
	public class databasesConnection {
	   public static void main(String[] args) {

	      String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe";
	      String Username = "root";
	      String password = "";
	      
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