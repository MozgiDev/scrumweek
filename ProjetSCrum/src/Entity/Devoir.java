/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 */

public class Devoir {
    private ObjectId id;
    private String libelle;
    private String matiere;
    private Date date;
    private transient List<Rubrique> lstRubrique;

    public Devoir(String libelle, String matiere, Date date) {

        lstRubrique = new ArrayList<Rubrique>();
        this.libelle = libelle;
        this.matiere = matiere;
        this.date = date;
    }

    public Devoir() {
        lstRubrique = new ArrayList<Rubrique>();
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

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List getLstRubrique() {
        return lstRubrique;
    }

    public void addToListRubrique(Rubrique rub) {
        lstRubrique.add(rub);
    }

    public BasicDBList mapBddRubriques() {
        BasicDBList result = new BasicDBList();
        for (Rubrique rubrique : lstRubrique) {
            BasicDBObject dbRubriques = new BasicDBObject();
            dbRubriques.append("_id", rubrique.getId());
            dbRubriques.append("libelle", rubrique.getLibelle());
            dbRubriques.append("lstRubrique", rubrique.mapBddCritere());
            result.add(dbRubriques);
        }

        return result;
    }

    public void setLstRubrique(List lstRubrique) {
        this.lstRubrique = lstRubrique;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.libelle);
        hash = 53 * hash + Objects.hashCode(this.matiere);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Objects.hashCode(this.lstRubrique);
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
        final Devoir other = (Devoir) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.matiere, other.matiere)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.lstRubrique, other.lstRubrique)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle + " - " + matiere + " - " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
    }
}
