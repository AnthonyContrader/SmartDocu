package it.contrader.model;

public class Category {

	private int id;

	private String type;
	
	private String description;
	
	public Category() {
		
	}

	public Category (String type, String description) {
		this.type = type;
		this.description = description;
		
	}
	public Category (int id, String type, String description) {
		this.id = id;
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

	public void setCategorytype(String type) {
		this.type = type;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type2) {
		// TODO Auto-generated method stub
		
	}


	}



