package projekt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQueries {
	  ;
	  public void insertNewFilm(String nazov, String reziser, Integer rok, String herci) {
	    if (nazov == null || reziser == null || rok == null || herci == null) {
	      throw new NullPointerException("Nazov, reziser, rok, herci must be set.");
	    }

	    Connection conn = DBConnection.getDBConnection();
	    if (conn == null) {
	      throw new NullPointerException("DBConnection is null.");
	    }

	    String insertFilm = "INSERT INTO filmy (nazov, reziser, rok, herci) VALUES (?, ?, ?, ?)";

	    try (PreparedStatement pstmt = conn.prepareStatement(insertFilm)) {
	      pstmt.setString(1, nazov);
	      pstmt.setString(2, reziser);
	      pstmt.setInt(3, rok);
	      pstmt.setString(4, herci);

	      int rowsInserted = pstmt.executeUpdate();
	      pstmt.close();
	      if (rowsInserted > 0) {
	        System.out.println("Novy film bol vlozeny do databazy!");
	      } else {
	        System.out.println("Film uz bol vlozeny alebo ste zadali spatne SQL prikaz INSERT.");
	      }
	    } catch (SQLException e) {
	      System.out.println("Nastala chyba pri vkladani filmu do databazy.");
	      e.printStackTrace();
	    }
	  }

	
	public void insertNewAnime(String nazov, String reziser, Integer rok, String animatori, Integer vek) {
	    if (nazov == null || reziser == null || rok == null|| animatori == null || vek == null)
	      throw new NullPointerException("Nazov, reziser, rok, animatori, vek must be set.");

	    Connection conn = DBConnection.getDBConnection();

	    String insertAnime = "INSERT INTO animaky (nazov,reziser,rok,animatori,vek) VALUES (?,?,?,?,?) ";

	    try (PreparedStatement prStmt = conn.prepareStatement(insertAnime)) {
	      prStmt.setString(1, nazov);
	      prStmt.setString(2, reziser);
	      prStmt.setInt(3, rok);
	      prStmt.setString(4, animatori);
	      prStmt.setInt(5, vek);

	      prStmt.executeUpdate();
	      System.out.println("Nový animak bol vložený do databázi!");
	    } catch (SQLException e) {
	      System.out.println("Animak už byl vložený alebo ste zadali spätne SQL príkaz INSERT");
	       e.printStackTrace();
	    }
	  }
}
