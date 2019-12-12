package it.contrader.service;

import java.util.List;

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

	public List<DocumentDTO> findAllDocumentsByFolderId (Long id) {
		return converter.toDTOList(repository.findAllByFolderId(id));
	}

}
