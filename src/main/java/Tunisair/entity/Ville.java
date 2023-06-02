package Tunisair.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="ville")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ville implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	@NotNull
	@Column
	  private String nom;
	  
	  @JsonIgnore
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
	  private List<Aeroport> aeroports;

	public Ville(Long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Ville() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
}
