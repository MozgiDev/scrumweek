var mongo = require('mongodb');
var ObjectId = require('mongodb').ObjectId;
var Double = require('mongodb').Double;
var Server = mongo.Server,
Db = mongo.Db,
BSON = mongo.BSONPure;

//Connection au serveur hebergeant mongo sur le port par defaut
//var server = new Server('172.16.1.20', 27017, {auto_reconnect: true});
var server = new Server('127.0.0.1', 27017, {auto_reconnect: true});
//var server = new Server('192.168.0.2', 27017, {auto_reconnect: true});

//Vraiable environnement Europe : Amsterdam, Bruxelles, Paris
process.env.TZ = 'Europe/Amsterdam'
//Connection a la BDD de production
db = new Db('test', server);

//Connection à la collection "collection" 
db.open(function(err, db) {
  if(!err) {
    console.log("Connected to 'test' database");
    db.collection('collection', {strict:true}, function(err, collection) {
      if (err) {
        console.log("The 'collection' collection doesn't exist.");
      }
    });
  }
});

exports.updateNotation = function(req, res) {
   console.log("---------Update d'une note-----------");
   console.log(req.body.devoir);

   //Création de l'item Note
   var uneNote = {"libelle": req.body.critere.libelle, "poid": req.body.critere.poid, "note": Double(req.body.note)};
   console.log(uneNote); 

   //Pull de la note contenant le même libellé concaténé de format : libbele-rubrique
   db.collection('collection').update({
    "_id": ObjectId(req.body.devoir),
    "lstGroupe.libelle":req.body.groupe,
   }, 
   {
    $pull: { "lstGroupe.$.lstNote": { "libelle": req.body.critere.libelle } } 
   },
   function(err, result) {
    if (err) {
      console.log("---Error---");
      console.log(err);
    }
    if (result) {
      console.log("---Result---");
      console.log(result.result);
    }
   });

   //Ajout de l'item Note au tablau lstNote
   db.collection('collection').update({
    "_id": ObjectId(req.body.devoir),
    "lstGroupe.libelle":req.body.groupe
   }, 
   {
    $addToSet: {"lstGroupe.$.lstNote":uneNote}
   },
   function(err, result) {
    if (err) {
      console.log(err);
    }
    if (result) {
      console.log(result.result);
      res.end();
    }
   });


};


exports.findByDate = function(req, res) {
  //Récupération de la Date du jour
  var d = new Date();
  //console.log('Retrieving devoirs: ' + d);
  //Récupération des infos utiles
  year = d.getFullYear();
  month = d.getMonth();
  day = d.getUTCDate();

  //Création de la date à minuit par défaut
  dateNow = new Date(year,month,day);

  console.log('date ISO: ' + dateNow.toISOString());//2015-08-03T22:00:00.000Z

  db.collection('collection', function(err, collection) {

    //Recherche d'une note sur la Date
    collection.findOne({ date:new Date(dateNow.toISOString())}, function(err, item) {
      //console.log('send item: '+item);
      //console.log('send err: '+err);
      res.send(item);
      res.end();
    })
  });

};
