package it.contrader.view.document;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DocumentUpdateView extends AbstractView {
	
	private Request request;
	
	private int id;
	private String title;
	private String description;
	private String content;
	private String genre;
	private String date;
	
	private final String mode = "UPDATE";
	
	public DocumentUpdateView() {
	}
	
	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("\nModifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Document", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del documento da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.print("\nInserisci id del documento da modificare: ");
			id = Integer.parseInt(getInput());
			System.out.print("Inserisci il titolo del documento: ");
			title = getInput();
			System.out.print("Inserisci la descrizione del documento: ");
			description = getInput();
			System.out.print("Inserisci il contenuto del documento: ");
			content = getInput();
			System.out.print("Inserisci il genere del documento: ");
			genre = getInput();
			System.out.print("Inserisci la data di pubblicazione del documento: ");
			date = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("title", title);
		request.put("description", description);
		request.put("content", content);
		request.put("genre", genre);
		request.put("date", date);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Document", "doControl", request);
	}

}
