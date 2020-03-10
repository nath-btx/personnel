	import java.sql.Connection;
	import java.sql.DriverManager;
	public class databasesConnection {
	   public static void main(String[] args) {
	      String JdbcURL = "jdbc:mysql://localhost/application_ppe";
	      String Username = "root";
	      String password = "";
	      Connection con = null;
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
	}