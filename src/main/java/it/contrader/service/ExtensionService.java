package it.contrader.service;

import it.contrader.converter.ExtensionConverter;
import it.contrader.dao.ExtensionDAO;
import it.contrader.dto.ExtensionDTO;
import it.contrader.model.Extension;

public class ExtensionService	extends AbstractService<Extension, ExtensionDTO> {
		
		  public ExtensionService(){
			this.dao = new ExtensionDAO();
			this.converter = new ExtensionConverter();
		}
		
}
