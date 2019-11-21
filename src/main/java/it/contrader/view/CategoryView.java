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

	public CategoryView() {

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Categorie ----------------\n");
			System.out.println("ID\tType\tDescription");
			System.out.println("----------------------------------------------------\n");

			@SuppressWarnings("unchecked")
			List<CategoryDTO> categories = (List<CategoryDTO>) request.get("categories");
			for (CategoryDTO u : categories)
				System.out.println(u);
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
		MainDispatcher.getInstance().callAction("Category", "doControl", this.request);
	}

}
