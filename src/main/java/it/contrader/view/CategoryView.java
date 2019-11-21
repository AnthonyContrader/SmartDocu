package it.contrader.view;

import java.util.List;
/**
 * @author tony,musella
 */

import it.contrader.controller.Request;
import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;

public class CategoryView extends AbstractView {

	private Request request;
	private String choice;
	private String user;

	public CategoryView() {

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			
			if(request.get("mode").equals("CATEGORYLIST")) {
				
				user = "admin";

				System.out.println("\n------------------------------------------------------ .:GESTIONE CATEGORIA:. ------------------------------------------------\n");
				System.out.println("ID\tType\tDescription");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
	
				List<CategoryDTO> categories = (List<CategoryDTO>) request.get("categories");
				for (CategoryDTO c : categories)
					System.out.println(c + "\n");
			} else {
				
				user = "user";
				//Lo User non visualizza la lista delle categorie 
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
		MainDispatcher.getInstance().callAction("Category", "doControl", this.request);
	}

}
