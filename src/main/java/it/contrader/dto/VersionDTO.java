package it.contrader.dto;

import java.sql.Date;

import it.contrader.model.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VersionDTO {

	private Long id;
	
	private Date date;
	
	private String number;
	
	private String content;
	
	private Document document;
	
	
}
