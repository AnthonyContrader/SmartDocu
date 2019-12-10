package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;


@Component
public class DocumentConverter extends AbstractConverter<Document, DocumentDTO> {

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private FolderConverter folderConverter;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private ExtensionConverter extensionConverter;
		
	
	@Override
	public Document toEntity(DocumentDTO documentDTO) {
		
		Document document = null;
		
		if (documentDTO != null) {
			
			document = new Document();
			document.setId(documentDTO.getId());
			document.setTitle(documentDTO.getTitle());
			document.setDescription(documentDTO.getDescription());
			document.setGenre(documentDTO.getGenre());
			document.setDatePub((documentDTO.getDatePub()));
			
			
			if(documentDTO.getUserDTO()!= null) {
				document.setUser(userConverter.toEntity(documentDTO.getUserDTO()));
			}
			
			if(documentDTO.getFolderDTO()!= null) {
				document.setFolder(folderConverter.toEntity(documentDTO.getFolderDTO()));
			}
			
			if(documentDTO.getCategoryDTO()!= null) {
				document.setCategory(categoryConverter.toEntity(documentDTO.getCategoryDTO()));
			}
			
			if(documentDTO.getExtensionDTO()!= null) {
				document.setExtension(extensionConverter.toEntity(documentDTO.getExtensionDTO()));
			}
			
		}
		
		return document;
	}

	@Override
	public DocumentDTO toDTO(Document document) {

		DocumentDTO documentDTO = null;
		
		
		if (document != null) {
			
			documentDTO = new DocumentDTO();
			documentDTO.setId(document.getId());
			documentDTO.setTitle(document.getTitle());
			documentDTO.setDescription(document.getDescription());
			documentDTO.setGenre(document.getGenre());
			documentDTO.setDatePub(document.getDatePub());
			
			
			if(document.getUser()!= null) {
				documentDTO.setUserDTO(userConverter.toDTO(document.getUser()));
			}
			
			if(documentDTO.getFolderDTO()!= null) {
				documentDTO.setFolderDTO(folderConverter.toDTO(document.getFolder()));
			}
			
			if(documentDTO.getCategoryDTO()!= null) {
				documentDTO.setCategoryDTO(categoryConverter.toDTO(document.getCategory()));
			}
			
			if(documentDTO.getExtensionDTO()!= null) {
				documentDTO.setExtensionDTO(extensionConverter.toDTO(document.getExtension()));
			}
			
		}
			
		return documentDTO;
	}

}
