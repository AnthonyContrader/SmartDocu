package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

/**
 * 
 * @author Luca, De Salve
 *
 */

public class DocumentConverter {
	
	public DocumentDTO toDTO(Document document) {
		DocumentDTO documentDTO = new DocumentDTO(document.getId(), document.getTitle(), document.getDescription(), document.getContent(), document.getGenre(), document.getDate());
		return documentDTO;
	}
	
	public Document toEntity(DocumentDTO documentDTO) {
		Document document = new Document(documentDTO.getId(), documentDTO.getTitle(), documentDTO.getDescription(), documentDTO.getContent(), documentDTO.getGenre(), documentDTO.getDate());
		return document;
	}
	
	public List<DocumentDTO> toDTOList(List<Document> documentList){
		List<DocumentDTO> documentDTOList = new ArrayList<DocumentDTO>();
		for(Document document : documentList) {
			documentDTOList.add(toDTO(document));
		}
		return documentDTOList;
	}

}
