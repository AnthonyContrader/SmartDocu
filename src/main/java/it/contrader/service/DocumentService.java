package it.contrader.service;

import java.util.List;

import it.contrader.converter.DocumentConverter;
import it.contrader.dao.DocumentDAO;
import it.contrader.dto.DocumentDTO;

/**
 * 
 * @author Luca, De Salve
 *
 */

public class DocumentService {

	private DocumentDAO documentDAO;
	private DocumentConverter documentConverter;
	
	
	public DocumentService(){
		this.documentDAO = new DocumentDAO();
		this.documentConverter = new DocumentConverter();
	}
	

	/**
	 * 
	 * @return lista documentDTO
	 */
	public List<DocumentDTO> getAll() {
		return documentConverter.toDTOList(documentDAO.getAll());
	}


	/**
	 * 
	 * @param id
	 * @return documentDTO corrispondente
	 */
	public DocumentDTO read(int id) {
		return documentConverter.toDTO(documentDAO.read(id));
	}


	/**
	 * 
	 * @param dto
	 * @return dto convertito in entita e passato al DAO per inserimento
	 */
	public boolean insert(DocumentDTO dto) {
		return documentDAO.insert(documentConverter.toEntity(dto));
	}


	/**
	 * 
	 * @param dto
	 * @return dto convertito in entita e passato al DAO per modifica
	 */
	public boolean update(DocumentDTO dto) {
		return documentDAO.update(documentConverter.toEntity(dto));
	}


	/**
	 * 
	 * @param id
	 * @return eliminazione
	 */
	public boolean delete(int id) {
		return documentDAO.delete(id);
	}
	
}
