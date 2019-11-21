package it.contrader.dto;

public class VersionDTO {
	
	private int id;
	
	private String date;
	
	public VersionDTO() {

}
	
	public VersionDTO(String date) {
	this.date = date;	
	}
public VersionDTO (int id, String date)  {
	this.id = id;
	this.date = date;
}

public int getId() {
	return this.id;
}
public void setId(int id ) {
	this.id =id;
}
public String getDate() {
	return this.date;
}
public String toString() {
	return id + "\t" + date;
}
}