package Tunisair.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="passagers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passagers implements Serializable {
    @Id
    private Long cin;
    @NotNull
    @Column
    private String nom;
    @NotNull
    @Column
    private String prenom;
    @NotNull
    @Column
    private Long tel;
    @NotNull
    @Column
    private String email;
    @NotNull
    @Column
    private String password;

    public Passagers(Long cin, String nom, String prenom, Long tel, String email, String password) {
        super();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public Passagers() {
        super();
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
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

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
