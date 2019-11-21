package it.contrader.model;

public class Version {
	
	private int id;
	
	private String date;
	
	
	public Version() {

}
	
	public Version (String date) {
		this.date = date;
	}
	
	public Version (int id, String date) {
		this.id = id;
		this.date = date;
		
	}
	
public int getId() {
	return this.id;
}
public void setId(int id) {
	this.id=id;
}

public String getDate() {
	return this.date;
}

public void setDate(String date) {
	this.date = date;
}

public String toString() {
	return id + "\t" + date;
	
}

public boolean equals (Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Version other = (Version) obj;
	if (id != other.id)
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	return true;
	
	}
	
}
