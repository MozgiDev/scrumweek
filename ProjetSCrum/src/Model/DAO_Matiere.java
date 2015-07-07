/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Matiere;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Jérôme
 */
public class DAO_Matiere extends DAO_Template<Matiere> {

    protected DBCollection collection;
    protected Cursor cursor = null;

    public DAO_Matiere(Connection conn) throws UnknownHostException {
        super(conn);
        if (db.collectionExists("matiere2")) {
            collection = db.getCollection("matiere2");
        } else {
            DBObject options = BasicDBObjectBuilder.start().add("capped", false).add("size", 2000000000l).get();
            collection = db.createCollection("matiere2", options);
        }
    }

    @Override
    public boolean create(Matiere obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Matiere obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Matiere obj, Matiere obje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matiere findById(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Matiere> findAll() {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Matiere> listMatiere = new ArrayList<>();

        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Matiere matiere = new Matiere();
                matiere.setLibelle(objet.get("libelle").toString());
                matiere.setId((ObjectId) objet.get("_id"));
                listMatiere.add(matiere);
            }
        } finally {
            cursor.close();
        }
        return listMatiere;
    }
    
       public List<Matiere> findByClasse(String uneClasse) {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Matiere> listMatiere = new ArrayList<>();
        BasicDBObject filter = new BasicDBObject();
        BasicDBObject query = new BasicDBObject("classe", uneClasse);
        cursor = collection.find(query, filter);

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Matiere matiere = new Matiere();
                matiere.setLibelle(objet.get("libelle").toString());
                matiere.setId((ObjectId) objet.get("_id"));
                matiere.setClasse(objet.get("classe").toString());
                listMatiere.add(matiere);
            }
        } finally {
            cursor.close();
        }
        return listMatiere;
    }

}
