package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ExtensionDTO;
import it.contrader.service.ExtensionService;

@Controller
@RequestMapping("/extension")
public class ExtensionController {

	@Autowired
	private ExtensionService service;



	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "extensions";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "extensions";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateextension";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("type") String type) {

		ExtensionDTO dto = new ExtensionDTO();
		dto.setId(id);
		dto.setType(type);
		
		
		service.update(dto);
		setAll(request);
		return "extensions";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("type") String type,
			@RequestParam("description") String description) {
		ExtensionDTO dto = new ExtensionDTO();
		dto.setType(type);
		service.insert(dto);
		setAll(request);
		return "extensions";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readextension";
	}



	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
