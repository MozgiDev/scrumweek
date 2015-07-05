/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 */
public class Rubrique {

    private ObjectId _id;
    private String libelle;
    private List<Critere> lstCritere;

    public Rubrique(ObjectId _id, String libelle, List<Critere> lstCritere) {
        this._id = _id;
        this.libelle = libelle;
        this.lstCritere = lstCritere;
    }

    public Rubrique(String libelle, List<Critere> lstCritere) {
        this.libelle = libelle;
        this.lstCritere = lstCritere;
    }

    public Rubrique(String libelle) {
        this.libelle = libelle;
    }

    public Rubrique() {

    }

    public List<Critere> parseFromDbToList(String trucQuiVientDeMongoDb) {
        List<Critere> lstCritere = new ArrayList<>();

        return lstCritere;
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

    public List<Critere> getLstCritere() {
        return lstCritere;
    }

    public void setLstCritere(List<Critere> lstCritere) {
        this.lstCritere = lstCritere;
    }

    public BasicDBList mapBddCritere() {
        BasicDBList result = new BasicDBList();
        for (Critere critere : lstCritere) {
            BasicDBObject dbRubriques = new BasicDBObject();
            //dbRubriques.append("_id", critere.getId());
            dbRubriques.append("libelle", critere.getLibelle());
            dbRubriques.append("poid", critere.getPoid());
            result.add(dbRubriques);
        }

        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this._id);
        hash = 79 * hash + Objects.hashCode(this.libelle);
        hash = 79 * hash + Objects.hashCode(this.lstCritere);
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
        final Rubrique other = (Rubrique) obj;
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.lstCritere, other.lstCritere)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle;
    }
}
