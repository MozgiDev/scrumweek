/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Devoir;
import com.mongodb.BasicDBObject;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAO_Devoir extends DAO_Template<Devoir> {

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
                .append("lstCritere", obj.getLstCritere());

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
    public List<Devoir> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Devoir> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
