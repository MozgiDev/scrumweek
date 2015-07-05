var ws = "http://192.168.0.17:3000";
angular.module('starter.controllers', [])

    .controller('menuCtrl', function ($scope, $http) {
        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.rubriques = resp.data.lstRubrique;
            $scope.groupes = resp.data.lstGroupe;
            $scope.cbx = [{
                "groupe": [{"libelle":"", "lstEtudiant": [{"nom":"","prenom":"","classe":""}]}]
            }]
            $scope.updateGroupe = function() {
                $scope.choixGroupe = $scope.cbx.groupe;
            }
        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })
    })

    .controller('DashCtrl', function ($scope, $http) {

        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.devoir = resp.data;
        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })
    })

    .controller('Rubrique1Ctrl', function ($scope, $http, $state) {

        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.rubrique = resp.data.lstRubrique[0];
            $scope.criteres = resp.data.lstRubrique[0].lstCritere;
            $scope.appreciations1 = listeAppreciation[0];
            $scope.appreciationsFull = listeAppreciation[1];
            $scope.choix = $scope.choixGroupe;
            $scope.cbx = [{
                "appreciation0": [{"libelle": "", "poids": ""}],
                "appreciation1": [{"libelle": "", "poids": ""}],
                "appreciation2": [{"libelle": "", "poids": ""}],
                "appreciation3": [{"libelle": "", "poids": ""}],
                "appreciation4": [{"libelle": "", "poids": ""}]

            }]
            $scope.updateNote = function(unCritere, uneAppreciation, unGroupe) {
                var groupe = unGroupe.libelle;
                var etudiants = unGroupe.lstEtudiant;
                var param = JSON.stringify({critere:unCritere, appreciation: uneAppreciation, groupe: groupe, lstEtudiant: etudiants});
                $http.post(ws+"/devoir/notation", param, {headers: {'Content-Type': 'application/json'} });
                //$http({
                //    method: 'POST',
                //    url: ws+"/devoir/notation",
                //    headers: {'Content-Type': 'application/json;charset=utf-8'},
                //    data: $.param({'critere': critere, 'appreciation': appreciation, 'groupe': groupe})
                //})

            }

            $scope.updateNote0 = function (critere) {
                $scope.choix = $scope.cbx.appreciation0;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);

            }
            $scope.updateNote1 = function (critere) {
                $scope.choix = $scope.cbx.appreciation1;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote2 = function (critere) {
                $scope.choix = $scope.cbx.appreciation2;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote3 = function (critere) {
                $scope.choix = $scope.cbx.appreciation3;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote4 = function (critere) {
                $scope.choix = $scope.cbx.appreciation4;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }

        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })

        $scope.appreciations1 = listeAppreciation[0];
        $scope.appreciationsFull = listeAppreciation[1];
    })

    .controller('Rubrique2Ctrl', function ($scope, $http) {
        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.rubrique = resp.data.lstRubrique[1];
            $scope.criteres = resp.data.lstRubrique[1].lstCritere;
            $scope.appreciations1 = listeAppreciation[0];
            $scope.appreciationsFull = listeAppreciation[1];
            $scope.cbx = [{
                "appreciation0": [{"libelle": "", "poids": ""}],
                "appreciation1": [{"libelle": "", "poids": ""}],
                "appreciation2": [{"libelle": "", "poids": ""}],
                "appreciation3": [{"libelle": "", "poids": ""}],
                "appreciation4": [{"libelle": "", "poids": ""}]

            }]
            $scope.updateNote = function(unCritere, uneAppreciation, unGroupe) {
                var groupe = unGroupe.libelle;
                var etudiants = unGroupe.lstEtudiant;
                var param = JSON.stringify({critere:unCritere, appreciation: uneAppreciation, groupe: groupe, lstEtudiant: etudiants});
                $http.post(ws+"/devoir/notation", param, {headers: {'Content-Type': 'application/json'} });
                //$http({
                //    method: 'POST',
                //    url: ws+"/devoir/notation",
                //    headers: {'Content-Type': 'application/json;charset=utf-8'},
                //    data: $.param({'critere': critere, 'appreciation': appreciation, 'groupe': groupe})
                //})

            }

            $scope.updateNote0 = function (critere) {
                $scope.choix = $scope.cbx.appreciation0;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);

            }
            $scope.updateNote1 = function (critere) {
                $scope.choix = $scope.cbx.appreciation1;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote2 = function (critere) {
                $scope.choix = $scope.cbx.appreciation2;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote3 = function (critere) {
                $scope.choix = $scope.cbx.appreciation3;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote4 = function (critere) {
                $scope.choix = $scope.cbx.appreciation4;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }

        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })

    })

    .controller('Rubrique3Ctrl', function ($scope, $http) {
        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.rubrique = resp.data.lstRubrique[2];
            $scope.criteres = resp.data.lstRubrique[2].lstCritere;
            $scope.appreciations1 = listeAppreciation[0];
            $scope.appreciationsFull = listeAppreciation[1];
            $scope.cbx = [{
                "appreciation0": [{"libelle": "", "poids": ""}],
                "appreciation1": [{"libelle": "", "poids": ""}],
                "appreciation2": [{"libelle": "", "poids": ""}],
                "appreciation3": [{"libelle": "", "poids": ""}],
                "appreciation4": [{"libelle": "", "poids": ""}]

            }]
            $scope.updateNote = function(unCritere, uneAppreciation, unGroupe) {
                var groupe = unGroupe.libelle;
                var etudiants = unGroupe.lstEtudiant;
                var param = JSON.stringify({critere:unCritere, appreciation: uneAppreciation, groupe: groupe, lstEtudiant: etudiants});
                $http.post(ws+"/devoir/notation", param, {headers: {'Content-Type': 'application/json'} });
                //$http({
                //    method: 'POST',
                //    url: ws+"/devoir/notation",
                //    headers: {'Content-Type': 'application/json;charset=utf-8'},
                //    data: $.param({'critere': critere, 'appreciation': appreciation, 'groupe': groupe})
                //})

            }

            $scope.updateNote0 = function (critere) {
                $scope.choix = $scope.cbx.appreciation0;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);

            }
            $scope.updateNote1 = function (critere) {
                $scope.choix = $scope.cbx.appreciation1;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote2 = function (critere) {
                $scope.choix = $scope.cbx.appreciation2;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote3 = function (critere) {
                $scope.choix = $scope.cbx.appreciation3;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote4 = function (critere) {
                $scope.choix = $scope.cbx.appreciation4;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }

        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })

    })

    .controller('Rubrique4Ctrl', function ($scope, $http) {
        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.rubrique = resp.data.lstRubrique[3];
            $scope.criteres = resp.data.lstRubrique[3].lstCritere;
            $scope.appreciations1 = listeAppreciation[0];
            $scope.appreciationsFull = listeAppreciation[1];
            $scope.cbx = [{
                "appreciation0": [{"libelle": "", "poids": ""}],
                "appreciation1": [{"libelle": "", "poids": ""}],
                "appreciation2": [{"libelle": "", "poids": ""}],
                "appreciation3": [{"libelle": "", "poids": ""}],
                "appreciation4": [{"libelle": "", "poids": ""}]

            }]
            $scope.updateNote = function(unCritere, uneAppreciation, unGroupe) {
                var groupe = unGroupe.libelle;
                var etudiants = unGroupe.lstEtudiant;
                var param = JSON.stringify({critere:unCritere, appreciation: uneAppreciation, groupe: groupe, lstEtudiant: etudiants});
                $http.post(ws+"/devoir/notation", param, {headers: {'Content-Type': 'application/json'} });
                //$http({
                //    method: 'POST',
                //    url: ws+"/devoir/notation",
                //    headers: {'Content-Type': 'application/json;charset=utf-8'},
                //    data: $.param({'critere': critere, 'appreciation': appreciation, 'groupe': groupe})
                //})

            }

            $scope.updateNote0 = function (critere) {
                $scope.choix = $scope.cbx.appreciation0;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);

            }
            $scope.updateNote1 = function (critere) {
                $scope.choix = $scope.cbx.appreciation1;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote2 = function (critere) {
                $scope.choix = $scope.cbx.appreciation2;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote3 = function (critere) {
                $scope.choix = $scope.cbx.appreciation3;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote4 = function (critere) {
                $scope.choix = $scope.cbx.appreciation4;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }

        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })
    })

    .controller('Rubrique5Ctrl', function ($scope, $http) {
        $http.get(ws+'/devoir.json').then(function (resp) {
            $scope.rubrique = resp.data.lstRubrique[4];
            $scope.criteres = resp.data.lstRubrique[4].lstCritere;
            $scope.appreciations1 = listeAppreciation[0];
            $scope.appreciationsFull = listeAppreciation[1];
            $scope.cbx = [{
                "appreciation0": [{"libelle": "", "poids": ""}],
                "appreciation1": [{"libelle": "", "poids": ""}],
                "appreciation2": [{"libelle": "", "poids": ""}],
                "appreciation3": [{"libelle": "", "poids": ""}],
                "appreciation4": [{"libelle": "", "poids": ""}]

            }]
            $scope.updateNote = function(unCritere, uneAppreciation, unGroupe) {
                var groupe = unGroupe.libelle;
                var etudiants = unGroupe.lstEtudiant;
                var param = JSON.stringify({critere:unCritere, appreciation: uneAppreciation, groupe: groupe, lstEtudiant: etudiants});
                $http.post(ws+"/devoir/notation", param, {headers: {'Content-Type': 'application/json'} });
                //$http({
                //    method: 'POST',
                //    url: ws+"/devoir/notation",
                //    headers: {'Content-Type': 'application/json;charset=utf-8'},
                //    data: $.param({'critere': critere, 'appreciation': appreciation, 'groupe': groupe})
                //})

            }

            $scope.updateNote0 = function (critere) {
                $scope.choix = $scope.cbx.appreciation0;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);

            }
            $scope.updateNote1 = function (critere) {
                $scope.choix = $scope.cbx.appreciation1;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote2 = function (critere) {
                $scope.choix = $scope.cbx.appreciation2;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote3 = function (critere) {
                $scope.choix = $scope.cbx.appreciation3;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }
            $scope.updateNote4 = function (critere) {
                $scope.choix = $scope.cbx.appreciation4;
                $scope.selectedCritere = critere;
                $scope.selectedGroupe = $scope.choixGroupe;
                $scope.updateNote(critere, $scope.choix, $scope.choixGroupe);
            }

        }, function (err) {
            console.error('ERR', err);
            // err.status will contain the status code
        })
    })

    .controller('ChatsCtrl', function ($scope, Chats) {
        // With the new view caching in Ionic, Controllers are only called
        // when they are recreated or on app start, instead of every page change.
        // To listen for when this page is active (for example, to refresh data),
        // listen for the $ionicView.enter event:
        //
        //$scope.$on('$ionicView.enter', function(e) {
        //});

        $scope.chats = Chats.all();
        $scope.remove = function (chat) {
            Chats.remove(chat);
        }
    })

    .controller('ChatDetailCtrl', function ($scope, $stateParams, Chats) {
        $scope.chat = Chats.get($stateParams.chatId);
    })

    .controller('AccountCtrl', function ($scope) {
        $scope.settings = {
            enableFriends: true
        };
    });
