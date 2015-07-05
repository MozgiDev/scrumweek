/**
 * Created by Jérôme on 03/07/2015.
 */
var listeDevoir = {
    "ObjectId": "_878798988786",
    "libelle": "Devoir JAVA n1",
    "matiere": "Java",
    "date": "03/07/2015",
    "lstRubrique": [
        {
            "ObjectId": "_54545454",
            "libelle": "rubrique n1",
            "rang": "r1",
            "lstCritere": [
                {
                    "ObjectId": "_09090909",
                    "libelle": "critere 1",
                    "poids": 1
                },
                {
                    "ObjectId": "_09090909",
                    "libelle": "critere 2",
                    "poids": 2
                }
            ]
        },
        {
            "ObjectId": "_545454555",
            "libelle": "rubrique n2",
            "rang": "r2",
            "lstCritere": [
                {
                    "ObjectId": "_09090909",
                    "libelle": "critere 1",
                    "poids": 8
                },
                {
                    "ObjectId": "_09090909",
                    "libelle": "critere 2",
                    "poids": 20
                }
            ]
        }
    ]
}


var listeAppreciation =
    [{
        "poids": 1,
        "lstAppreciation": [
            {"id": 0, "sigle": "N", "value": "N - Non Present"},
            {"id": 2, "sigle": "I", "value": "I - Insufisant"},
            {"id": 4, "sigle": "C", "value": "C - Correct"},
            {"id": 6, "sigle": "B", "value": "B - Bien"},
            {"id": 7, "sigle": "TB", "value": "TB- Tres bien"}
        ]
    },
        {
            "poids": 0,
            "lstAppreciation": [
                {"id": 0, "sigle": "N", "value": "N - Non Present"},
                {"id": 1, "sigle": "TI", "value": "TI - Tres insufisant"},
                {"id": 2, "sigle": "I", "value": "I - Insufisant"},
                {"id": 3, "sigle": "P", "value": "P - Passable"},
                {"id": 4, "sigle": "C", "value": "C - Correct"},
                {"id": 5, "sigle": "AB", "value": "AB - Assez bien"},
                {"id": 6, "sigle": "B", "value": "B - Bien"},
                {"id": 7, "sigle": "TB", "value": "TB- Tres bien"},
                {"id": 8, "sigle": "Sup", "value": "Sup - Surpasse"}
            ]
        }]
