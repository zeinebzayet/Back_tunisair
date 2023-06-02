package Tunisair.entity;

import java.io.Serializable;
import java.sql.Date;

import Tunisair.enums.EType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;



@Entity
@Table(name="vol")
public class Vol implements Serializable {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;

	@NotNull
	@Column
	  private String reference;

	@NotNull
	@Column
	  private Date dateDepart;

	@NotNull
	@Column
	  private Date dateArrivee;

	@NotNull
	@Column
	  private String etat;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	  private EType type;

	@NotNull
	@Column
	  private double prix;

	@ManyToOne
	@JoinColumn(name = "avion_id")
	  private Avion avion;

	  @ManyToOne
	  @JoinColumn(name = "staff_id")
	  private Staff Staff;

	  @ManyToOne
	  @JoinColumn(name = "entreprise_restauration_id")
	  private EntrepriseRestauration EntrepriseRestauration;

	@ManyToOne
	@JoinColumn(name = "aeroport_depart_id")
	  private Aeroport aeroportDepart;

	@ManyToOne
	@JoinColumn(name = "aeroport_arrivee_id")
	  private Aeroport aeroportArrivee;

	public Vol() {
		super();
	}

	public Vol(Long id, String reference, Date dateDepart, Date dateArrivee, String etat, EType type, double prix) {
		super();
		this.id = id;
		this.reference = reference;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.etat = etat;
		this.type = type;
		this.prix = prix;
	}

	public Vol(Long id, String reference, Date dateDepart, Date dateArrivee, String etat, EType type, double prix, Avion avion, Tunisair.entity.Staff staff, Tunisair.entity.EntrepriseRestauration entrepriseRestauration, Aeroport aeroportDepart, Aeroport aeroportArrivee) {
		super();
		this.id = id;
		this.reference = reference;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.etat = etat;
		this.type = type;
		this.prix = prix;
		this.avion = avion;
		Staff = staff;
		EntrepriseRestauration = entrepriseRestauration;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public EType getType() {
		return type;
	}

	public void setType(EType type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Tunisair.entity.Staff getStaff() {
		return Staff;
	}

	public void setStaff(Tunisair.entity.Staff staff) {
		Staff = staff;
	}

	public Tunisair.entity.EntrepriseRestauration getEntrepriseRestauration() {
		return EntrepriseRestauration;
	}

	public void setEntrepriseRestauration(Tunisair.entity.EntrepriseRestauration entrepriseRestauration) {
		EntrepriseRestauration = entrepriseRestauration;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}
}
