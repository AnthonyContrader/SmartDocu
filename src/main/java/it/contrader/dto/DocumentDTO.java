package it.contrader.dto;

import java.util.Date;

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
	
	private UserDTO user;
	
	private FolderDTO folder;
	
	private CategoryDTO category;
	
	private VersionDTO version;
	
	private ExtensionDTO extension;

}
