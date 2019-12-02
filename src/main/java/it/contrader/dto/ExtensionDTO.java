package it.contrader.dto;

public class ExtensionDTO {

	private int id;

	private String estensione;

	public ExtensionDTO() {

	}

	public ExtensionDTO(int id, String estensione) {
		this.id = id;
		this.estensione = estensione;
	}

	public ExtensionDTO(String estensione) {
		this.estensione = estensione;

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstensione() {
		return this.estensione;
	}

	public void setEstenzione(String estensione) {
		this.estensione = estensione;
	}
}
