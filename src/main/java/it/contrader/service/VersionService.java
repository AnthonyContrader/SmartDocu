package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.VersionConverter;
import it.contrader.dao.VersionRepository;
import it.contrader.dto.VersionDTO;
import it.contrader.model.Version;

public class VersionService extends AbstractService<Version,VersionDTO> {
	
	@Autowired
	private VersionConverter converter;
	@Autowired
	private VersionRepository repository;
	

}
