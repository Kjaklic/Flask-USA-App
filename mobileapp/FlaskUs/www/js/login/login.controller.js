﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope', 'LoginService', '$state', '$ionicPopup', '$timeout', '$rootScope', '$cookies', '$ionicLoading', '$ionicPlatform', '$cordovaTouchID','SERVER','$localStorage'];
    
    /* @ngInject */
    function LoginCtrl($scope, LoginService, $state, $ionicPopup, $timeout, $rootScope, $cookies, $ionicLoading, $ionicPlatform, $cordovaTouchID,SERVER,$localStorage) {
        /* jshint validthis: true */
        var self = this;
        $scope.Email = '';
        $scope.password = '';
        $scope.user={Email:"",password:""}
        $scope.remembered=false;
     
        $scope.checkTouch = function (enableChecked) {
            if (enableChecked) {
                $cordovaTouchID.checkSupport().then(function () {
                    $cordovaTouchID.authenticate("You must authenticate").then(function () {
                        alert("The authentication was successful");
                    }, function (error) {
                        console.log(JSON.stringify(error));
                    });
                }, function (error) {
                console.log(JSON.stringify(error));
             });
           }
        }
       
        $scope.doLogin = function (user) {
            LoginService.authenticateUser(user).then(function (respData) {
                if (respData.data.message == "Authenticated access required") {
                    $scope.Error = true;
                    $timeout(function () { $scope.Error = false; }, 3000);
                }
                else if (respData.data.emailAddress == "") {
                }
                else {
                    if($scope.remembered==true){
                        $localStorage['RememberUser']=user;
                    }
                    $cookies.putObject('CurrentUser', respData);
                    var usercookie = $cookies.getObject('CurrentUser');
                    $rootScope.userName = respData.data.firstName + respData.data.lastName;
                    $rootScope.userEmailId = respData.data.emailAddress;
                    $rootScope.show_login = true;
                    document.login_form.reset();
                    $state.go("app.user_navigation_menu");
                }
            });
        }
        if($localStorage['RememberUser'] &&  $localStorage['RememberUser'].Email &&  $localStorage['RememberUser'].password){
            $scope.user=$localStorage['RememberUser'];
            $scope.isChecked=true;
        }else{
            $scope.isChecked=false;
        }

        $scope.remembered = function (isChecked, user) { 
            if (isChecked) {
                if(user && !user.Email=="" && !user.password==""){

                    $scope.remembered=true;
                }
                else {
                    $scope.remembered=false;
                    $ionicLoading.show({ template: 'Email and password should not be empty!', noBackdrop: false, duration: 2000 });
                }
            }else{
                $localStorage['RememberUser']="";
            }
        }
    
    };
})();

