package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FolderDTO;
import it.contrader.service.FolderService;

@Controller
@RequestMapping("/folder")
public class FolderController {

	@Autowired
	private FolderService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "folders";
		//return "foldersuser";
	}	

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "folders";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatefolder";

	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@RequestParam("nome") String nome) {

		FolderDTO dto = new FolderDTO();
		dto.setId(id);
		dto.setNome(nome);
		service.update(dto);
		setAll(request);
		return "folders";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("name") String nome) {

		FolderDTO dto = new FolderDTO();
		dto.setNome(nome);
		service.insert(dto);
		setAll(request);
		return "folders";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("nome") String nome) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

}
