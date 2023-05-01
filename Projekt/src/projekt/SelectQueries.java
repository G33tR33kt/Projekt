package projekt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class SelectQueries {
	public boolean testIfFilmExists(String nazov) {
	    if (nazov == null) {
	      throw new NullPointerException("query must not be null!");
	    } else if (nazov.isEmpty()) {
	      throw new IllegalArgumentException("query must not be empty!");
	    }

	    Connection conn = DBConnection.getDBConnection();
	    String testFilmExistence = "SELECT * FROM filmy WHERE nazov = ?";

	    try (PreparedStatement prStmt = conn.prepareStatement(testFilmExistence);) {
	      prStmt.setString(1, nazov);
	      ResultSet rs = prStmt.executeQuery();
	      if (rs.next())
	        return true;
	      else
	        return false;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	  }
	
	public boolean testIfAnimeExists(String nazov) {
	    if (nazov == null) {
	      throw new NullPointerException("query must not be null!");
	    } else if (nazov.isEmpty()) {
	      throw new IllegalArgumentException("query must not be empty!");
	    }

	    Connection conn = DBConnection.getDBConnection();
	    String testAnimeExistence = "SELECT * FROM animaky WHERE nazov = ?";

	    try (PreparedStatement prStmt = conn.prepareStatement(testAnimeExistence);) {
	      prStmt.setString(1, nazov);
	      ResultSet rs = prStmt.executeQuery();
	      if (rs.next())
	        return true;
	      else
	        return false;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	  }
	
	public boolean testIfActorExists(String herci) {
	    if (herci == null) {
	      throw new NullPointerException("query must not be null!");
	    } else if (herci.isEmpty()) {
	      throw new IllegalArgumentException("query must not be empty!");
	    }

	    Connection conn = DBConnection.getDBConnection();
	    String testActorsExistence = "SELECT * FROM filmy WHERE herci = ?";

	    try (PreparedStatement prStmt = conn.prepareStatement(testActorsExistence);) {
	      prStmt.setString(1, herci);
	      ResultSet rs = prStmt.executeQuery();
	      if (rs.next())
	        return true;
	      else
	        return false;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	  }
	
	public boolean testIfAnimatorExists(String animatori) {
	    if (animatori == null) {
	      throw new NullPointerException("query must not be null!");
	    } else if (animatori.isEmpty()) {
	      throw new IllegalArgumentException("query must not be empty!");
	    }

	    Connection conn = DBConnection.getDBConnection();
	    String testAnimatorsExistence = "SELECT * FROM filmy WHERE animatori = ?";

	    try (PreparedStatement prStmt = conn.prepareStatement(testAnimatorsExistence);) {
	      prStmt.setString(1, animatori);
	      ResultSet rs = prStmt.executeQuery();
	      if (rs.next())
	        return true;
	      else
	        return false;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	  }
	
	public void najdiFilmyHercovi(String herec) {
	      try {
	    	 Connection conn = DBConnection.getDBConnection();
	         Statement stmt = conn.createStatement();
	         String sql = "SELECT * FROM filmy WHERE herci LIKE '%" + herec + "%'";
	         ResultSet rs = stmt.executeQuery(sql);

	         while (rs.next()) {
	            String nazov = rs.getString("nazov");
	            String reziser = rs.getString("reziser");
	            int rok = rs.getInt("rok");
	            String herci = rs.getString("herci");

	            System.out.println(nazov + " (" + rok + ") - " + reziser + ", herci: " + herci);
	         }

	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void najdiFilmyAnimatorovi(String animator) {
	      try {
	    	 Connection conn = DBConnection.getDBConnection();
	         Statement stmt = conn.createStatement();
	         String sql = "SELECT * FROM animaky WHERE animatori LIKE '%" + animator + "%'";
	         ResultSet rs = stmt.executeQuery(sql);

	         while (rs.next()) {
	            String nazov = rs.getString("nazov");
	            String reziser = rs.getString("reziser");
	            int rok = rs.getInt("rok");
	            String animatori = rs.getString("animatori");
	            int age = rs.getInt("vek");

	            System.out.println(nazov + " (" + rok + ") - " + reziser + ", animatori: " + animatori + ", doporučený vek: " + age);
	         }

	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void najdiFilm(String film) {
	      try {
	    	 Connection conn = DBConnection.getDBConnection();
	         Statement stmt = conn.createStatement();
	 	      
	 	      
	         String sql = "SELECT * FROM filmy WHERE nazov LIKE '%" + film + "%'";
	         ResultSet rs = stmt.executeQuery(sql);

	         while (rs.next()) {
	            String nazov = rs.getString("nazov");
	            String reziser = rs.getString("reziser");
	            int rok = rs.getInt("rok");
	            String herci = rs.getString("herci");
	            int rating = rs.getInt("rating");
	            System.out.println(nazov + " (" + rok + ") - " + reziser + ", herci: " + herci + "rating: " + rating);
	         }

	        
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void najdiAnimak(String animak) {
	      try {
	    	 Connection conn = DBConnection.getDBConnection();
	         Statement stmt = conn.createStatement();
	         String sql = "SELECT * FROM animaky WHERE nazov LIKE '%" + animak + "%'";
	         ResultSet rs = stmt.executeQuery(sql);

	         while (rs.next()) {
	            String nazov = rs.getString("nazov");
	            String reziser = rs.getString("reziser");
	            int rok = rs.getInt("rok");
	            String herci = rs.getString("animatori");
	            String hodnotenie = rs.getString("hodnotenie");
	            System.out.println(nazov + " (" + rok + ") - " + reziser + ", animatori: " + herci + "hodnotenie: " + hodnotenie);
	         }

	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public void ulozFilm(String filmfile) {
	    try {
	        String sql = "SELECT nazov, reziser, rok, herci, rating FROM filmy WHERE nazov LIKE '%" + filmfile + "%'";
	        Connection conn = DBConnection.getDBConnection();
	        Statement statement = conn.createStatement();
	        ResultSet result = statement.executeQuery(sql);

	        File file = new File(filmfile);
	        FileWriter writer = new FileWriter(file);

	        while (result.next()) {
	            String nazov = result.getString("nazov");
	            String reziser = result.getString("reziser");
	            int rok = result.getInt("rok");
	            String herci = result.getString("herci");
	            String hodnotenie = result.getString("rating");

	            if (hodnotenie != null) {
	                writer.write("Nazov: " + nazov + ", Reziser: " + reziser + ", Rok vydania: " + rok + ", Herci: " + herci + ", Rating: " + hodnotenie + "\n");
	            } else {
	                writer.write("Nazov: " + nazov + ", Reziser: " + reziser + ", Rok vydania: " + rok + ", Herci: " + herci + "\n");
	            }
	        }

	        writer.close();
	        System.out.println("Informácie o anime boli uložené do súboru " + filmfile);
	    } catch (SQLException | IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public void ulozAnime(String animefile) {
	    try {
	    	String sql = "SELECT nazov, reziser, rok, animatori,vek,hodnotenie FROM animaky WHERE nazov LIKE '%" + animefile + "%'";
	        Connection conn = DBConnection.getDBConnection();
	        Statement statement = conn.createStatement();
	        ResultSet result = statement.executeQuery(sql);

	        File file = new File(animefile);
	        FileWriter writer = new FileWriter(file);

	        while (result.next()) {
	            String nazov = result.getString("nazov");
	            String reziser = result.getString("reziser");
	            int rok = result.getInt("rok");
	            String animatori = result.getString("animatori");
	            int vek = result.getInt("vek");
	            String hodnotenie = result.getString("hodnotenie");

	            if (vek != 0 && hodnotenie != null) {
	                writer.write("Nazov: " + nazov + ", Reziser: " + reziser + ", Rok vydania: " + rok + ", Animatori: " + animatori + ", Doporučený vek: " + vek + ", Hodnotenie: " + hodnotenie + "\n");
	            } else {
	                writer.write("Nazov: " + nazov + ", Reziser: " + reziser + ", Rok vydania: " + rok + ", Animatori: " + animatori + "\n");
	            }
	        }

	        writer.close();
	        System.out.println("Informácie o anime boli uložené do súboru " + animefile);
	    } catch (SQLException | IOException ex) {
	        ex.printStackTrace();
	    }
	}
	

	public void getAllFilms() { 
		Connection conn = DBConnection.getDBConnection();
	    String selectAllfilms = "SELECT nazov,reziser,rok,herci,rating FROM filmy";
	    try (
	    PreparedStatement prStmt = conn.prepareStatement(selectAllfilms);
	    ResultSet rs = prStmt.executeQuery()) {
	      while (rs.next()) {
	        System.out.println(
	            rs.getString("nazov") + ", " + rs.getString("reziser") + ", " + rs.getInt("rok") + "," +rs.getString("herci")+ ", " + rs.getInt("rating"));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    
	    }
	  }
	
	public void getAllAnimes() {
	    Connection conn = DBConnection.getDBConnection();
	    String selectAllanimes = "SELECT nazov,reziser,rok,animatori,vek,hodnotenie FROM animaky";

	    try (PreparedStatement prStmt = conn.prepareStatement(selectAllanimes);
	        ResultSet rs = prStmt.executeQuery()) {
	      while (rs.next()) {
	        System.out.println(
	            rs.getString("nazov") + ", " + rs.getString("reziser") + ", " + rs.getInt("rok") + "," +rs.getString("animatori") + "," + rs.getInt("vek")+ ", " + rs.getString("hodnotenie"));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	public static void vypisHercovVDvochFilmoch() {
	    try {
	    	Connection conn = DBConnection.getDBConnection();
	        Statement stmt = conn.createStatement();
	        stmt.execute("SET NAMES utf8");
	        String sql = "SELECT nazov, GROUP_CONCAT(f.nazov) AS filmyaherci " +
	                     "FROM filmy " +
	                     "JOIN obsadenie o ON f.id = o.film_id " +
	                     "JOIN herci h ON h.id = o.herci_id " +
	                     "GROUP BY herci " +
	                     "HAVING COUNT(DISTINCT f.id) > 1";
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            String herci = rs.getString("herci");
	            String filmy = rs.getString("filmy");

	            System.out.println("Herci, ktorí sa podieľali na viacerých filmoch:");
	            System.out.println(herci + ": " + filmy);
	        }

	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	public static void vypisAnimatorovVDvochFilmoch() {
	    try {
	    	Connection conn = DBConnection.getDBConnection();
	        Statement stmt = conn.createStatement();
	        stmt.executeQuery("SET NAMES utf8");
	        String sql = "SELECT animatori, GROUP_CONCAT(a.nazov) AS animaky " +
	                     "FROM filmy " +
	                     "JOIN obsadenie o ON a.id = o.animak_id " +
	                     "JOIN herci h ON h.id = o.animatori_id " +
	                     "GROUP BY herci " +
	                     "HAVING COUNT(DISTINCT a.id) > 1";
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            String animatori = rs.getString("animatori");
	            String animaky = rs.getString("animaky");

	            System.out.println("Animatori, ktorí sa podieľali na viacerých filmoch:");
	            System.out.println(animatori + ": " + animaky);
	        }

	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}
}
