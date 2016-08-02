﻿(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('UserService', UserService);

    UserService.$inject = ['$http','$state'];

    function UserService($http, $state) {
        var baseURL = "http://146.148.83.30/api/jsonws";
        var addUserURL = "/flask-rest-users-portlet.flaskadmin/sign-up";
        
        this.saveUser = saveUser

        function saveUser(user, gender) {
            
            console.log(user);
            var params= {
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.Email,
                screenName: user.screenName,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: gender,
                areaCode: user.areaCode,
                mobileNumber: user.mobileNumber
            };
            return $http.get(baseURL + addUserURL, {
                params
            }
            )
            .then(function success(response) {
                $state.go('app.login');
                
                    return response;
                },  function failure(response) {
                    //add errror handling 
                });
        }
    }
})();

