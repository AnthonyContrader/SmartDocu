package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.FolderConverter;
import it.contrader.dao.FolderRepository;
import it.contrader.dto.FolderDTO;
import it.contrader.model.Folder;

@Service
public class FolderService extends AbstractService<Folder, FolderDTO> {
	
	
	@Autowired
	private FolderConverter converter;
	
	@Autowired
	private FolderRepository repository;

}
