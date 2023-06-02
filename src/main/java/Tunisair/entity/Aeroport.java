package Tunisair.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="aeroport")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aeroport implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	@NotNull
	@Column
	  private String nom;

	  @OneToMany( mappedBy = "aeroportDepart")
	  private List<Vol> vols;

	  @OneToMany( mappedBy = "aeroportArrivee")
	  private List<Vol> volss;

	  @ManyToOne
	  @JoinColumn(name="ville_id")
	  private Ville ville;

	public Aeroport(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Aeroport() {
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


}
