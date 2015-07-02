/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Devoir;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBObject;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAO_Devoir extends DAO_Template<Devoir> {

    //On instancie le curseur
    Cursor cursor = null;
    
    public DAO_Devoir(Connection conn) {
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
                .append("lstRubrique", obj.getLstRubrique());

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
    public boolean update(Devoir obj, Devoir obje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Devoir findById(int id) {
         
    }

    @Override
    public List<Devoir> findAll() {
        //On instancie la liste qui va contenir les clients retournés par la requête
        List<Devoir> listDevoir = new ArrayList<Devoir>();

        cursor = collection.find();

        try {
            //Pour chaque enregistrement trouvé
            while (cursor.hasNext()) {
                //On instancie un objet
                DBObject objet = cursor.next();
                //On le cast en client en rentrant les parametres
                Devoir client = new Devoir(
                        objet.get("libelle").toString(),
                        objet.get("matiere").toString(),
                        objet.get("date").toString());
                //On ajoute l'id de l'enregistrement
                client.setId(objet.get("_id").toString());
                //On ajoute la liste des Rubriques
                client.setLstRubrique(objet.get("lstRubrique").);
                //On ajoute le client à la liste
                listClient.add(client);
            }
        } finally {
            cursor.close();
        }
        return listClient;
    }

    
    
}
