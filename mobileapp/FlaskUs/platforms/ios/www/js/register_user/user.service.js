﻿(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('UserService', UserService);

    UserService.$inject = ['$http', '$state', 'SERVER'];

    function UserService($http, $state, SERVER) {
        var addUserURL = "/flask-rest-users-portlet.flaskadmin/sign-up";
        var getUserByEmailId = "/flask-rest-users-portlet.flaskadmin/get-user-for-email";
        var updateUserURL = "flask-rest-users-portlet.flaskadmin/update-flask-user";
        var getUserByIdURL = "flask-rest-users-portlet.flaskadmin/get-user-by-id";
        var getCountriesURL = "flask-rest-users-portlet.flaskadmin/get-countries";
        var getRegionURL = "flask-rest-users-portlet.flaskadmin/get-region";
        var uploadUserProfileURL = "flask-rest-users-portlet.flaskadmin/upload-user-profile";

        var userServices = {
            saveUser: saveUser,
            getUserbyEmail: getUserbyEmail,
            getUserById: getUserById,
            updateUser: updateUser,
            getCountries: getCountries,
            getRegion: getRegion,
            uploadProfile: uploadProfile
        }

        function saveUser(user, gender, srcname) {

            console.log(user);
            var params = {
                firstName: user.firstName,
                lastName: user.lastName,
                email: user.Email,
                screenName: srcname,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: gender,
                areaCode: user.areaCode,
                mobileNumber: user.mobileNumber
            };
            return $http.get(SERVER.url + addUserURL, {
                params
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
                console.log("failed");
            });
        }

        function getUserbyEmail(email) {
            return $http.get(SERVER.url + getUserByEmailId, { params: { 'emailAddress': email.Email } })
                .then(function success(response) {
                    return response;
                }, function failure(response) {
                    console.log("failed");
                });
        }

        function getUserById(userId) {
            return $http.get(SERVER.url + getUserByIdURL, {
                params: {
                    'userId': userId
                }
            })
               .then(function success(response) {
                   return response.data;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        function updateUser(user, userId, gender, sId, cId, interestArray) {
            var params = {
                userId: userId,
                firstName: user.firstName,
                middleName: user.middleName,
                lastName: user.lastName,
                email: user.Email,
                screenName: user.screenName,
                password1: user.password1,
                password2: user.password2,
                DOB: user.DOB,
                isMale: gender,
                streetName: user.streetName,
                aptNo: user.aptNo,
                areaCode: user.areaCode,
                city: user.city,
                stateId: sId,
                countryId: cId,
                mobileNumber: user.mobileNumber,
                userInterests: interestArray
            };

            return $http.get(SERVER.url + updateUserURL, {
                params
            }
            )
            .then(function success(response) {
                return response;
            }, function failure(response) {
                //add errror handling 
                console.log("failed");
            });
        }

        function getCountries() {
            return $http.get(SERVER.url + getCountriesURL)
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        function getRegion(countryId) {
            return $http.get(SERVER.url + getRegionURL, {
                params: {
                    'countryId': countryId
                }
            })
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        function uploadProfile() {
            return $http.get(SERVER.url + uploadUserProfileURL)
               .then(function success(response) {
                   return response;
               }, function failure(response) {
                   console.log("failed");
               });
        }

        return userServices;
    }
})();


