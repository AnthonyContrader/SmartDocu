package it.contrader.model;

public class Extension {
	private int id;

	private String estensione;


    public Extension() {
    	
    }
    
    public Extension(int id, String estensione) {
    	this.id = id;
    	this.estensione = estensione;
    }
    
    public Extension (String estensione) {
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

	public void setEstensione(String estensione) {
		this.estensione = estensione;
	}
}