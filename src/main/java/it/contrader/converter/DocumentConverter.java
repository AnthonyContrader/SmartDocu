package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;


@Component
public class DocumentConverter extends AbstractConverter<Document, DocumentDTO> {

	@Override
	public Document toEntity(DocumentDTO documentDTO) {
		Document document = null;
		
		if (documentDTO != null) {
			document = new Document(documentDTO.getId(), documentDTO.getTitle(), documentDTO.getDescription(), documentDTO.getGenre(), documentDTO.getDatePub(), documentDTO.getUser(), documentDTO.getFolder(), documentDTO.getCategory(), documentDTO.getVersion(), documentDTO.getExtension());
		}
		return document;
	}

	@Override
	public DocumentDTO toDTO(Document document) {
		DocumentDTO documentDTO = null;
		if (document != null) {
			documentDTO = new DocumentDTO(document.getId(), document.getTitle(), document.getDescription(), document.getGenre(), document.getDatePub(), document.getUser(), document.getFolder(), document.getCategory(), document.getVersion(), document.getExtension());
		}
		return documentDTO;
	}

}
