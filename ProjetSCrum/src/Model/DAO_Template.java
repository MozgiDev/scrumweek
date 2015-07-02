/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class DAO_Template<T> {

    protected MongoClient mongoClient = null;
    protected DB db = null;
    protected DBCollection collection;

    public DAO_Template(Connection conn) throws UnknownHostException {

       // try {
            this.mongoClient = new MongoClient("172.16.1.20", 27017);
            db = mongoClient.getDB("test");

            if (db.collectionExists("collection")) {
                collection = db.getCollection("collection");
            } else {
                DBObject options = BasicDBObjectBuilder.start().add("capped", false).add("size", 2000000000l).get();
                collection = db.createCollection("collection", options);
            }

       // } catch (Exception ex) {
         //   Logger.getLogger(DAO_Template.class.getName()).log(Level.SEVERE, null, ex);
        //}

    }

    /**
     *
     * Méthode de création
     *
     * @param obj
     *
     * @return boolean *
     */
    public abstract boolean create(T obj);

    /**
     *
     * Méthode pour effacer
     *
     * @param obj
     *
     * @return boolean *
     */
    public abstract boolean delete(T obj);

    /**
     *
     * Méthode de mise à jour
     *
     * @param obj
     *
     * @return boolean
     *
     */
    public abstract boolean update(T obj, T obje);

    /**
     *
     * Méthode de recherche des informations
     *
     * @param id
     *
     * @return T
     *
     */
    public abstract T findById(ObjectId id);

    /**
     *
     * Méthode de recherche des informations
     *
     * @return T
     *
     */
    public abstract List<T> findAll();
}
