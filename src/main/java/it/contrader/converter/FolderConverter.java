package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FolderDTO;
import it.contrader.model.Folder;

@Component
public class FolderConverter extends AbstractConverter<Folder, FolderDTO> {

	@Override
	public Folder toEntity(FolderDTO folderDTO) {
		Folder folder = null;
		if (folderDTO != null) {
			folder = new Folder(folderDTO.getId(), folderDTO.getName());
		}

		return folder;
	}

	@Override
	public FolderDTO toDTO(Folder folder) {
		FolderDTO folderDTO = null;
		if (folder != null) {
			folderDTO = new FolderDTO(folder.getId(), folder.getName());
		}
		return folderDTO;
	}

}
