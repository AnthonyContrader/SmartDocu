package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.VersionDTO;
import it.contrader.model.Version;

public class VersionConverter {
	
	public VersionDTO toDTO(Version version) {
		VersionDTO versionDTO = new VersionDTO(version.getId(), version.getDate());
		return versionDTO;
	}
	public Version toEntity(VersionDTO versionDTO) {
		Version version = new Version(versionDTO.getId(), versionDTO.getDate());
		return version;
	}
	public List<VersionDTO> toDTOList(List<Version> versionList) {
		List<VersionDTO> versionDTOList = new ArrayList<VersionDTO>();
		
		for(Version version : versionList) {
			
			versionDTOList.add(toDTO(version));
		}
		return versionDTOList;
	}

}
