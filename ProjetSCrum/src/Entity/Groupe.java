/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Maxime
 */
public class Groupe 
{
ObjectId id;
String libelle;
List<Etudiant> lstEtudiant;



    public Groupe() 
    {
        lstEtudiant = new ArrayList<Etudiant>();
    }

    public Groupe(String libelle, List<Etudiant> lstEtudiant) {
        this.libelle = libelle;
        this.lstEtudiant = lstEtudiant;
    }

    public Groupe(ObjectId id, String libelle, List<Etudiant> lstEtudiant) {
        this.id = id;
        this.libelle = libelle;
        this.lstEtudiant = lstEtudiant;
    }
    
    public BasicDBList mapBddEtudiants() {
        BasicDBList result = new BasicDBList();
        for (Etudiant etudiant : lstEtudiant) {
            BasicDBObject dbEtudiants = new BasicDBObject();
            //dbRubriques.append("_id", etudiant.getId());
            dbEtudiants.append("nom", etudiant.getNom());
            dbEtudiants.append("prenom", etudiant.getPrenom());
            dbEtudiants.append("classe", etudiant.getClasse());
            result.add(dbEtudiants);
        }

        return result;
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

    public List<Etudiant> getLstEtudiant() {
        return lstEtudiant;
    }

    public void setLstEtudiant(List<Etudiant> lstEtudiant) {
        this.lstEtudiant = lstEtudiant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.libelle);
        hash = 17 * hash + Objects.hashCode(this.lstEtudiant);
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
        final Groupe other = (Groupe) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.lstEtudiant, other.lstEtudiant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Groupe{" + "id=" + id + ", libelle=" + libelle + ", lstEtudiant=" + lstEtudiant + '}';
    }
    
    


  
}
