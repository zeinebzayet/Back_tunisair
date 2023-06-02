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
@Table(name="entreprise_restauration")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class EntrepriseRestauration implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String nom;
    @NotNull
    @Column
    private String adresse;
    @NotNull
    @Column
    private String tel;
    @JsonIgnore
    @OneToMany(mappedBy = "EntrepriseRestauration")
    private List<Vol> vols;

    public EntrepriseRestauration(Long id, String nom, String adresse, String tel) {
        super();
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public EntrepriseRestauration() {
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Vol> getVols() {
        return vols;
    }

    public void setVols(List<Vol> vols) {
        this.vols = vols;
    }
}