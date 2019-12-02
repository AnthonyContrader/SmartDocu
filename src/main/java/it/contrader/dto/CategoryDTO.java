package it.contrader.dto;

public class CategoryDTO {

	private int id;
	private String type;
	private String description;

	public CategoryDTO() {

	}

	public CategoryDTO(int id, String type, String description) {
		this.id = id;
		this.type = type;
		this.description = description;

	}

	public CategoryDTO(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setCategorytype(String categorytype) {
		this.type = categorytype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return id + "\t" + type + "\t\t" + description + "\t\t";
	}
}
