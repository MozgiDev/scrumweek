/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Maxime
 */
public class Groupe 
{
Integer id;
String nom;
ArrayList<String> critere;
ArrayList<String> eleve;

    public Groupe(Integer id, String nom, ArrayList critere, ArrayList eleve) 
    {
        this.id = id;
        this.nom = nom;
        this.critere = critere;
        this.eleve = eleve;
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getNom() 
    {
        return nom;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public ArrayList<String> getCritere() 
    {
        return critere;
    }

    public void setCritere(ArrayList<String> critere) 
    {
        this.critere = critere;
    }

    public ArrayList<String> getEleve() 
    {
        return eleve;
    }

    public void setEleve(ArrayList<String> eleve) 
    {
        this.eleve = eleve;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.critere);
        hash = 67 * hash + Objects.hashCode(this.eleve);
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
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.critere, other.critere)) {
            return false;
        }
        return Objects.equals(this.eleve, other.eleve);
    }

    @Override
    public String toString() {
        return "Groupe{" + "id=" + id + ", nom=" + nom + ", critere=" + critere + ", eleve=" + eleve + '}';
    }
  
}
