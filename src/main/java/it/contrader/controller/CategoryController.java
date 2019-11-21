package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategoryService;
/**
 * 
 * @author tony,musella
 *
 */
public class CategoryController implements Controller {
	

		/**
		 * definisce il pacchetto di vista category.
		 */
		private static String sub_package = "category.";
		
		private CategoryService categoryService;
		/**
		 * Costruisce un oggetto di tipo CategoryService per poterne usare i metodi
		 */
		public CategoryController() {
			this.categoryService = new CategoryService();
		}
		
		
		
		/**
		 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
		 * (che riceve dalle view specifiche e può essere la richesta di una 
		 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
		 * 
		 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
		 * altrimenti rimanda alla View della CRUD per richiedere i parametri
		 */
		@Override
		public void doControl(Request request) {
			
			//Estrae dalla request mode e choice
			String mode = (String) request.get("mode");
			
			String choice = (String) request.get("choice");

			//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
			int id;
			String type;
			String description;
			

			switch (mode) {
			
			// Arriva qui dalla CategoryReadView. Chiama il Service con il parametro id e invia alla CategoryReadView una categoria da mostrare 
			case "READ":
				id = Integer.parseInt(request.get("id").toString());
				CategoryDTO categoryDTO = categoryService.read(id);
				request.put("category", categoryDTO);
				MainDispatcher.getInstance().callView(sub_package + "CategoryRead", request);
				break;
			
			// Arriva qui dalla CategoryInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
			case "INSERT":
				type = request.get("type").toString();
				description = request.get("description").toString();
			
				
				//costruisce l'oggetto user da inserire
				CategoryDTO categorytoinsert = new CategoryDTO(type, description);
				//invoca il service
				categoryService.insert(categorytoinsert);
				request = new Request();
				request.put("mode", "mode");
				//Rimanda alla view con la risposta
				MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", request);
				break;
			
			// Arriva qui dalla CategoryDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
			case "DELETE":
				id = Integer.parseInt(request.get("id").toString());
				//Qui chiama il service
				categoryService.delete(id);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", request);
				break;
			
			// Arriva qui dalla CategoryUpdateView
			case "UPDATE":
				id = Integer.parseInt(request.get("id").toString());
				type = request.get("type").toString();
				description = request.get("description").toString();
				CategoryDTO categorytoupdate = new CategoryDTO(type, description);
				categorytoupdate.setId(id);
				categoryService.update(categorytoupdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", request);
				break;
				
			//Arriva qui dalla UserView Invoca il Service e invia alla CategoryView il risultato da mostrare 
			case "CATEGORYLIST":
				List<CategoryDTO> categoriesDTO = categoryService.getAll();
				//Impacchetta la request con la lista delle categorie
				request.put("categories", categoriesDTO);
				MainDispatcher.getInstance().callView("Category", request);
				break;
				
			//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
			//con REQUEST NULL (vedi una View specifica)
			case "GETCHOICE":
						
						//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "CategoryRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;

				case "B":
					MainDispatcher.getInstance().callView("HomeAdmin", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		}
	}

