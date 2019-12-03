package it.contrader.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;

	private String description;

	private String genre;
	
	@Temporal(TemporalType.DATE)
	private Date datePub;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folder")
	private Folder folder;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Version version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_extension")
	private Extension extension;
	

}
