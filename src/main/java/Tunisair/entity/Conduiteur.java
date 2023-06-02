package Tunisair.entity;


import Tunisair.enums.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name="conduiteur")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Conduiteur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;

	@NotNull
	@Column
	  private String nom;

	@NotNull
	@Column
	  private String prenom;

	@NotNull
	@Column
	  private String tel;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	  private ERole role;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vol_conduiteur",
			joinColumns = @JoinColumn(name = "id_conduiteur"),
			inverseJoinColumns = @JoinColumn(name = "id_vol"))
	private Set<Vol> vols = new HashSet<>();

	public Conduiteur() {
		super();
	}

	public Conduiteur(Long id, String nom, String prenom, String tel, ERole role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public Set<Vol> getVols() {
		return vols;
	}

	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}
}
