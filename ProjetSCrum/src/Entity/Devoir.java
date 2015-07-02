/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Devoir {
    
    private int id;
    private String libelle;
    private String matiere;
    private Date date;
    private List<Matiere> lstMatiere;

    public Devoir(String libelle, String matiere, Date date) {
        this.libelle = libelle;
        this.matiere = matiere;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List getLstMatiere() {
        return lstMatiere;
    }

    public void setLstMatiere(List lstMatiere) {
        this.lstMatiere = lstMatiere;
    }
    
    
}
