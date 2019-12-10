package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Document;

@Repository
@Transactional
public interface DocumentRepository extends CrudRepository<Document, Long> {
	
	Document findByFolderId (Long id);

}
