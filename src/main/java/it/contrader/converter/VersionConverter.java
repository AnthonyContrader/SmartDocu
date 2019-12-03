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
			version = new Version(versionDTO.getId(), versionDTO.getDate(), versionDTO.getDocument(),versionDTO.getNumber(),versionDTO.getContent());
		}
		
		return version;
		}
	
	@Override
	public VersionDTO toDTO (Version version) {
		VersionDTO versionDTO = null;
		if (version !=null) {
			versionDTO = new VersionDTO(version.getId(), version.getDate(), version.getDocument(),version.getNumber(),version.getContent());
		}
		return versionDTO;
		}
	}


