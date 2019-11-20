package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Document;

/**
 * 
 * @author Luca, De Salve
 *
 */

public class DocumentDAO {
	
	private final String QUERY_ALL    = "SELECT * FROM document";
	private final String QUERY_CREATE = "INSERT INTO document (title, description, content, genre, date) VALUES (?,?,?,?,?)";
	private final String QUERY_READ   = "SELECT * FROM document WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE user SET title=?, description=?, content=?, genre=?, date=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE id=?";
	
	public DocumentDAO() {
		
	}
	
	
	/**
	 * 
	 * @param userToInsert
	 * @return la lista di tutti i documenti
	 */
	public List<Document> getAll() {
		List<Document> documentsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Document document;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				String content = resultSet.getString("content");
				String genre = resultSet.getString("genre");
				String date = resultSet.getString("date");
				document = new Document(title, description, content, genre, date);
				document.setId(id);
				documentsList.add(document);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return documentsList;
	}
	
	
	/**
	 * 
	 * @param documentToInsert
	 * @return true se l'inserimento avviene con successo
	 */
	public boolean insert(Document documentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, documentToInsert.getTitle());
			preparedStatement.setString(2, documentToInsert.getDescription());
			preparedStatement.setString(3, documentToInsert.getContent());
			preparedStatement.setString(4, documentToInsert.getGenre());
			preparedStatement.setString(5, documentToInsert.getDate());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param userId
	 * @return il documento tramite il rispettivo id
	 */
	public Document read(int documentId) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, documentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String title = resultSet.getString("title");
			String description = resultSet.getString("description");
			String content = resultSet.getString("content");
			String genre = resultSet.getString("genre");
			String date = resultSet.getString("date");
			Document document = new Document(title, description, content, genre, date);
			document.setId(resultSet.getInt("id"));

			return document;
			
		} catch (SQLException e) {
			return null;
		}

	}
	
	
	/**
	 * 
	 * @param userToUpdate
	 * @return true se la modifica avviene con successo
	 */
	public boolean update(Document documentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (documentToUpdate.getId() == 0)
			return false;

		Document documentRead = read(documentToUpdate.getId());
		if (!documentRead.equals(documentToUpdate)) {
			try {

				if (documentToUpdate.getTitle() == null || documentToUpdate.getTitle().equals("")) {
					documentToUpdate.setTitle(documentRead.getTitle());
				}
				
				if (documentToUpdate.getDescription() == null || documentToUpdate.getDescription().equals("")) {
					documentToUpdate.setDescription(documentRead.getDescription());
				}
				
				if (documentToUpdate.getContent() == null || documentToUpdate.getContent().equals("")) {
					documentToUpdate.setContent(documentRead.getContent());
				}

				if (documentToUpdate.getGenre() == null || documentToUpdate.getGenre().equals("")) {
					documentToUpdate.setGenre(documentRead.getGenre());
				}

				if (documentToUpdate.getDate() == null || documentToUpdate.getDate().equals("")) {
					documentToUpdate.setDate(documentRead.getDate());
				}

				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, documentToUpdate.getTitle());
				preparedStatement.setString(2, documentToUpdate.getDescription());
				preparedStatement.setString(3, documentToUpdate.getContent());				
				preparedStatement.setString(4, documentToUpdate.getGenre());
				preparedStatement.setString(5, documentToUpdate.getDate());
				preparedStatement.setInt(6, documentToUpdate.getId());
				
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	
	
	/**
	 * 
	 * @param id
	 * @return true se la cancellazione avviene con successo
	 */
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	

}
