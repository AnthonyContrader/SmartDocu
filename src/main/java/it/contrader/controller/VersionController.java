package it.contrader.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.DocumentDTO;
import it.contrader.dto.VersionDTO;
import it.contrader.service.DocumentService;
import it.contrader.service.VersionService;

@Controller
@RequestMapping("/version")
public class VersionController {

	@Autowired
	private VersionService service;

	@Autowired
	private DocumentService documentService;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "versions";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "versions";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateversion";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@DateTimeFormat(iso = ISO.DATE)
			@RequestParam("dateMod") Date dateMod,
			@RequestParam("number") String number, 
			@RequestParam("content") String content,
			@RequestParam("document") Long idDocument) {

		VersionDTO dto = new VersionDTO();
		DocumentDTO d = documentService.read(idDocument);
		
		dto.setId(id);
		dto.setDateMod(dateMod);
		dto.setNumber(number);
		dto.setContent(content);
		dto.setDocumentDTO(d);
		
		service.update(dto);
		setAll(request);
		return "versions";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@DateTimeFormat(iso = ISO.DATE)
			@RequestParam("dateMod") Date dateMod,
			@RequestParam("number") String number, 
			@RequestParam("content") String content,
			@RequestParam("document") Long idDocument) {

		VersionDTO dto = new VersionDTO();
		DocumentDTO d = documentService.read(idDocument);
		
		dto.setDateMod(dateMod);
		dto.setNumber(number);
		dto.setContent(content);
		dto.setDocumentDTO(d);
		service.insert(dto);
		setAll(request);
		return "versions";
	}

	@GetMapping("/read")
	public String Read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readversion";

	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listD", documentService.getAll());
	}
}
