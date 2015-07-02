/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Critere;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 */
public class DAO_Critere extends DAO_Template<Critere> {

    //On instancie le curseur
    Cursor cursor = null;

    public DAO_Critere(Connection conn) throws UnknownHostException {
        super(conn);
    }

    @Override
    public boolean create(Critere obj) {
        /*
         *   Création d'un objet document
         *   On lui passe en paramètre les clés associé de ses valeurs
         */
        BasicDBObject doc = new BasicDBObject("libelle", obj.getLibelle())
                .append("poid", obj.getPoid());

        /*
         * On insère dans la BDD
         */
        collection.insert(doc);

        return true;
    }

    @Override
    public boolean delete(Critere obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Critere oldCritere, Critere newCritere) {
        //Ceci contiendra l'objet à remplacer
        BasicDBObject doc = null;

        //on crée un nouvel objet à insérer pour remplacer celui existant
        BasicDBObject newDoc = new BasicDBObject("libelle", newCritere.getLibelle())
                .append("poid", newCritere.getPoid());

        //On crée les parametres de la requete
        BasicDBObject query = new BasicDBObject();
        query.put("libelle", oldCritere.getLibelle());
        query.put("poid", oldCritere.getPoid());

        //On met à jour l'enregistrement
        collection.update(query, newDoc);

        return true;
    }

    @Override
    public Critere findById(ObjectId id) {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Critere> listCritere = new ArrayList<>();

        BasicDBObject query = new BasicDBObject("_id", id);
        cursor = collection.find(query);

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Critere critere = new Critere(
                        objet.get("libelle").toString(), 
                        (int) objet.get("poid"));
                //On ajoute l'id de l'enregistrement
                critere.setId((int) objet.get("_id"));
                //On ajoute le client à la liste
                listCritere.add(critere);
            }
        } finally {
            cursor.close();
        }
        return listCritere.get(0);
    }

    @Override
    public List<Critere> findAll() {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Critere> listCritere = new ArrayList<>();

        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Critere critere = new Critere(
                        objet.get("libelle").toString(),
                        (int) objet.get("poid"));
                //On ajoute l'id de l'enregistrement
                critere.setId((int) objet.get("_id"));
                //On ajoute le client à la liste
                listCritere.add(critere);
            }
        } finally {
            cursor.close();
        }
        return listCritere;
    }

}
