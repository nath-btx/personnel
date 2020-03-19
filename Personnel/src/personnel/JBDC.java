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
	      Connection connection = null;
	      
	      Statement myStmt = null;
	      try {
	         System.out.println("Connecting to database..............."+JdbcURL);
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         connection = DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	         
	         // 2. Create a statement
	            myStmt = connection.createStatement();
	 
	            // 3. Execute SQL query
	            //insert
	            String insert = "insert into employe " + " (Nom, Prenom, Mail, Mdp, DateArrive, DateDepart, Level)"
	                    + " values ('test','toto','test@test.com','test','2020-03-19','2020-04-19','0')";
	 
	            myStmt.executeUpdate(insert);
	            
	            System.out.println("Insert complete.");
	            
	            //update
	            String update = "update employe set Mail='demo@test.com' where nom='toto'";
	            
	            int rowsAffected = myStmt.executeUpdate(update);
	 
	            System.out.println("Rows affected: " + rowsAffected);
	            System.out.println("Update complete.");
	            
	            //delete
	            
	            String delete = "delete from employe where nom='toto'";
	            
	            int rowsAffected1 = myStmt.executeUpdate(delete);
	 
	            System.out.println("Rows affected: " + rowsAffected1);
	            System.out.println("Delete complete.");
	 
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

