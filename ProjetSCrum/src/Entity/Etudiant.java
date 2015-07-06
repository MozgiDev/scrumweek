/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author kohadon
 */
public class Etudiant {
    ObjectId id;
    String prenom, nom, classe;

    public Etudiant(ObjectId id, String prenom, String nom, String classe) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.classe = classe;
    }
    
    public Etudiant(String prenom, String nom, String classe) {
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    @Override
    public String toString() {
        return prenom + ", " + nom;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.prenom);
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.classe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etudiant other = (Etudiant) obj;
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        return true;
    }
    
    
        
}
