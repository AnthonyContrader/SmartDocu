package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class UserView extends AbstractView {

	private Request request;
	private String choice;
	private String user;

	public UserView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		
		if (request != null) {
			
			if (request.get("mode").equals("USERLIST")) {
				
				user = "admin";
				
				System.out.println("\n---------------------------------------------- .:GESTIONE UTENTI:. ----------------------------------------------------------\n");
				System.out.println("ID\tUsername\tPassword\tTipo Utente");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------\n");
				
				List<UserDTO> users = (List<UserDTO>) request.get("users");
				for (UserDTO u: users)
					System.out.println(u + "\n");
			
			} else {
				
				user = "user";
				
				System.out.println("\n---------------------------------------------- .:DETTAGLI UTENTE:. -------------------------------------------------------------");
				System.out.println("Username\t\tPassword");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				
				System.out.println(request.get("username")+"\t\t\t"+request.get("password")+"\n\n");
				
			}
		}
		
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalit� GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		if(user.equals("admin")) {
			
			System.out.println("Scegli l'operazione da effettuare:");
			System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		} else {
			
			System.out.println("Scegli l'operazione da effettuare:");
			System.out.println("[B]ack [E]sci");
		}
		
		this.choice = getInput();
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		
		if(user.equals("admin")) {
			
			request.put("choice", choice);
			request.put("mode", "GETCHOICEADMIN");
			MainDispatcher.getInstance().callAction("User", "doControl", request);
		
		} else {
			
			request.put("choice", choice);
			request.put("mode", "GETCHOICEUSER");
			MainDispatcher.getInstance().callAction("User", "doControl", request);
		
		}
	}

}
