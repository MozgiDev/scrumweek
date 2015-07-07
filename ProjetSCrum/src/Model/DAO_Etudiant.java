/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Etudiant;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Cursor;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author kohadon
 */
public class DAO_Etudiant extends DAO_Template<Etudiant> {

    Cursor cursor;

    public DAO_Etudiant(Connection conn) throws UnknownHostException {
        super(conn);
        if (db.collectionExists("etudiant")) {
            collection = db.getCollection("etudiant");
        } else {
            DBObject options = BasicDBObjectBuilder.start().add("capped", false).add("size", 2000000000l).get();
            collection = db.createCollection("etudiant", options);
        }
    }

    public boolean archive() {
        if (db.collectionExists("etudiant_save")) {

        } else {
            DBObject options = BasicDBObjectBuilder.start().add("capped", false).add("size", 2000000000l).get();
            collection = db.createCollection("etudiant_save", options);
        }
        collection = db.getCollection("etudiant");
        DBCursor cursor = collection.find();
        try {
            while (cursor.hasNext()) {
                collection = db.getCollection("etudiant_save");
                collection.insert(cursor.next());
            }
            collection = db.getCollection("etudiant");
            collection.drop();

        } finally {
            cursor.close();
        }

        return true;
    }

    @Override
    public boolean create(Etudiant obj) {
        /*
         *   Création d'un objet document pour les Etudiants
         *   On lui passe en paramètre les clés associées de ses valeurs
         */
        BasicDBObject doc = new BasicDBObject("prenom", obj.getNom())
                .append("nom", obj.getPrenom())
                .append("classe", obj.getClasse());

        /*
         * On insère dans la BDD
         */
        collection.insert(doc);

        return true;
    }

    @Override
    public boolean delete(Etudiant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Etudiant obj, Etudiant obje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findAll() {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Etudiant> listEtudiant = new ArrayList<>();
        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Etudiant etudiant = new Etudiant(
                        objet.get("prenom").toString(),
                        objet.get("nom").toString(),
                        objet.get("classe").toString()
                );

                //On ajoute l'id de l'enregistrement
                etudiant.setId((ObjectId) objet.get("_id"));
                //On ajoute le client à la liste
                listEtudiant.add(etudiant);
            }
        } finally {
            cursor.close();
        }
        return listEtudiant;
    }

    @Override
    public Etudiant findById(ObjectId id) {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Etudiant> listEtudiant = new ArrayList<>();

        BasicDBObject query = new BasicDBObject("_id", id);
        cursor = collection.find(query);

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Etudiant etudiant = new Etudiant(
                        objet.get("prenom").toString(),
                        objet.get("nom").toString(),
                        objet.get("classe").toString()
                );
                //On ajoute l'id de l'enregistrement
                etudiant.setId((ObjectId) objet.get("_id"));

                //On ajoute l'étudiant à la liste
                listEtudiant.add(etudiant);
            }
        } finally {
            cursor.close();
        }
        return listEtudiant.get(0);
    }
}
