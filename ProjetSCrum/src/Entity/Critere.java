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
    public List<String> getAnnotation(){
        List<String> lstAnnotation = new ArrayList<String>();
        String ann[] = Annotation.getAnnotation(this.poid);
        for (int i = 0; i < ann.length; i++) {
        lstAnnotation.add(ann[i]);
        }
            return lstAnnotation;
    }

    
    

    
public static class Annotation {
    //sigle + apreciation
    private static String appreciation[] = {
            "N - Non Présent",
            "TI - Trés Insufisant",
            "I - Insufisant",
            "P - Passable",
            "C - Correct",
            "AB - Assez Bien",
            "B - Bien",
            "TB - Très Bien",
            "Sup - Supace les attends"};
    private static String appreciationForPoid1[] = {
            "N - Non Présent",
            "I - Insufisant",
            "C - Correct",
            "B - Bien",
            "TB - Très Bien"};
    
    private static Double notePerAnnotAndPoid[][] = { 
        {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},
        {-1.,0.25,0.25,0.5,0.5,0.75,1.,1.,2.},
        {0.25,0.5,0.5,1.,1.25,1.5,2.,2.5,5.},
        {-1.,0.75,1.,1.5,2.,2.25,3.,4.,8.},
        {0.5,1.,1.5,2.,2.5,3.,4.,5.,10.},
        {-1.,1.25,1.75,2.5,3.,3.75,5.,6.,12.},
        {0.75,1.5,2.25,3.,3.75,4.5,6.,7.5,15.},
        {1.,1.75,2.75,3.5,4.5,5.25,7.,9.,18.},
        {-1.,2.,3.,4.,5.,6.,8.,10.,20.}};
    
    public static String[] getAnnotation(int poid){
        if (poid == 1) {
            return appreciationForPoid1;
        }else{
            return appreciation;
        }
    }
    


}
}





