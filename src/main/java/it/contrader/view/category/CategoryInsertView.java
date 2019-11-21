package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author tony,musella
 *
 */

public class CategoryInsertView extends AbstractView {
	private Request request;

	private String type;
	private String description;
	private final String mode = "INSERT";

	public CategoryInsertView() {
	}

	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode INSERT del
	 * controller) mostra l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.print("\nInserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
		System.out.print("\nInserisci tipo della categoria: ");
		type = getInput();
		System.out.print("Inserisci la descrizione della categoria: ");
		description = getInput();

	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("type", type);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}

}
