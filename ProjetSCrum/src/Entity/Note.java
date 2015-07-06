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
 * @author Marian
 */
public class Note {
    private ObjectId _id;
    private String libelle;
    protected double poid;
    protected double note;

    public Note(String libelle, double poid, double note) {
        this.libelle = libelle;
        this.poid = poid;
        this.note = note;
    }

    public Note() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this._id);
        hash = 37 * hash + Objects.hashCode(this.libelle);
        hash = 37 * hash + Objects.hashCode(this.poid);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.note) ^ (Double.doubleToLongBits(this.note) >>> 32));
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
        final Note other = (Note) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (this.poid != other.poid) {
            return false;
        }
        if (Double.doubleToLongBits(this.note) != Double.doubleToLongBits(other.note)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Note{" + "_id=" + _id + ", libelle=" + libelle + ", poid=" + poid + ", note=" + note + '}';
    }
    
    
    
    
    
}
