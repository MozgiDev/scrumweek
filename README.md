**ScrumWeek**
===========

Semaine de développement Scrum organisé par le Lycée Pasteur Mont Roland. La release du projet se fait à la fin de la semaine qui contient quatre sprint d'une journée.

----------
Résumé
-------------
Developpement d'un logiciel permettant de noter un oral à l'aide d'une application sous androïd. Les devoirs sont créés à l'aide d'une application en Java.

Les données sont stockées dans une base de données MongoDB à partir de l'application Java pour la création des devoirs, et à l'aide d'un WebService créé avec NodeJS.

----------
Java
-------------
L'application Java permet de créer un devoir daté affecté à une classe. Les devoirs ont une matière et un libellé, on peut y affecter un maximum de 5 rubriques qui elles même contiennent 5 critères maximum avec un poids qui permettra de noter le devoir.
Ces devoirs peuvent être modifiés, mais en aucun cas supprimés.

Il est possible de consulter un tableau des notes des devoirs par élèves, et un autre tableau des notes des critères pour chaque groupes.

Afin de pouvoir affecter des élèves à un devoir, il faut tout d'abord les importer à partir d'un fichier Excel.
> **Note:** Le choix de Java et l'import à partir d'un fichierExcel a été imposé par le Product Owner du projet scrum.

----------
Androïd
-------------------
L'application Androïd a été dévellopée à l'aide de Cordova et du Framework Ionic. La page d'accueil permet de sélectionner le groupe qui va passer l'oral du jour.
Les pages suivantes correspondent aux rubriques qui contiennes les critères. Ces critères sont notables à partir d'appréciations, les notes de chaque critères sont renvoyées au WebService qui les enregistrent dans la base de données MongoDB.

----------
Web Service
-------------------
Le Web Service a été créé à l'aide de NodeJS, il est composé d'un serveur qui permet de lancer Express et de déclarer les routes; et d'un script devoirs.js qui permet de récupérer le devoir du jour (findByDate), et de mettre à jour les notes qui sont stockées dans un tableau lui même dans un tableau (UpdateNotation).
