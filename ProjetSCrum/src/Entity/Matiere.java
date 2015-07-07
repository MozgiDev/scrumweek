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
 * @author Jérôme
 */
public class Matiere {

    ObjectId id;
    String libelle;
    String classe;

    public Matiere(ObjectId id, String unLibelle) {
        this.id = id;
        this.libelle = unLibelle;
    }

    public Matiere(ObjectId id, String unLibelle, String uneClasse) {
        this.id = id;
        this.libelle = unLibelle;
        this.classe = uneClasse;
    }

    public Matiere() {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.libelle);
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
        final Matiere other = (Matiere) obj;
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle;
    }

}
