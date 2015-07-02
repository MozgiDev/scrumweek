/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marian
 */
public class Critere {
    private int id;
    private String libelle;
    private int poid; 

    public Critere(String libelle, int poid) {
        this.libelle = libelle;
        this.poid = poid;
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

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
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
        if (this.id != other.id) {
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
    public List<Annotation> getAnnotation(){
            List<Annotation> listAnnotation = new ArrayList<Annotation>();
            return listAnnotation;
    }

    
    

    
public class Annotation {
    private String appreciation[] = {
            "Non Présent",
            "Trés Insufisant",
            "Insufisant",
            "Passable",
            "Correct",
            "Assez Bien",
            "Bien",
            "Très Bien",
            "Supace les attends"};
    
    private String sigleNote[] = {
            "Non Présent",
            "Trés Insufisant",
            "Insufisant",
            "Passable",
            "Correct",
            "Assez Bien",
            "Bien",
            "Très Bien",
            "Supace les attends"};
    private int premiersNombres[][] = { {0,2,4,6,8},{1,3,5,7,9} };
    }



}





