﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatelocationCtrl', mytailgatelocationCtrl);

    mytailgatelocationCtrl.$inject = ['$scope', '$state', '$stateParams', 'TailgateService', '$cookies', 'uiGmapGoogleMapApi', 'SERVER', '$cordovaInAppBrowser'];

    /* @ngInject */
    function mytailgatelocationCtrl($scope, $state, $stateParams, TailgateService, $cookies, uiGmapGoogleMapApi, SERVER, $cordovaInAppBrowser) {
        $scope.myTailgaters = [];
        var tailGateId = $cookies.get('currtailGateId');
        $scope.taligateMarkers = $cookies.getObject('currtailGateMakers');
        console.log($scope.taligateMarkers);
        $scope.isTailgateAdmin = false;
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }
        $scope.latitude = 43.4651;
        $scope.longitude = -80.5223;
        $scope.$root.takemeThere = function (value) {
            getReverseGeocodingData(value.coords.latitude, value.coords.longitude);
        }

        function getReverseGeocodingData(lat, lng) {
            var latlng = new google.maps.LatLng(lat, lng);
            var address = '';
            // to create Geocode request
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ 'latLng': latlng }, function (results, status) {
                if (status !== google.maps.GeocoderStatus.OK) {
                    console.log(status);
                }
                // to check Geoeode Status is OK or not
                if (status == google.maps.GeocoderStatus.OK) {
                    address = (results[0].formatted_address);
                    var currurl = "http://maps.google.com/?saddr=Current%20Location&daddr=" + address;
                    console.log(address);
                    openUrl(currurl, "_system");
                }
            });            
        }
        //open venue URL
        function openUrl(url, target) {
            $cordovaInAppBrowser.open(url, target, { location: 'no' }).
                then(function (event) {
                    // success
                })
                .catch(function (event) {
                    // error
                });
        }

        if ($scope.taligateMarkers==undefined || $scope.taligateMarkers.latitude == undefined) {
            $scope.map ={
                    center: {
                        latitude: $scope.latitude,
                        longitude: $scope.longitude
                    },
                    scrollwheel: false,
                    zoom: 19
                } // when no markers are present
        }else{
            callMap($scope.taligateMarkers.latitude, $scope.taligateMarkers.longitude); //taking markers from cookies
            //adding window options for marker pin
            $scope.windowOpt = {
                boxClass: "infobox",
                boxStyle: {
                    backgroundColor: "#040404",
                    borderRadius: "5px",
                    width: "240px",
                    top:"134px"
                },
                position: {
                    lat: $scope.taligateMarkers.latitude,
                    lng: $scope.taligateMarkers.longitude
                },
                show: true,
                pane: "floatPane",
                pixelOffset: {
                    width: -113,
                    height: -155
                },
                enableEventPropagation: false,
            }
        }

        $scope.goToLocationTab = function () {
            //add cookie data for editing particular page on tab.
            $cookies.putObject("tabtoEdit", [1, 'locationTab']);
            checkTailgateId();
        }

        function checkTailgateId() {
            if (!tailGateId) {
            }
            else {
                //getting the data for editing the tailgate       
                editTailgate(tailGateId);
            }
        }

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);

        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $cookies.putObject("editUserTailgate", respData.data);
                $state.go("app.add_my_tailgate");
            });
        }
                
        //calling map on load and on events change
        function callMap(currlatitude,currlongitude){
            angular.extend($scope, {
                map: {
                    center: {
                        latitude: currlatitude,
                        longitude: currlongitude
                    },
                    zoom: 19,
                    marker: [{  
                        coords: { 'latitude': currlatitude, 'longitude': currlongitude},
                        id: 0,
                        options: { icon: 'img/map_icons/tailgateMarker.svg' },
                    }]
                }
            });
        }
     }
})();

