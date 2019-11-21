package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	private Request request;
	private String choice;
	private Request requestUser;

	@Override
	public void showResults(Request request) {
		this.requestUser = request;
    	if(request!=null) {
    	System.out.println("\n\nBenvenuto in SMARTDOCU ( "+request.get("username").toString().toUpperCase() +" )" + "\n");
    	}
	}

	@Override
	public void showOptions() {
		 System.out.println("----------------------------------------------------- .:MENU:. ----------------------------------------------------------------\n");
	     System.out.println("Seleziona cosa vuoi gestire:");
	     System.out.println("[U]tente [D]ocumento [C]ategoria [V]ersione [E]sci");
	     	     
	     //Il metodo che salva l'input nella stringa choice.
	     //getInput() � definito in AbstractView.
	     choice = this.getInput();
	}

	@Override
	public void submit() {
		
		request = new Request();

		switch (choice) {
		case "u":
        	this.requestUser.put("mode", "SINGLEUSER");
        	MainDispatcher.getInstance().callAction("User", "doControl", requestUser);
        	break;
        
        	
        //MODIFICARE	request
		case "d":
        	this.request.put("mode", "DOCUMENTLIST");
        	MainDispatcher.getInstance().callAction("Document", "doControl", request);
        	break;
        	
		case "c":
        	this.request.put("mode", "CATEGORYLIST");
        	MainDispatcher.getInstance().callAction("Category", "doControl", request);
        	break;		
        	
		case "v":
            this.request.put("mode", "VERSIONLIST");
            MainDispatcher.getInstance().callAction("Version", "doControl", request);
            break;

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
