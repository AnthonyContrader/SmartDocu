package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ExtensionDTO;
import it.contrader.service.Service;
import it.contrader.service.ExtensionService;

public class ExtensionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExtensionServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ExtensionDTO> service = new ExtensionService();
		List<ExtensionDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ExtensionDTO> service = new ExtensionService();
		String mode = request.getParameter("mode");
		ExtensionDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "EXTENSIONLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/extension/extensionmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/extension/readextension.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/extension/updateextension.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String type = request.getParameter("type").toString();
			dto = new ExtensionDTO (type);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/extension/extensionmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			type = request.getParameter("type");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ExtensionDTO (type);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/extension/extensionmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/extension/extensionmanager.jsp").forward(request, response);
			break;
		}
	}
}


