package it.contrader.converter;

import java.util.ArrayList;

/**
 * @author tony,musella
 */
import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

public class CategoryConverter {
	/**
	 * Crea un oggetto di tipo CategoryDTO e lo riempie con i campi del parametro category di tipo Category.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getType(), category.getDescription());
		return categoryDTO;
	}

	/**
	 * Crea un oggetto di tipo Category e lo riempie con i campi del parametro category di
	 * tipo CategoryDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	public Category toEntity(CategoryDTO CategoryConverter) {
		Category category = new Category(CategoryConverter.getId(), CategoryConverter.getType(),
				CategoryConverter.getDescription());
		return category;
	}

	/**
	 * Metodo per convertire le liste della Category.
	 */
	public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		// Crea una lista vuota.
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Category category : categoryList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			categoryDTOList.add(toDTO(category));
		}
		return categoryDTOList;
	}
}