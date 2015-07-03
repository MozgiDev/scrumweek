angular.module('starter.controllers', [])

    .controller('menuCtrl', function ($scope) {

        $scope.rubriques = listeDevoir.lstRubrique;
    })

    .controller('Rubrique1Ctrl', function ($scope) {
        $scope.rubrique = listeDevoir.lstRubrique[0];
        $scope.criteres = listeDevoir.lstRubrique[0].lstCritere;
    })

    .controller('Rubrique2Ctrl', function($scope) {
        $scope.rubrique = listeDevoir.lstRubrique[1];
        $scope.criteres = listeDevoir.lstRubrique[1].lstCritere;
    })

    .controller('Rubrique3Ctrl', function($scope) {
        $scope.rubrique = listeDevoir.lstRubrique[2];
        $scope.criteres = listeDevoir.lstRubrique[2].lstCritere;
    })

    .controller('Rubrique4Ctrl', function($scope) {
        $scope.rubrique = listeDevoir.lstRubrique[3];
        $scope.criteres = listeDevoir.lstRubrique[3].lstCritere;
    })

    .controller('Rubrique5Ctrl', function($scope) {
        $scope.rubrique = listeDevoir.lstRubrique[4];
        $scope.criteres = listeDevoir.lstRubrique[4].lstCritere;
    })

    .controller('DashCtrl', function ($scope) {

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
