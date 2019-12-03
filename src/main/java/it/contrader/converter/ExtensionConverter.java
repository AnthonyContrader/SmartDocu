package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ExtensionDTO;
import it.contrader.model.Extension;

@Component
public class ExtensionConverter extends AbstractConverter<Extension, ExtensionDTO> {

	public Extension toEntity(ExtensionDTO extensionDTO) {
		Extension extension = null;
		if (extensionDTO != null) {
			extension = new Extension(extensionDTO.getId(), extensionDTO.getType());
		}
		return extension;
	}

	@Override
	public ExtensionDTO toDTO(Extension extension) {
		ExtensionDTO extensionDTO = null;
		if (extension != null) {
			extensionDTO = new ExtensionDTO(extension.getId(), extension.getType());

		}
		return extensionDTO;
	}
}



