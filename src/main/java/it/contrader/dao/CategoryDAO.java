package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Category;
/**
 * 
 * @author tony,musella
 */

public class CategoryDAO {
	
	private final String QUERY_ALL = "SELECT * FROM category";
	private final String QUERY_CREATE = "INSERT INTO category (type, description) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM category WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE category SET type=?, description=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM category WHERE id=?";

	public CategoryDAO() {

}
	public List<Category> getAll() {
		List<Category> categoriesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Category category;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String type = resultSet.getString("type");
				String description = resultSet.getString("description");
				category = new Category(type, description);
				category.setId(id);
				categoriesList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoriesList;
	}

	public boolean insert(Category categoryToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, categoryToInsert.getType());
			preparedStatement.setString(2, categoryToInsert.getDescription());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Category read (int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String type, description;

			type = resultSet.getString("type");
			description = resultSet.getString("description");
			
			Category category = new Category(type, description);
			category.setId(resultSet.getInt("id"));

			return category;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Category categoryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (categoryToUpdate.getId() == 0)
			return false;

		Category categoryRead = read(categoryToUpdate.getId());
		if (!categoryRead.equals(categoryToUpdate)) {
			try {
				// Fill the categoryToUpdate object
				if (categoryToUpdate.getType() == null || categoryToUpdate.getType().equals("")) {
					categoryToUpdate.setType(categoryRead.getType());
				}

				if (categoryToUpdate.getDescription() == null || categoryToUpdate.getDescription().equals("")) {
					categoryToUpdate.setDescription(categoryRead.getDescription());
				}

			
				// Update the category
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, categoryToUpdate.getType());
				preparedStatement.setString(2, categoryToUpdate.getDescription());
				preparedStatement.setInt(3, categoryToUpdate.getId());
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



