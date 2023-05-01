package projekt;	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;


	public class UpdateQueries {

		public void updateFilmRating(String nazov, int rating) {
			  try (Connection connection = DBConnection.getDBConnection();
			       PreparedStatement statement = connection.prepareStatement(
			         "UPDATE filmy SET rating = ? WHERE nazov = ?")) {
			    statement.setInt(1, rating);
			    statement.setString(2, nazov);
			    statement.executeUpdate();
			  } catch (SQLException e) {
			    e.printStackTrace();
			  }
			}
		
		public void updateAnimeRating(String nazov, String hodnotenie) {
			  try (Connection connection = DBConnection.getDBConnection();
			       PreparedStatement statement = connection.prepareStatement(
			         "UPDATE animaky SET hodnotenie = ? WHERE nazov = ?")) {
			    statement.setString(1, hodnotenie);
			    statement.setString(2, nazov); 
			    statement.executeUpdate();
			  } catch (SQLException e) {
			    e.printStackTrace();
			  }
			}
		
		public void upadateFilm (String nazov1, String reziser, int rok, String herci, int rating) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE filmy SET nazov = " + nazov1 + ", reziser = " + reziser + ", rok = " + rok + ", herci = " + herci + " WHERE nazov LIKE '%" + nazov1 + "%'")) {
				    statement.setString(1, nazov1);
				    statement.setString(2, reziser);
				    statement.setInt(3, rok);
				    statement.setString(4, herci);
				    statement.setInt(5, rating);
				    
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
				}	
		}
	