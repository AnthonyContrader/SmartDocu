package it.contrader.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionDTO {

	private Long id;
	
	private Date dateMod;
	
	private String number;
	
	private String content;
	
	private DocumentDTO documentDTO;
	
	
}
