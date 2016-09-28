﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('account_settingsCtrl', account_settingsCtrl);
    account_settingsCtrl.$inject = ['$scope', 'UserService', '$ionicPopup', '$timeout', 'ionicDatePicker', '$filter', '$cookies', '$ionicLoading'];

    /* @ngInject */
    function account_settingsCtrl($scope, UserService, $ionicPopup, $timeout, ionicDatePicker, $filter, $cookies, $ionicLoading) {
        var gender = true;
        $scope.country = [];
        $scope.state = [];
        var countryArray;
        var stateArray;
        $scope.cId = [];
        $scope.sId = [];
        $scope.sport = [];
        $scope.level = [];
        $scope.concert = [];
        $scope.interest = [];
        var interestArray;

        console.log("Account");
        getUser();
        getCountry();
        


        $scope.data1 = [
          {
              sport: "Basketball"
          },
          {
              sport: "Basebball"

          },
          {
              sport: "Football"
          },
          {
              sport: "Hockey"
          },
          {
              sport: "Soccer"
          },
          {
              sport: "Tennis"
          }
        ];

        $scope.data2 = [
            {
                concerts: "Country"
            },
            {
                concerts: "Pop"
            },
            {
                concerts: "Rock"
            },
            {
                concerts: "Rap"
            },
            {
                concerts: "Alternative"
            },
            {
                concerts: "Electronic"
            }
        ];

        $scope.data3 = [

            {
                special_events: "Comedy"
            }
        ];

        $scope.data4 = [

           {
               level: "Professional"
           },
           {
               level: "college"
           }
        ];

        function getCountry() {
            UserService.getCountries().then(function (respData) {
                $scope.country = respData.data;
            });
        }

        $scope.getState = function (data, country_Name) {
            $scope.cId = country_Name.countryId;
            UserService.getRegion($scope.cId).then(function (respData) {
                $scope.state = respData.data;
            });
        }

        $scope.getStateId = function (data, state_Name) {
            $scope.sId = state_Name.regionId;
        }

        function getUser(userId) {
            console.log("Account Settings");
            var usercookie = $cookies.getObject('CurrentUser');
            $scope.userid = usercookie.data.userId;
            UserService.getUserById($scope.userid).then(function (respData) {
                $scope.userInfo = respData;
                $scope.user = {
                    firstName: $scope.userInfo.firstName,
                    middleName: $scope.userInfo.middleName,
                    lastName: $scope.userInfo.lastName,
                    screenName: $scope.userInfo.screenName,
                    Email: $scope.userInfo.email,
                    password1: "",
                    password2: "",
                    DOB: $filter('date')($scope.userInfo.DOB, 'MM-dd-yyyy'),
                    isMale: gender,
                    areaCode: $scope.userInfo.areaCode,
                    mobileNumber: $scope.userInfo.mobileNumber,
                    streetName: $scope.userInfo.streetName,
                    aptNo: $scope.userInfo.aptNo,
                    city: $scope.userInfo.city
                }
            });
        }

        $scope.addEventsInArray=function(select_events,$index,data){
            console.log(data.special_events);
            $scope.interest.push(data.special_events);
            getInterests();
        }

        $scope.addConcertsInArray = function (select_concerts, $index, data) {
            console.log(data.concerts);
            $scope.interest.push(data.concerts);
            console.log($scope.interest);
            getInterests();
        }

        $scope.addlevelInArray = function (select_level, $index, data) {
            $scope.interest.push(data.level);
            console.log($scope.interest);
            getInterests();
        }

        $scope.addSportInArray = function (select_sport, $index, data) {
            $scope.interest.push(data.sport);
            console.log($scope.interest);
            getInterests();
        }

        function getInterests() {
            console.log($scope.interest);
            interestArray = $scope.interest.toString();
            console.log(interestArray);
        }

        $scope.updateUserInfo = function (user, userId) {
            if (user.isMale == 'male') {
                gender = true;
            }
            else { gender = false; }
            UserService.updateUser(user, $scope.userid,gender, $scope.cId, $scope.sId,interestArray).then(function (respData) {
                $scope.userInfo = respData.data;
                $ionicLoading.show({ template: 'User Updated Successfully!', noBackdrop: false, duration: 2000 });
            });
        }

        $scope.openDatePickerOne = function (val) {
            var ipObj1 = {
                callback: function (val) {  //Mandatory
                    var currDate = $filter('date')(val, 'MM-dd-yyyy');
                    $scope.user = { DOB: currDate };
                    //var date1 = new Date(val);
                    // $scope.user.DOB = $filter('date1')(date1, 'yyyy-MM-dd');
                },
                disabledDates: [
                  new Date("08-16-2016")

                ],
                from: new Date(1960, 1, 1),
                to: new Date(),
                inputDate: new Date(),
                mondayFirst: true,
                disableWeekdays: [],
                closeOnSelect: false,
                templateType: 'popup'
            };
            ionicDatePicker.openDatePicker(ipObj1);
        };

    }
})();






