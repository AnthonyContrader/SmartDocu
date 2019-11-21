package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.dto.VersionDTO;
import it.contrader.main.MainDispatcher;


public class VersionView extends AbstractView {

	private Request request;
	private String choice;

	public VersionView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione versioni ----------------\n");
			System.out.println("ID\tData");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<VersionDTO> versions = (List<VersionDTO>) request.get("versions");
			for (VersionDTO v: versions)
				System.out.println(v);
			System.out.println();
		}
	}
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
		
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Version", "doControl", this.request);
	}

}
	
	
	