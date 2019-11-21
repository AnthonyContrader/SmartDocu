package it.contrader.view.version;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class VersionDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public VersionDeleteView() {
	}
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Version", null);
	}

}
	
	public void showOptions() {
		System.out.println("Inserisci id della versione:");
		id = Integer.parseInt(getInput());

}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Version", "doControl", request);
	}

}