/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Critere;
import Entity.Devoir;
import Entity.Etudiant;
import Entity.Groupe;
import Entity.Note;
import Entity.Rubrique;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;
import static java.lang.System.out;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 */
public class DAO_Devoir extends DAO_Template<Devoir> {

    //On instancie le curseur
    Cursor cursor = null;

    public DAO_Devoir(Connection conn) throws UnknownHostException {
        super(conn);
    }

    @Override
    public boolean create(Devoir obj) {
        /*
         *   Création d'un objet document
         *   On lui passe en paramètre les clés associé de ses valeurs
         */
        BasicDBObject doc = new BasicDBObject("libelle", obj.getLibelle())
                .append("matiere", obj.getMatiere())
                .append("date", obj.getDate())
                .append("lstRubrique", obj.mapBddRubriques())
                .append("lstGroupe", obj.mapBddGroupes());
        /*
         * On insère dans la BDD
         */
        collection.insert(doc);

        return true;
    }

    @Override
    public boolean delete(Devoir obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Devoir oldDevoir, Devoir newDevoir) {
        //Ceci contiendra l'objet à remplacer
        BasicDBObject doc = null;

        //on crée un nouvel objet à insérer pour remplacer celui existant
        BasicDBObject newDoc = new BasicDBObject("libelle", newDevoir.getLibelle())
                .append("matiere", newDevoir.getMatiere())
                .append("date", newDevoir.getDate())
                .append("lstRubrique", newDevoir.mapBddRubriques())
                .append("lstGroupe", newDevoir.mapBddGroupes());

        //On crée les parametres de la requete
        BasicDBObject query = new BasicDBObject();
        query.put("_id", oldDevoir.getId());
        //query.put("libelle", oldDevoir.getLibelle());
        //query.put("matiere", oldDevoir.getMatiere());
        //query.put("date", oldDevoir.getDate());

        //On met à jour l'enregistrement
        collection.update(query, newDoc);

        return true;
    }

    @Override
    public Devoir findById(ObjectId id) {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Devoir> listDevoir = new ArrayList<>();

        BasicDBObject query = new BasicDBObject("_id", id);
        cursor = collection.find(query);

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Devoir devoir = new Devoir(
                        objet.get("libelle").toString(),
                        objet.get("matiere").toString(),
                        (Date) objet.get("date"));
                //On ajoute l'id de l'enregistrement
                devoir.setId((ObjectId) objet.get("_id"));
                //On ajoute la liste des Rubriques
                devoir.setLstRubrique((List<Rubrique>) objet.get("lstRubrique"));
                //On ajoute le client à la liste
                listDevoir.add(devoir);
            }
        } finally {
            cursor.close();
        }
        return listDevoir.get(0);
    }

    @Override
    public List<Devoir> findAll() {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Devoir> listDevoir = new ArrayList<>();

        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Devoir devoir = new Devoir(
                        objet.get("libelle").toString(),
                        objet.get("matiere").toString(),
                        (Date) objet.get("date"));
                //On ajoute l'id de l'enregistrement
                devoir.setId((ObjectId) objet.get("_id"));
                //On ajoute la liste des Rubriques

                List<Rubrique> lstRubrique = new ArrayList<Rubrique>();
                BasicDBList listBDRubrique = (BasicDBList) objet.get("lstRubrique");
                
                if(listBDRubrique != null){
                Iterator itListBDRubrique = listBDRubrique.iterator();

                while (itListBDRubrique.hasNext()) {
                    List<Critere> lstCritere = new ArrayList<Critere>();
                    BasicDBObject objectCritere = (BasicDBObject) itListBDRubrique.next();
                    BasicDBList listBDCritere = (BasicDBList) objectCritere.get("lstCritere");
                    Iterator itListBDCritere = listBDCritere.iterator();
                    while (itListBDCritere.hasNext()) {//On ajoute la liste des Critere
                        BasicDBObject aDBObjectCritere = (BasicDBObject) itListBDCritere.next();
                        Critere unCritere = new Critere(
                                aDBObjectCritere.get("libelle").toString(),
                                (Integer) aDBObjectCritere.get("poid"));

                        lstCritere.add(unCritere);
                    }
                    Rubrique uneRubrique = new Rubrique(
                            objectCritere.get("libelle").toString(),
                            lstCritere);
                    lstRubrique.add(uneRubrique);
                }
                devoir.setLstRubrique(lstRubrique);//ajout list Rubrique

                List<Groupe> lstGroupe = new ArrayList<Groupe>();
                BasicDBList listBDGroupe = (BasicDBList) objet.get("lstGroupe");
                Iterator itListBDGroupe = listBDGroupe.iterator();

                while (itListBDGroupe.hasNext()) {
                    List<Etudiant> lstEtudiant = new ArrayList<Etudiant>();
                    List<Note> lstNote = new ArrayList<Note>();
                    BasicDBObject objectsGroupe = (BasicDBObject) itListBDGroupe.next();
                    BasicDBList listBDEtudiant = (BasicDBList) objectsGroupe.get("lstEtudiant");
                    Iterator itListBDEtudiant = listBDEtudiant.iterator();
                    while (itListBDEtudiant.hasNext()) {//On ajoute la liste des Critere
                        BasicDBObject aDBObjectCritere = (BasicDBObject) itListBDEtudiant.next();
                        Etudiant unEtudiant = new Etudiant(
                                aDBObjectCritere.get("nom").toString(),
                                aDBObjectCritere.get("prenom").toString(),
                                aDBObjectCritere.get("classe").toString());

                        lstEtudiant.add(unEtudiant);
                    }
                    BasicDBList listBDNote = (BasicDBList) objectsGroupe.get("lstNote");
                    Iterator itListBDNote = listBDNote.iterator();
                    while (itListBDNote.hasNext()) {//On ajoute la liste des Critere
                        BasicDBObject aDBObjectNote = (BasicDBObject) itListBDNote.next();
                        Note uneNote = new Note(
                                aDBObjectNote.get("libelle").toString(),
                                (Double) aDBObjectNote.get("poid"),
                                (Double) aDBObjectNote.get("note"));

                        lstNote.add(uneNote);
                    }
                    Groupe unGroupe = new Groupe(
                            objectsGroupe.get("libelle").toString(),
                            lstEtudiant,
                            lstNote);
                    lstGroupe.add(unGroupe);
                }
                devoir.setLstGroupe(lstGroupe);
                }
                //On ajoute le client à la liste
                listDevoir.add(devoir);
            }
        } finally {
            cursor.close();
        }
        return listDevoir;
    }

}
