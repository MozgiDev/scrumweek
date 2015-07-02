/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
    private ObjectId id;
    private String libelle;
    private List<Critere> lstCritere;
    
    public Rubrique(String libelle) {
        this.libelle = libelle;
    }

    public Rubrique() {
       
    }
    
    public List<Critere> parseFromDbToList(String trucQuiVientDeMongoDb)
    {
        List<Critere> lstCritere = new ArrayList<>();
        
        return lstCritere;
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

    public List<Critere> getLstCritere() {
        return lstCritere;
    }

    public void setLstCritere(List<Critere> lstCritere) {
        this.lstCritere = lstCritere;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
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
    
    
    
}
