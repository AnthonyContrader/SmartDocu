package it.contrader.dto;
/**
 * 
 * @author tony,musella
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Category".
 */
public class CategoryDTO {
	private int id;
	private String type;
	private String description;

	public CategoryDTO() {

	}

	public CategoryDTO(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public CategoryDTO(int id, String type, String description) {
		this.id = id;
		this.type = type;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return id + "\t" + type + "\t\t" + description;

	}
}
	
