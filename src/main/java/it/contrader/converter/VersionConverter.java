package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.VersionDTO;
import it.contrader.model.Version;

@Component
public class VersionConverter extends AbstractConverter<Version,VersionDTO> {
	
	@Autowired
	private DocumentConverter documentConverter;
	
	@Override
	public Version toEntity (VersionDTO versionDTO) {
		Version version=null;
		if (versionDTO !=null) {
			version = new Version();
			
			version.setId(versionDTO.getId()); 
			version.setDateMod(versionDTO.getDateMod());
			version.setNumber(versionDTO.getNumber());
			version.setContent(versionDTO.getContent());
			
			if(versionDTO.getDocumentDTO()!= null) {
				version.setDocument(documentConverter.toEntity(versionDTO.getDocumentDTO()));
			}
			
		}
		
		return version;
	}
	
	@Override
	public VersionDTO toDTO (Version version) {
		VersionDTO versionDTO = null;
		if (version !=null) {
			versionDTO = new VersionDTO();
			
			versionDTO.setId(version.getId()); 
			versionDTO.setDateMod(version.getDateMod());
			versionDTO.setNumber(version.getNumber());
			versionDTO.setContent(version.getContent());
			
			if(version.getDocument()!= null) {
				versionDTO.setDocumentDTO(documentConverter.toDTO(version.getDocument()));
			}
			
		}
		return versionDTO;
		}
	}


