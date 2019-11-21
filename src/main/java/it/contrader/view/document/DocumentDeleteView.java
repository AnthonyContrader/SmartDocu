package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentDeleteView extends AbstractView {
	
	private Request request;

	private int id;
	
	private final String mode = "DELETE";

	public DocumentDeleteView() {
		
	}
	
	/*
	 * Se la request non � nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id del documento da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del documento:");
			id = Integer.parseInt(getInput());

	}

	/**
	 * Impacchetta la request con l'id del documento da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}
