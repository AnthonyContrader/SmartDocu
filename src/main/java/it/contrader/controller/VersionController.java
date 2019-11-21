package it.contrader.controller;

import java.util.List;

import it.contrader.dto.VersionDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.VersionService;

public class VersionController implements Controller {

	private static String sub_package = "version.";
	private VersionService versionService;

	public VersionController() {
		this.versionService = new VersionService();
	}

	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		int id;
		String date;
		
		
		switch (mode) {
			
			case "READ":
				id = Integer.parseInt(request.get("id").toString());
				VersionDTO versionDTO = versionService.read(id);
				request.put("version", versionDTO);
				MainDispatcher.getInstance().callView(sub_package + "VersionRead", request);
	
				break;
	
			case "INSERT":
				date = request.get("date").toString();
	
				VersionDTO versiontoinsert = new VersionDTO(date);
				versionService.insert(versiontoinsert);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "VersionInsert", request);
				break;
	
			case "DELETE":
				id = Integer.parseInt(request.get("id").toString());
	
				versionService.delete(id);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "VersionDelete", request);
				break;
	
			case "UPDATE":
				id = Integer.parseInt(request.get("id").toString());
				date = request.get("date").toString();
				VersionDTO versiontoupdate = new VersionDTO(date);
				versiontoupdate.setId(id);
				versionService.update(versiontoupdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "VersionUpdate", request);
				break;
	
			case "VERSIONLIST":
				List<VersionDTO> versionsDTO = versionService.getAll();
				request.put("versions", versionsDTO);
				MainDispatcher.getInstance().callView("Version", request);
				break;
				
			case "SINGLEVERSION":
				MainDispatcher.getInstance().callView("Version", request);
				break;
	
			case "GETCHOICEADMIN":
				switch (choice.toUpperCase()) {
	
					case "L":
						MainDispatcher.getInstance().callView(sub_package + "VersionRead", null);
						break;
		
					case "I":
						MainDispatcher.getInstance().callView(sub_package + "VersionInsert", null);
						break;
		
					case "M":
						MainDispatcher.getInstance().callView(sub_package + "VersionUpdate", null);
						break;
		
					case "C":
						MainDispatcher.getInstance().callView(sub_package + "VersionDelete", null);
						break;
		
					case "E":
						MainDispatcher.getInstance().callView("Login", null);
						break;
		
					case "B":
						MainDispatcher.getInstance().callView("HomeAdmin", null);
						break;
		
					default:
						MainDispatcher.getInstance().callView("HomeAdmin", null);
						break;
				}
				
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			
			case "GETCHOICEUSER":
				switch (choice.toUpperCase()) {
				
					case "I":
						MainDispatcher.getInstance().callView(sub_package + "VersionInsert", null);
						break;
						
					case "E":
						MainDispatcher.getInstance().callView("Login", null);
						break;
		
					case "B":
						MainDispatcher.getInstance().callView("HomeUser", null);
						break;
		
					default:
						MainDispatcher.getInstance().callView("HomeAdmin", null);
						break;
				}

			MainDispatcher.getInstance().callView("HomeUser", null);
			break;
		}
	}
}