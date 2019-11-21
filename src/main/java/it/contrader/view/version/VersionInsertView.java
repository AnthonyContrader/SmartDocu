package it.contrader.view.version;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class VersionInsertView extends AbstractView{
	private Request request;

	private String date;
	
	private final String mode = "INSERT";
	
	public VersionInsertView() {
	}

	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Version", null);

		}
}
	
	public void showOptions() {
		System.out.println("Inserisci la data di modifica della versione :");
		date = getInput();
		
	}
	
	public void submit() {
		request = new Request();
		request.put("date", date);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Version", "doControl", request);
	}
	
}
	
