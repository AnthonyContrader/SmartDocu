package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.dto.DocumentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentReadView extends AbstractView {
	
	private Request request;
	
	private int id;
	
	private final String mode = "READ";
	
	public DocumentReadView() {
	}
	
	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con un documento nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra il documento. In questo caso torna al DocumentView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			DocumentDTO document = (DocumentDTO) request.get("document");
			System.out.println(document);
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id del documento da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci id del documento:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id del documento da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}
