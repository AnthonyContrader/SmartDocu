package it.contrader.view.version;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class VersionUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String date;
	private final String mode = "UPDATE";

	public VersionUpdateView() {
}
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("\nModifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Version", null);
		}
	}

	public void showOptions() {
		try {
			System.out.print("\nInserisci id della versione: ");
			id = Integer.parseInt(getInput());
			System.out.print("Inserisci la data della versione: ");
			date = getInput();
			
		} catch (Exception e) {

		}
	}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("date", date);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Version", "doControl", request);
	}

}