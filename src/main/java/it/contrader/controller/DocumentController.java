package it.contrader.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.DocumentDTO;
import it.contrader.dto.ExtensionDTO;
import it.contrader.dto.FolderDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.VersionDTO;
import it.contrader.service.CategoryService;
import it.contrader.service.DocumentService;
import it.contrader.service.ExtensionService;
import it.contrader.service.FolderService;
import it.contrader.service.UserService;
import it.contrader.service.VersionService;

@Controller
@RequestMapping("/document")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private VersionService versionService;
	
	@Autowired
	private ExtensionService extensionService;
		
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "documents";
	}
	
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
		@RequestParam("title")
		String title,
		@RequestParam("description")
		String description,
		@RequestParam("genre")
		String genre,
		@RequestParam("datePub")
		Date datePub,
		@RequestParam("id_user")
	 	Long idUser,
		@RequestParam("id_folder")
	 	Long idFolder,
		@RequestParam("id_category")
		Long idCategory,
		@RequestParam("id_version")
		Long idVersion,
		@RequestParam("id_extension")
		Long idExtension) {
		
		DocumentDTO dto = new DocumentDTO();
		UserDTO u = userService.read(idUser);
		FolderDTO f = folderService.read(idFolder);
		CategoryDTO c = categoryService.read(idCategory);
		VersionDTO v = versionService.read(idVersion);
		ExtensionDTO e = extensionService.read(idExtension);
		
		dto.setTitle(title);
		dto.setDescription(description);
		dto.setGenre(genre);
		dto.setDatePub(datePub);
		
		
		dto.setUserDTO(u);
		dto.setFolderDTO(f);
		dto.setCategoryDTO(c);
		dto.setVersionDTO(v);
		dto.setExtensionDTO(e);
		
		documentService.insert(dto);
		setAll(request);
		return "documents";
	}
	
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", documentService.read(id));
		return "readdocument";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", documentService.read(id));
		return "updatedocument";
	}

	
	@PostMapping("/update")
	public String update(HttpServletRequest request, 
		@RequestParam("id") 
		Long id, 
		@RequestParam("title")
		String title,
		@RequestParam("description")
		String description,
		@RequestParam("genre")
		String genre,
		@RequestParam("datePub")
		Date datePub,
		@RequestParam("id_user")
	 	Long idUser,
		@RequestParam("id_folder")
	 	Long idFolder,
		@RequestParam("id_category")
		Long idCategory,
		@RequestParam("id_version")
		Long idVersion,
		@RequestParam("id_extension")
		Long idExtension) {

		DocumentDTO dto = new DocumentDTO();
		UserDTO u = userService.read(idUser);
		FolderDTO f = folderService.read(idFolder);
		CategoryDTO c = categoryService.read(idCategory);
		VersionDTO v = versionService.read(idVersion);
		ExtensionDTO e = extensionService.read(idExtension);
		
		dto.setTitle(title);
		dto.setDescription(description);
		dto.setGenre(genre);
		dto.setDatePub(datePub);
		
		dto.setUserDTO(u);
		dto.setFolderDTO(f);
		dto.setCategoryDTO(c);
		dto.setVersionDTO(v);
		dto.setExtensionDTO(e);
		
		documentService.update(dto);
		setAll(request);
		return "documents";
	}
	
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		documentService.delete(id);
		setAll(request);
		return "documents";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", documentService.getAll());
	}
	
	
	//findByFolder

}
