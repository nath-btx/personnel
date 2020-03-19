package personnel;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.SQLException;
	import java.sql.ResultSet;
	
	
	public interface JBDC extends Passerelle {
	   public static void main(String[] args) throws SQLException {

	      String JdbcURL = "jdbc:mysql://localhost:3306/application_ppe?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode = false & serverTimezone=UTC";
	      String Username = "root";
	      String password = "";
	      //probleme fuseau horaire avec W10 il faut changer la timezone de mysql avec SET @@global.time_zone = '+00:00'; et
	      // SET @@session.time_zone = '+00:00';
	      //puis SELECT @@global.time_zone, @@session.time_zone; pour verifier que la time zone a bien etait modifié
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         System.out.println("Connecting to database...............");
	         System.out.println(JdbcURL);
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         
	         // 2. Create a statement
	            myStmt = connection.createStatement();
	 
	            // 3. Execute SQL query
	            String sql = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, DateDepart, Level)"
	                    + " values ('test','toto','test@test.com','test','2020-03-19','2020-04-19','0')";
	 
	            myStmt.executeUpdate(sql);
	            
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

