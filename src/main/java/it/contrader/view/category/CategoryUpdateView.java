package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
/**
 * 
 * @author tony,musella
 *
 */
public class CategoryUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String type;
	private String description;
	private final String mode = "UPDATE";

	public CategoryUpdateView() {
	}

	/**
	 * PRENDE LA RICHIESTA E SE NON è VUOTA TI RIPORTA ALLA CATEGORIA VIEW
	 */
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	
	/**
	 * Questa funzione ti permette di modificare i dati della categoria
	 */
	public void showOptions() {
		try {
			System.out.println("Inserisci id della categoria:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il tipo della categoria:");
			type = getInput();
			System.out.println("Inserisci la descrizione della categoria:");
			description = getInput();

		} catch (Exception e) {

		}
	}
/**
 * inserisce i dati della richiesta e li invia al controller
 */
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("type", type);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}

}

