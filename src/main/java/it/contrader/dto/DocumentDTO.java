package it.contrader.dto;

/**
 * 
 * @author Luca, De Salve
 *
 */

public class DocumentDTO {
	
	private int id;
	private String title;
	private String description;
	private String content;
	private String genre;
	private String date;
	

	public DocumentDTO() {
		
	}

	public DocumentDTO (String title, String description, String content, String genre, String date) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.genre = genre;
		this.date = date;
	}

	public DocumentDTO (int id, String title, String description, String content, String genre, String date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.genre = genre;
		this.date = date;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + title +"\t\t" + description +"\t\t" + content +"\t\t\t" + genre + "\t" + date;
	}

}
