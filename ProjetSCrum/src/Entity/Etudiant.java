/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author kohadon
 */
public class Etudiant {
    Integer id;
    String prenom, nom, classe;

    public Etudiant(Integer id, String prenom, String nom, String classe) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.classe = classe;
    }

    public Etudiant() {
        this.id = null;
        this.prenom = null;
        this.nom = null;
        this.classe = null;        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
        
}
