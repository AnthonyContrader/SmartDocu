package it.contrader.service;

import java.util.List;
/**
 * @author tony,musella
 */

import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryDAO;
import it.contrader.dto.CategoryDTO;


public class CategoryService {
private CategoryDAO categoryDAO;
private CategoryConverter  categoryconverter;

public CategoryService() {
	this.categoryDAO = new CategoryDAO();
	this.categoryconverter = new CategoryConverter();

}
public List<CategoryDTO> getAll() {
	return categoryconverter.toDTOList(categoryDAO.getAll());
}


public CategoryDTO read(int id) {
	return categoryconverter.toDTO(categoryDAO.read(id));
}


public boolean insert(CategoryDTO dto) {
	return categoryDAO.insert(categoryconverter.toEntity(dto));
}


public boolean update(CategoryDTO dto) {
	return categoryDAO.update(categoryconverter.toEntity(dto));
}


public boolean delete(int id) {
	return categoryDAO.delete(id);
}


}

