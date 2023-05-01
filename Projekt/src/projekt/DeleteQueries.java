package projekt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import cz.vutbr.feec.dbconnection.dbconn.DBConnection;

public class DeleteQueries {
	public void deleteFilmByName(String nazov) {
		if (nazov == null) {
		      throw new NullPointerException("Nazov must not be null!");
		    } else if (nazov.isEmpty()) {
		      throw new IllegalArgumentException("name must not be empty!");
		    }
		    Connection conn = DBConnection.getDBConnection();

		    String filmToDelete = "DELETE FROM filmy WHERE nazov = ?";

		    try (PreparedStatement prStmt = conn.prepareStatement(filmToDelete);) {
		      prStmt.setString(1, nazov);
		      int rowsDeleted = prStmt.executeUpdate();
		      System.out.println("Vašim príkazem byl vymazán následujúcí počet uživatelú: " + rowsDeleted);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
	
	public void deleteAnimeByName(String nazov) {
		if (nazov == null) {
		      throw new NullPointerException("name must not be null!");
		    } else if (nazov.isEmpty()) {
		      throw new IllegalArgumentException("name must not be empty!");
		    }
		    Connection conn = DBConnection.getDBConnection();

		    String animeToDelete = "DELETE FROM animaky WHERE nazov = ?";

		    try (PreparedStatement prStmt = conn.prepareStatement(animeToDelete);) {
		      prStmt.setString(1, nazov);
		      int rowsDeleted = prStmt.executeUpdate();
		      System.out.println("Vašim príkazem byl vymazán následujúcí počet uživatelú: " + rowsDeleted);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
}
