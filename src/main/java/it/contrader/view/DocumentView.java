package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;

public class DocumentView extends AbstractView {
	
	private Request request;
	private String choice;

	
	public DocumentView() {
	}
	
	/**
	 * Mostra la lista documenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------------------------------------------ .:GESTIONE DOCUMENTI:. --------------------------------------------------\n");
			System.out.println("Id\tTitolo\t\tDescrizione\t\tContenuto\t\t\t\t\t\tGenere\t\tData");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
			
			List<DocumentDTO> documents = (List<DocumentDTO>) request.get("documents");
			for (DocumentDTO d: documents)
				System.out.println(d + "\n");
		}
	}

	/**
	 * Chiede all'utente un input per la choice. 
	 * Mette la modalit� GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("\nScegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		choice = getInput();		
	}
	
	/**
	 * Impacchetta la request e la manda al DocumentController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}
