/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

	private Request request;
    private String choice;

	/**
	 * Se la request non � nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n\nBenvenuto in SMARTDOCU ( "+request.get("username").toString().toUpperCase() +" )" + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("----------------------------------------------------- .:MENU:. ----------------------------------------------------------------\n");
        System.out.println("Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [D]ocumenti [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() � definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sar� diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        
    	switch (choice) {
	        
        	case "u":
	        	this.request.put("mode", "USERLIST");
	        	MainDispatcher.getInstance().callAction("User", "doControl", request);
	        	break;
	        	
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
	        	request.put("choice", choice);
	        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
	        }
    	}
}
