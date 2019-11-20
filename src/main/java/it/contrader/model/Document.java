package it.contrader.model;

/**
 * 
 * @author Luca, De Salve
 *
 */

public class Document {
	
	/**
	 * Definisco gli attributi di Document 
	 */
	private int id;
	private String title;
	private String description;
	private String content;
	private String genre;
	private String date;
	
	
	/**
	 * Definisco i tre costruttori, uno vuoto, uno con tre parametri e uno con id per costrire oggetti di tipo Document
	 */
	public Document() {
		
	}

	public Document (String title, String description, String content, String genre, String date) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.genre = genre;
		this.date = date;
	}

	public Document (int id, String title, String description, String content, String genre, String date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.genre = genre;
		this.date = date;
	}
	
	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Document
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return  id + "\t"  + title +"\t\t" + description +"\t\t" + content +"\t\t" + genre + "\t\t" + date;
	}
	
	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

}
