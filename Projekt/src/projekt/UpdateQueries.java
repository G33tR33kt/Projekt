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
		
		
	
		public void upadateFilmNazov(String nazov, String novyNazov) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE filmy SET nazov = ? WHERE nazov = ?")) {
				    statement.setString(1, novyNazov);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}	
		
		public void upadateAnimeNazov(String nazov, String novyNazov) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE animaky SET nazov = ? WHERE nazov = ?")) {
				    statement.setString(1, novyNazov);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}	
		
		public void upadateFilmReziser(String nazov, String novyReziser) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE filmy SET reziser = ? WHERE nazov = ?")) {
				    statement.setString(1, novyReziser);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}	
		
		public void upadateAnimeReziser(String nazov, String novyReziser) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE animaky SET reziser = ? WHERE nazov = ?")) {
				    statement.setString(1, novyReziser);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}	
		
		public void upadateFilmRokVydania(String nazov, int novyRok) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE filmy SET rok = ? WHERE nazov = ?")) {
				    statement.setInt(1, novyRok);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}
		
		public void upadateAnimeRokVydania(String nazov, int novyRok) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE animaky SET rok = ? WHERE nazov = ?")) {
				    statement.setInt(1, novyRok);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}
		
		
		public void upadateFilmHerci(String nazov, String novySeznam) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE filmy SET herci = ? WHERE nazov = ?")) {
				    statement.setString(1, novySeznam);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}
		
		public void upadateAnimeAnimatori(String nazov, String novySeznam) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE animaky SET animatori = ? WHERE nazov = ?")) {
				    statement.setString(1, novySeznam);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
		}

		public void upadateAnimeVek(String nazov, String novyvek) {
			try (Connection connection = DBConnection.getDBConnection();
				       PreparedStatement statement = connection.prepareStatement(
				         "UPDATE animaky SET animatori = ? WHERE nazov = ?")) {
				    statement.setString(1, novyvek);
				    statement.setString(2, nazov); 
				    statement.executeUpdate();
				  } catch (SQLException e) {
				    e.printStackTrace();
				  }
			
		}
		}

		
	