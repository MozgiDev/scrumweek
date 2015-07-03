/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.HashMap;

/**
 *
 * @author Marian
 */
 public class Annotation extends Critere  {

        //sigle + apreciation
        private HashMap<String,Integer> mapAnnot;

        private Double notePerAnnotAndPoid[][] = {
            {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
            {-1., 0.25, 0.25, 0.5, 0.5, 0.75, 1., 1., 2.},
            {0.25, 0.5, 0.5, 1., 1.25, 1.5, 2., 2.5, 5.},
            {-1., 0.75, 1., 1.5, 2., 2.25, 3., 4., 8.},
            {0.5, 1., 1.5, 2., 2.5, 3., 4., 5., 10.},
            {-1., 1.25, 1.75, 2.5, 3., 3.75, 5., 6., 12.},
            {0.75, 1.5, 2.25, 3., 3.75, 4.5, 6., 7.5, 15.},
            {1., 1.75, 2.75, 3.5, 4.5, 5.25, 7., 9., 18.},
            {-1., 2., 3., 4., 5., 6., 8., 10., 20.}};

        public Annotation(){
            this.mapAnnot = new HashMap<String, Integer>();
            if (super.poid == 1) {
                mapAnnot.put("N - Non Présent",0);
                mapAnnot.put("TI - Trés Insufisant",1);
                mapAnnot.put("I - Insufisant",2);
                mapAnnot.put("P - Passable",3);
                mapAnnot.put("C - Correct",4);
                mapAnnot.put("AB - Assez Bien",5);
                mapAnnot.put("B - Bien",6);
                mapAnnot.put("TB - Très Bien",7);
                mapAnnot.put("Sup - Supace les attends",8);
            } else {
                mapAnnot.put("N - Non Présent",0);
                mapAnnot.put("I - Insufisant",2);
                mapAnnot.put("C - Correct",4);
                mapAnnot.put("B - Bien",6);
                mapAnnot.put("TB - Très Bien",7);
            }
            //v = map.get(clé1); //La variable v reçoit la valeur val1.
            
        }

        public HashMap<String,Integer> getAnnotation(int poid) {
             return this.mapAnnot;            
        }
        public Double getNote(String annot) {
            int col = this.mapAnnot.get(annot);
            int lig = super.poid;
            return this.notePerAnnotAndPoid[lig][col];
        }
    }
