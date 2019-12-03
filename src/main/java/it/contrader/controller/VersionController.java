package it.contrader.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
import it.contrader.dto.VersionDTO;
import it.contrader.model.Document;
import it.contrader.model.User.Usertype;
import it.contrader.service.VersionService;

@Controller
@RequestMapping("/version")

public class VersionController {
	
	@Autowired
	private VersionService service;



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
public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("date") Date date,
		@RequestParam("number") String number, @RequestParam("content") String content, @RequestParam("document") Document document) {

	VersionDTO dto = new VersionDTO();
	dto.setId(id);
	dto.setDate(date);
	dto.setNumber(number);
	dto.setContent(content);
	dto.setDocument(document);
	service.update(dto);
	setAll(request);
	return "versions";

}

@PostMapping("/insert")
public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("date") Date date,
		@RequestParam("number") String number, @RequestParam("content") String content, @RequestParam("document") Document document) {

	VersionDTO dto = new VersionDTO();
	dto.setId(id);
	dto.setDate(date);
	dto.setNumber(number);
	dto.setContent(content);
	dto.setDocument(document);
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
}
}

