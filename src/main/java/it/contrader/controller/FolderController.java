package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FolderDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	private FolderService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
		
		if (user.getUsertype().toString().equals("ADMIN")) {
			return "folders";
		}
		else {
			return "foldersuser";
		}
	}	
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("name") String name) {

		FolderDTO dto = new FolderDTO();
		
		dto.setName(name);
		
		service.insert(dto);
		setAll(request);
		return "folders";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		
		request.getSession().setAttribute("dto", service.read(id));
		return "readfolder";
	}
		
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatefolder";

	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@RequestParam("name") String name) {

		FolderDTO dto = new FolderDTO();
		
		dto.setId(id);
		dto.setName(name);
		
		service.update(dto);
		setAll(request);
		return "folders";

	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		
		service.delete(id);
		setAll(request);
		return "folders";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

}
