angular.module('flaskApp.controllers', [])

.controller('AppCtrl', function ($scope, $ionicModal, $state, $timeout, $cookies, LoginService, $rootScope, SERVER, $ionicLoading,$localStorage) {
    //controller for splash screen
 /*   $scope.$on('$ionicView.afterEnter', function () {
    })
    */

    $scope.doLogout = function () {
        $rootScope.show_login = false;       
        $cookies.remove('CurrentUser');
        $rootScope.userName ='';
        $rootScope.userEmailId ='';
        $rootScope.userProfileUrl='';
        console.log($cookies.getObject('CurrentUser'));
        $state.go("app.events");
        
    }
    $scope.imgUrl = SERVER.hostName;
})



.controller('my_tailgateCtrl', function ($scope) {
})

.controller('account_settingsCtrl', function ($scope) {
})

.controller('my_friendsCtrl', function ($scope) {
})

.controller('friend_detailsCtrl', function ($scope) {
})

.controller('ticketsCtrl', function ($scope, $state) {
    $scope.scorebig = function () {
        var ref = window.open('http://scorebig.org', '_system', 'location=yes');
    }

    $scope.ticketsnow = function () {
        var ref = window.open('http://ticketsnow.org', '_system', 'location=yes');
    }
});









