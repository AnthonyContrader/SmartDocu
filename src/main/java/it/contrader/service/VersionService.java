package it.contrader.service;

import java.util.List;


import it.contrader.converter.VersionConverter;
import it.contrader.dao.VersionDAO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.VersionDTO;


public class VersionService {
	
	private VersionDAO versionDAO;
	private VersionConverter versionConverter;
	
	public VersionService(){
		this.versionDAO = new VersionDAO();
		this.versionConverter = new VersionConverter();
	}
	public List<VersionDTO> getAll() {
	return versionConverter.toDTOList(versionDAO.getAll());
	}
	public VersionDTO read(int id) {
		
		return versionConverter.toDTO(versionDAO.read(id));
	}
	
public boolean insert(VersionDTO dto) {
	return versionDAO.insert(versionConverter.toEntity(dto));
	
}

public boolean update(VersionDTO dto) {
	return versionDAO.update(versionConverter.toEntity(dto));
}
public boolean delete(int id) {
	
	return versionDAO.delete(id);
}

}