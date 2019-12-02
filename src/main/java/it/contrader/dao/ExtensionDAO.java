package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Extension;
import it.contrader.utils.ConnectionSingleton;

public class ExtensionDAO implements DAO<Extension> {

	private final String QUERY_ALL = "SELECT * FROM extension";
	private final String QUERY_CREATE = "INSERT INTO extension (type) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM extension WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE extension SET type=? WHERE id=1";
	private final String QUERY_DELETE = "DELETE FROM extension WHERE id=?";

	public ExtensionDAO() {

	}

	public List<Extension> getAll() {
		List<Extension> extensionsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Extension extension;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String estensione = resultSet.getString("type");
				extension = new Extension(estensione);
				extension.setId(id);
				extensionsList.add(extension);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return extensionsList;
	}

	public boolean insert(Extension extensionToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, extensionToInsert.getEstensione());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Extension read(int extensionId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, extensionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String estensione;

			estensione = resultSet.getString("type");
			Extension extension = new Extension(estensione);
			extension.setId(resultSet.getInt("id"));

			return extension;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Extension extensionToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (extensionToUpdate.getId() == 0)
			return false;

		Extension extensionRead = read(extensionToUpdate.getId());
		if (!extensionRead.equals(extensionToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (extensionToUpdate.getEstensione() == null || extensionToUpdate.getEstensione().equals("")) {
					extensionToUpdate.setEstensione(extensionRead.getEstensione());
				}



				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, extensionToUpdate.getEstensione());
				preparedStatement.setInt(2, extensionToUpdate.getId());
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
