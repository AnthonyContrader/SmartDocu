package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.VersionConverter;
import it.contrader.dao.VersionRepository;
import it.contrader.dto.VersionDTO;
import it.contrader.model.Version;

@Service
public class VersionService extends AbstractService<Version,VersionDTO> {
	
	@Autowired
	private VersionConverter converter;
	@Autowired
	private VersionRepository repository;

	public VersionDTO findByDocumentId(Long id) {
		return converter.toDTO(repository.findByDocumentId(id));
	}
	

}
