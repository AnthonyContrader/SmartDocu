package it.contrader.controller;

import java.util.List;

import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.DocumentService;

/**
 * 
 * @author Luca, De Salve
 *
 */

public class DocumentController implements Controller{

	
	// Definisce il pacchetto di vista document. 
	private static String sub_package = "document.";
	private DocumentService documentService;

	
	public DocumentController() {
		this.documentService = new DocumentService();
	}
	
	
	@Override
	public void doControl(Request request) {
		
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String title;
		String description;
		String content;
		String genre;
		String date;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DocumentDTO documentDTO = documentService.read(id);
			request.put("document", documentDTO);
			MainDispatcher.getInstance().callView(sub_package + "DocumentRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			title = request.get("title").toString();
			description = request.get("description").toString();
			content = request.get("content").toString();
			genre = request.get("genre").toString();
			date = request.get("date").toString();
			
			//costruisce l'oggetto user da inserire
			DocumentDTO documentToInsert = new DocumentDTO(title, description, content, genre, date);
			
			//invoca il service
			documentService.insert(documentToInsert);
			request = new Request();
			request.put("mode", "mode");
			
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "DocumentInsert", request);
			break;
				
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			documentService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DocumentDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			title = request.get("title").toString();
			description = request.get("description").toString();
			content = request.get("content").toString();
			genre = request.get("genre").toString();
			date = request.get("date").toString();
			DocumentDTO documentToUpdate = new DocumentDTO(title, description, content, genre, date);
			documentToUpdate.setId(id);
			documentService.update(documentToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DocumentUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "DOCUMENTLIST":
			List<DocumentDTO> documentsDTO = documentService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("documents", documentsDTO);
			MainDispatcher.getInstance().callView("Document", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DocumentRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DocumentInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DocumentUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DocumentDelete", null);
				break;
				
			/*
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			*/
			}
			/*
		default:
			MainDispatcher.getInstance().callView("Login", null);
			*/
			
		}
	}

}
