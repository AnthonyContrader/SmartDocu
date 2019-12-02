package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ExtensionDTO;
import it.contrader.model.Extension;

public class ExtensionConverter  implements Converter<Extension, ExtensionDTO> {

	public ExtensionDTO toDTO(Extension extension) {
		ExtensionDTO extensionDTO = new ExtensionDTO(extension.getId(), extension.getEstensione());
		return extensionDTO;
	}

	
	@Override
	public Extension toEntity(ExtensionDTO extensionDTO) {
		Extension extension = new Extension(extensionDTO.getId(), extensionDTO.getEstensione());
		return extension;
	}
	
	
	@Override
	public List<ExtensionDTO> toDTOList(List<Extension> extensionList) {
		List<ExtensionDTO> extensionDTOList = new ArrayList<ExtensionDTO>();
		
		for(Extension extension : extensionList) {
			extensionDTOList.add(toDTO(extension));
		}
		return extensionDTOList;
	}

	
}
