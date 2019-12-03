package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDTO> {

	public Category toEntity(CategoryDTO categoryDTO) {
		Category category = null;
		if (categoryDTO != null) {
			category = new Category(categoryDTO.getId(), categoryDTO.getType(), categoryDTO.getDescription());
		}
		return category;
	}

	@Override
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = null;
		if (category != null) {
			categoryDTO = new CategoryDTO(category.getId(), category.getType(), category.getDescription());

		}
		return categoryDTO;
	}
}
