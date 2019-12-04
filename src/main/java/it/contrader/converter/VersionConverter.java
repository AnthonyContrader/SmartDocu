package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.VersionDTO;
import it.contrader.model.Version;

@Component
public class VersionConverter extends AbstractConverter<Version,VersionDTO> {
	
	@Override
	public Version toEntity (VersionDTO versionDTO) {
		Version version=null;
		if (versionDTO !=null) {
			version = new Version(versionDTO.getId(), versionDTO.getDateMod(),versionDTO.getNumber(),versionDTO.getContent(),versionDTO.getDocument());
		}
		
		return version;
		}
	
	@Override
	public VersionDTO toDTO (Version version) {
		VersionDTO versionDTO = null;
		if (version !=null) {
			versionDTO = new VersionDTO(version.getId(), version.getDateMod(),version.getNumber(),version.getContent(),version.getDocument());
		}
		return versionDTO;
		}
	}


