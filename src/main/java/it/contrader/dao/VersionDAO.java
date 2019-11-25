package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Version;

public class VersionDAO {
	
	private final String QUERY_ALL = "SELECT * FROM version";
	private final String QUERY_CREATE = "INSERT INTO version (date) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM version WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE version SET date=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM version WHERE id=?";
	

	public VersionDAO() {

	
	}
	
	public List<Version> getAll() {
		List<Version> versionList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Version version;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String date = resultSet.getString("date");
				version = new Version(date);
				version.setId(id);
				versionList.add(version);
			}
} catch (SQLException e) {
	e.printStackTrace();
	
}
		return versionList;
	}
public boolean insert(Version versionToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
	preparedStatement.setString(1, versionToInsert.getDate());
	preparedStatement.execute();
	return true;
} catch (SQLException e) {
	return false;
}
	
}

public Version read(int versionId ) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
		preparedStatement.setInt(1, versionId);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		String date;
		
		date = resultSet.getString("date");
		Version version = new Version(date);
		version.setId(resultSet.getInt("id"));
		
	return version;
	} catch (SQLException e) {
		return null;
		}
}
	public boolean update(Version versionToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (versionToUpdate.getId() == 0)
			return false;
		
		Version versionRead = read(versionToUpdate.getId());
		if (!versionRead.equals(versionToUpdate)) {
			try {
				if (versionToUpdate.getDate() == null || versionToUpdate.getDate().equals("")) {
					versionToUpdate.setDate(versionRead.getDate());
			}
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, versionToUpdate.getDate());
				preparedStatement.setInt(2, versionToUpdate.getId());
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
	
	
