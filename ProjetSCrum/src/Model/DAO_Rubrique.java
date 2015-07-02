/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Rubrique;
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
public class DAO_Rubrique extends DAO_Template<Rubrique> {

    //On instancie le curseur
    Cursor cursor = null;
    
    public DAO_Rubrique(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Rubrique obj) {
        /*
         *   Création d'un objet document
         *   On lui passe en paramètre les clés associé de ses valeurs
         */
        BasicDBObject doc = new BasicDBObject("libelle", obj.getLibelle())
                .append("lstRubrique", obj.getLstCritere());
        
        /*
         * On insère dans la BDD
         */
        collection.insert(doc);

        return true;
    }

    @Override
    public boolean delete(Rubrique obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Rubrique obj, Rubrique obje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rubrique findById(ObjectId id) {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Rubrique> listRubrique = new ArrayList<Rubrique>();

        BasicDBObject query = new BasicDBObject("_id", id);
        cursor = collection.find(query);        

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Rubrique rubrique = new Rubrique(
                        objet.get("libelle").toString());
                //On ajoute l'id de l'enregistrement
                rubrique.setId((ObjectId) objet.get("_id"));
                //On ajoute la liste des Rubriques
                rubrique.setLstCritere(rubrique.parseFromDbToList((String)objet.get("lstCritere")));
                //On ajoute le client à la liste
                listRubrique.add(rubrique);
            }
        } finally {
            cursor.close();
        }
        return listRubrique.get(0); 
    }

    @Override
    public List<Rubrique> findAll() {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Rubrique> listRubrique = new ArrayList<Rubrique>();

        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Rubrique rubrique = new Rubrique(
                        objet.get("libelle").toString());
                //On ajoute l'id de l'enregistrement
                rubrique.setId((ObjectId) objet.get("_id"));
                //On ajoute la liste des Rubriques
                rubrique.setLstCritere(rubrique.parseFromDbToList((String)objet.get("lstRubrique")));
                //On ajoute le client à la liste
      
                listRubrique.add(rubrique);
            }
        } finally {
            cursor.close();
        }
        return listRubrique;
    }
}
