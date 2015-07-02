/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Devoir;
import Entity.Groupe;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 */
public class DAO_Groupe extends DAO_Template<Groupe> {

    //On instancie le curseur
    Cursor cursor = null;

    public DAO_Groupe(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Groupe obj) {

        /*
         *   Création d'un objet document
         *   On lui passe en paramètre les clés associé de ses valeurs
         */
        BasicDBObject doc = new BasicDBObject("Nom", obj.getNom())
                .append("Critere", obj.getCritere())
                .append("Eleve", obj.getEleve())
                .append("Devoir", obj.getDevoir());

        /*
         * On insère dans la BDD
         */
        collection.insert(doc);

        return true;
    }

    @Override
    public boolean delete(Groupe obj) {

//        // L'id de notre enregistrement est de type ObjectId, un objet BSON sur 12 octet
//        ObjectId id = new ObjectId(obj.getId().toString());
//        // Creation de notre document BSON, auquel on ajoute l'id
//        BasicDBObject query = new BasicDBObject();
//        query.append("_id", id);
//        // On supprimer l'entree
//        collection.remove(query);

        return true;
    }

    @Override
    public boolean update(Groupe oldGroupe, Groupe newGroupe) {
        //Ceci contiendra l'objet à remplacer
        BasicDBObject doc = null;

        //on crée un nouvel objet à insérer pour remplacer celui existant
        BasicDBObject newDoc = new BasicDBObject("Nom", newGroupe.getNom())
                .append("Critere", newGroupe.getCritere())
                .append("Eleve", newGroupe.getEleve())
                .append("Devoir", newGroupe.getDevoir());
        
        //On crée les parametres de la requete
        BasicDBObject query = new BasicDBObject();
        query.put("Nom", oldGroupe.getNom());
        query.put("Critere", oldGroupe.getCritere());
        query.put("Eleve", oldGroupe.getCritere());
        query.put("Devoir", oldGroupe.getDevoir());

        //On met à jour l'enregistrement
        collection.update(query, newDoc);

        return true;
    }

    @Override
    public Groupe findById(ObjectId id) 
    {
        List<Groupe> listGroupe;
        listGroupe = new ArrayList<>();
        BasicDBObject query = new BasicDBObject("_id", id);
        cursor = collection.find(query);
        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                //On ajoute l'id de l'enregistrement
                Groupe groupe = new Groupe();
                groupe.setNom((String) objet.get("Nom"));
                groupe.setCritere((ArrayList<String>) objet.get("Critere"));
                groupe.setEleve((ArrayList<String>) objet.get("Eleve"));
                groupe.setDevoir((Devoir) objet.get("Devoir"));
                groupe.setId((Integer) objet.get("_id"));
                //On ajoute le client à la liste
                listGroupe.add(groupe);
            }
        } finally {
            cursor.close();
        }
        return listGroupe.get(0);
    }

    @Override
    public List<Groupe> findAll() 
    {
        List<Groupe> listGroupe = new ArrayList<>();
        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                //On ajoute l'id de l'enregistrement
                Groupe groupe = new Groupe();
                groupe.setNom((String) objet.get("Nom"));
                groupe.setCritere((ArrayList<String>) objet.get("Critere"));
                groupe.setEleve((ArrayList<String>) objet.get("Eleve"));
                groupe.setDevoir((Devoir) objet.get("Devoir"));
                groupe.setId((Integer) objet.get("_id"));
                //On ajoute le client à la liste
                listGroupe.add(groupe);
            }
        } finally {
            cursor.close();
        }
        return listGroupe;
    }

}
