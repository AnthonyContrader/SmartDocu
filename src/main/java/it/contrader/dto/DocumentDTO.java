package it.contrader.dto;

import java.util.Date;

import it.contrader.model.Category;
import it.contrader.model.Extension;
import it.contrader.model.Folder;
import it.contrader.model.User;
import it.contrader.model.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
	
	private Long id;

	private String title;

	private String description;

	private String genre;
	
	private Date datePub;
	
	private User user;
	
	private Folder folder;
	
	private Category category;
	
	private Version version;
	
	private Extension extension;

}
