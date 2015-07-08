/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import static java.lang.System.out;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Maxime
 */
public class Groupe {

    ObjectId id;
    String libelle;
    List<Etudiant> lstEtudiant;
    List<Note> lstNote;

    public Groupe() {
        this.lstNote = new ArrayList<Note>();
        this.lstEtudiant = new ArrayList<Etudiant>();
    }

    public Groupe(String libelle, List<Etudiant> lstEtudiant, List<Note> lstNote) {
        this.libelle = libelle;
        this.lstEtudiant = lstEtudiant;
        this.lstNote = lstNote;
    }

    public Groupe(ObjectId id, String libelle, List<Etudiant> lstEtudiant, List<Note> lstNote) {
        this.id = id;
        this.libelle = libelle;
        this.lstEtudiant = lstEtudiant;
        this.lstNote = lstNote;
    }

    public Groupe(String libelle, List<Etudiant> lstEtudiant) {
        this.libelle = libelle;
        this.lstEtudiant = lstEtudiant;
        this.lstNote = new ArrayList<Note>();
    }

    public Double getTotalNote() {
        Double total = 0.0;
        for (int i = 0; i < this.lstNote.size(); i++) {
            total = total + this.lstNote.get(i).getNote();
        }
        return total;
    }

    public String getTotalNote20(Devoir unDevoir) {
        Double total = 0.0;
        for (int i = 0; i < this.lstNote.size(); i++) {
            total = total + this.lstNote.get(i).getNote();
        }
        total = (total / unDevoir.getTotalPoid()) * 20;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(total);
    }

    public BasicDBList mapBddNotes() {
        BasicDBList result = new BasicDBList();
        for (Note note : lstNote) {
            BasicDBObject dbNotes = new BasicDBObject();
            //dbRubriques.append("_id", etudiant.getId());
            dbNotes.append("libelle", note.getLibelle());
            dbNotes.append("poid", note.getPoid());
            dbNotes.append("note", note.getNote());
            result.add(dbNotes);
        }

        return result;
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

    public List<Note> getLstNote() {
        return lstNote;
    }

    public void setLstNote(List<Note> lstNote) {
        this.lstNote = lstNote;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.libelle);
        hash = 67 * hash + Objects.hashCode(this.lstEtudiant);
        hash = 67 * hash + Objects.hashCode(this.lstNote);
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
        if (!Objects.equals(this.lstNote, other.lstNote)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle;
    }

}
