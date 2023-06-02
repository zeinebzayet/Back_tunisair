package Tunisair.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;



@Entity
@Table(name="avion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Avion implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	@NotNull
	@Column
	  private String type;
	@NotNull
	@Column
	  private String etat;
	  
	  @JsonIgnore
	  @OneToMany(mappedBy = "avion")
	  private List<Vol> vols;

	public Avion() {
		super();
	}

	public Avion(Long id, String type, String etat) {
		super();
		this.id = id;
		this.type = type;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
}
