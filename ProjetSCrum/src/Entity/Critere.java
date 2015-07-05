/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Marian
 */
public class Critere {

    private ObjectId _id;
    private String libelle;
    protected int poid;

    public Critere(ObjectId _id, String libelle, int poid) {
        this._id = _id;
        this.libelle = libelle;
        this.poid = poid;
    }

    public Critere(String libelle, int poid) {
        this.libelle = libelle;
        this.poid = poid;
    }

    public Critere() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this._id);
        hash = 61 * hash + Objects.hashCode(this.libelle);
        hash = 61 * hash + this.poid;
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
        final Critere other = (Critere) obj;
        if (this._id != other._id) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (this.poid != other.poid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle + " - " + String.valueOf(poid);
    }

}
