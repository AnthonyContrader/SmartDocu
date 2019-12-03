package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.DocumentConverter;
import it.contrader.dao.DocumentRepository;
import it.contrader.dto.DocumentDTO;
import it.contrader.model.Document;

@Service
public class DocumentService extends AbstractService<Document, DocumentDTO>{
	
	@Autowired
	private DocumentConverter converter;
	@Autowired
	private DocumentRepository repository;

	public DocumentDTO findByFolderId (Long id) {
		return converter.toDTO(repository.findByFolderId(id));
	}

}
