package it.contrader.view.version;

import it.contrader.controller.Request;

import it.contrader.dto.VersionDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class VersionReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public VersionReadView() {

}
	
	public void showResults(Request request) {
		if (request != null) {
			VersionDTO version = (VersionDTO) request.get("version");
			System.out.println("La versione selezionata ha i seguenti dettagli:\n");
			System.out.println("ID\tData");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(version + "\n");
			MainDispatcher.getInstance().callView("Version", null);
		}
		
	}
	public void showOptions() {
		System.out.print("\nInserisci l'ID della versione: ");
		id = Integer.parseInt(getInput());
	}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Version", "doControl", request);
	}
}
