package it.contrader.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Version {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column
private Date dateMod;

private String number;

private String content;

private Document document;

}