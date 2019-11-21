package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.dto.VersionDTO;
import it.contrader.main.MainDispatcher;


public class VersionView extends AbstractView {

	private Request request;
	private String choice;
	private String user;

	public VersionView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			
			if(request.get("mode").equals("VERSIONLIST")) {
				
				user = "admin";
				
				System.out.println("\n------------------------------------------------------ .:GESTIONE VERSIONI:. -------------------------------------------------\n");
				System.out.println("ID\tData");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
				
				List<VersionDTO> versions = (List<VersionDTO>) request.get("versions");
				for (VersionDTO v: versions)
					System.out.println(v + "\n");
		
			} else {
			
				user = "user";
				//L'utente non visualizza la lista versioni
				
			}
		}
	}
	
	
	@Override
	public void showOptions() {
		if(user.equals("admin")) {

			System.out.println("\nScegli l'operazione da effettuare:");
			System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		} else {
			
			System.out.println("\nScegli l'operazione da effettuare:");
			System.out.println("[I]nserisci [B]ack [E]sci");
			
		}

		this.choice = getInput();
		
	}
	@Override
	public void submit() {
		request = new Request();
		
		if(user.equals("admin")) {
			request.put("choice", choice);
			request.put("mode", "GETCHOICEADMIN");
		} else {
			request.put("choice", choice);
			request.put("mode", "GETCHOICEUSER");
		}
		
		MainDispatcher.getInstance().callAction("Version", "doControl", this.request);
	}

}
	
	
	