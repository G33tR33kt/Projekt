package projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	 private static volatile Connection dbConnection;

	  private DBConnection() {}

	  public static Connection getDBConnection() {
	    if (dbConnection == null) {
	      synchronized (DBConnection.class) {
	        if (dbConnection == null) {
	          try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projekt", "root", "mysql");
	          } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace(); 
	          }
	        }
	      }
	    }
	    return dbConnection;
	  }

	  public static void closeConnection() {
	    try {
	      dbConnection.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public static Boolean createTable() {
			if (dbConnection == null)
				return false;

			String sql = "CREATE TABLE IF NOT EXISTS filmy (" + "id int NOT NULL PRIMARY KEY AUTO_INCREMENT, " + " nazov varchar(20), " + "reziser varchar(40), " + "rok int, " + " herci varchar(40),"+" rating int,"+" );";
			String sql2 ="CREATE TABLE IF NOT EXISTS animaky (" + "id int NOT NULL PRIMARY KEY AUTO_INCREMENT, " + " nazov varchar(20), " + "reziser varchar(40), " + "rok int, " + " animatori varchar(40),"+" vek int,"+" hodnotenie varchar(6),"+" );";
			try 
			{
				Statement stmnt = dbConnection.createStatement();
				stmnt.execute(sql);
				stmnt.execute(sql2);
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
		}
}
