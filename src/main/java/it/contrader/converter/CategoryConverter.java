package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Category;
import it.contrader.model.User;

public class CategoryConverter implements Converter<Category, CategoryDTO>{

	public CategoryDTO toDTO(Category category) {
				CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getType(), category.getDescription());
				return categoryDTO;
			}

	public Category toEntity(CategoryDTO categoryDTO) {
		Category category = new Category(categoryDTO.getId(), categoryDTO.getType(), categoryDTO.getDescription());
		return category;
	}

	public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();

		for (Category category : categoryList) {
			categoryDTOList.add(toDTO(category));
		}
		return categoryDTOList;
	}

}
