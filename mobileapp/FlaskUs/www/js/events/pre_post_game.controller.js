(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('prePostGameCtrl', prePostGameCtrl);

    prePostGameCtrl.$inject = ['$scope', '$stateParams', '$state', 'EventsService', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$cookies', '$timeout', '$localStorage', 'SERVER', '$ionicHistory', '$ionicLoading'];

    /* @ngInject */
    function prePostGameCtrl($scope, $stateParams, $state, EventsService, $ionicSlideBoxDelegate, $ionicScrollDelegate, $cookies, $timeout, $localStorage, SERVER, $ionicHistory, $ionicLoading) {
        /* jshint validthis: true */
        console.log('inside prePostGameCtrl');
        var self = this;
        $scope.$on('$ionicView.beforeEnter', function () {
        $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
        $scope.venueDataRecieved=false;
        $scope.eventDetails = {};
        $scope.event = {};
        $scope.Details = [];
        $scope.INFO_TYPE = [];
        $scope.INFO_TYPE_CATEGORY = [];
        $scope.Pre_Game = [];
        $scope.Pre_Game.push("Parking")
        $scope.Post_Game = [];
        $scope.Post_Game.push("Getting home");
        $scope.During_Game = [];
        $scope.During_Game.push("Venue Info")
        $scope.currEventName = $stateParams.eventName;
        $scope.currEventId = $stateParams.eventId;
        var currEventId = $scope.currEventId;
        $scope.showAddv = false;
        $scope.goBack = function () {
            //$timeout(function () {
                $ionicHistory.goBack();
            //}, 1000);
        }
        var PRE_EVENT = "Pre-Event";
        var AT_EVENT = "During-Event";
        var POST_EVENT = "Post-Event";
        var userDetail = $cookies.getObject('CurrentUser');
        var agreedToTermsOfUse = false;
        if (userDetail != undefined) {
            agreedToTermsOfUse = userDetail.data.isContentAdmin;
        }
        if (angular.isUndefined($localStorage["CachedEvents"])) {
            $localStorage["CachedEvents"] = {};
        }
        if ( $localStorage["CachedEvents"][currEventId] == undefined ) {
            $localStorage["CachedEvents"][currEventId] = {};
            getEventVenueDatail();
            getCurrentEvent();
        } else if(checkExpiryTime($localStorage["CachedEvents"][currEventId].addeddTime)) {
            getEventVenueDatail();
            getCurrentEvent();
        } else {
            setEventVenueDatail($localStorage["CachedEvents"][currEventId].getEventVenueDatail);
            setCurrentEvent($localStorage["CachedEvents"][currEventId].getCurrentEvent);
        }
        function getCurrentEvent() {
            console.log('Inside getCurrentEvent fn');
            EventsService.getEventByEventId($scope.currEventId).then(function (respData) {
                console.log('Inside EventsService.getEventByEventId fn');
                $localStorage["CachedEvents"][currEventId].getCurrentEvent = respData;
                $localStorage["CachedEvents"][currEventId].addeddTime = new Date().getTime();
                setCurrentEvent(respData);
            })
        }
        function checkExpiryTime (dataAddedTime) {
            if (angular.isUndefined(dataAddedTime)) {
                return true;
            }
            var currTime = new Date().getTime();
            if(currTime-dataAddedTime > SERVER.cacheExpireTime) {
                return true;
            } else {
                return false;
            }
        }
        function setCurrentEvent(respData) {
            console.log('Inside setCurrentEvent');
            $scope.currVenueName = respData.data.venueName;
            $scope.currEventDate = respData.data.eventDate;
            $scope.currVenueId = respData.data.venueId;
        }
       
        $scope.preEvent = function (pre) {
            console.log('Inside preEvent'+$scope.currEventName+'-'+$scope.currEventId);

            if (pre == "Tickets") {
                $state.go("app.tickets", { eventDetails: $localStorage["eventDetails"] });
            }

            else if (pre == "Game Day Needs" || pre == "Supplies") {
                $state.go("app.supplies", { myListName: "My Supply", currEventId: $scope.currEventId });
            }
            else if (pre == "Add Content") {
                $state.go("app.manage_event_content", { eventDetails: $localStorage["eventDetails"], infoType: PRE_EVENT, infoTypeCategory: pre, currEventName: $scope.currEventName, currEventId: $scope.currEventId });
            }
            else {
                $state.go("app.event_map_view", { eventDetails: $localStorage["eventDetails"], infoType: PRE_EVENT, infoTypeCategory: pre });
            }
        }
        $scope.atEvent = function (during) {
            console.log('Inside atEvent'+$scope.currEventName+'-'+$scope.currEventId);
            if (during == "Add Content") {
                $state.go("app.manage_event_content", { eventDetails: $localStorage["eventDetails"], infoType: AT_EVENT, infoTypeCategory: during, currEventName: $scope.currEventName, currEventId: $scope.currEventId });
            }
            else {
                $state.go("app.event_map_view", { eventDetails: $localStorage["eventDetails"], infoType: AT_EVENT, infoTypeCategory: during });

            }
        }
        $scope.postEvent = function (post) {
            console.log('Inside postEvent'+$scope.currEventName+'-'+$scope.currEventId);
            if (post == "Add Content") {
                $state.go("app.manage_event_content", { eventDetails: $localStorage["eventDetails"], infoType: POST_EVENT, infoTypeCategory: post, currEventName: $scope.currEventName, currEventId: $scope.currEventId });
            }
            else {
                $state.go("app.event_map_view", { eventDetails: $localStorage["eventDetails"], infoType: POST_EVENT, infoTypeCategory: post });
            }
        }
        function getEventVenueDatail() {
            //$ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' });
            //console.log($stateParams.eventId);
            if ($stateParams.eventId == "none") {
                EventsService.getVenueDetailWithImage(parseInt($stateParams.venueId)).then(function (respData) {
                    //$timeout(function () {
                        setEventVenueDatail(respData);
                        $scope.venueDataRecieved = true;
                        //$ionicLoading.hide();
                    //}, 600);
                });
            } else {
                EventsService.getEventVenueDatail(currEventId).then(function (respData) {
                    //$timeout(function () {
                        $localStorage["CachedEvents"][currEventId].getEventVenueDatail = respData;
                        $scope.venueDataRecieved = true;
                        setEventVenueDatail(respData);
                        //$ionicLoading.hide();
                    //}, 600);
                });
            }
            $timeout(function () {
                $ionicLoading.hide();
            }, 4000);
        }

        function setEventVenueDatail(respData) {
                $scope.eventDetails = respData.data;
                $localStorage["eventDetails"]=respData.data;
                var len = respData.data.Details.length - 1;
                for (var i = 0; i <= len; i++) {
                    $scope.Details.push(angular.fromJson(respData.data.Details[i].Detail))
                    if ($scope.INFO_TYPE.indexOf($scope.Details[i].infoTypeName) == -1) {
                        $scope.INFO_TYPE.push($scope.Details[i].infoTypeName)
                    }
                }
                for (var i = 0; i <= len; i++) {
                    if ($scope.Details[i].infoTypeName == PRE_EVENT) {
                        if ($scope.Pre_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                            $scope.Pre_Game.push($scope.Details[i].infoTypeCategoryName)
                        }
                    } else
                        if ($scope.Details[i].infoTypeName == AT_EVENT) {
                            if ($scope.During_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.During_Game.push($scope.Details[i].infoTypeCategoryName)
                            }
                        } else {
                            if ($scope.Post_Game.indexOf($scope.Details[i].infoTypeCategoryName) == -1) {
                                $scope.Post_Game.push($scope.Details[i].infoTypeCategoryName)
                            }
                        }
                }
                $timeout(function () {
                    $ionicSlideBoxDelegate.$getByHandle('slide1').update();
                    $ionicSlideBoxDelegate.$getByHandle('slide2').update();
                    $ionicSlideBoxDelegate.$getByHandle('slide3').update();
                    $scope.showAddv = true;
                }, 100);
                $ionicScrollDelegate.resize();

                if ($scope.Post_Game.length >= 0) {
                    if (userDetail != undefined && agreedToTermsOfUse == true) {
                        $scope.Post_Game.push("Add Content");
                    }
                }
                if ($scope.During_Game.length >= 0) {
                    if (userDetail != undefined && agreedToTermsOfUse == true) {
                        $scope.During_Game.push("Add Content");
                    }
                }
                if ($scope.Pre_Game.length >= 0) {
                    $scope.Pre_Game.push("Game Day Needs");
                    if (userDetail != undefined && agreedToTermsOfUse == true) {
                        $scope.Pre_Game.push("Add Content");
                    }
                }
        }
        $scope.slidePrevious1 = function (slide) {
            $ionicSlideBoxDelegate.$getByHandle(slide).previous();
        }

        $scope.slideNext1 = function (slide) {
            $ionicSlideBoxDelegate.$getByHandle(slide).next();
        }

        $scope.getBackgroundImage = function (imgName, infotype) {
            var defaultExt = ".jpg";
            var fileName;
            switch (imgName.toLowerCase()) {
                case "tradition":
                    fileName = 'Flask_Tradition';
                    break;
                case "parking":
                    fileName = 'PRE_PARKING';
                    break;
                case "bar & restaurants":
                    fileName = 'PRE_BAR_RESTAURANTS';
                    break;
                case "traffic":
                    fileName = 'PRE_TRAFFIC';
                    break;
                case "supplies":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "getting home":
                    fileName = 'flask_GettingHome';
                    break;
                case "nightlife":
                    fileName = 'POST_NIGHTLIFE';
                    break;
                case "liquor store":
                    fileName = 'flask_restaurantBar_post';
                    break;
                case "venue info":
                    fileName = 'venue_info';
                    break;
                case "venue map":
                    fileName = 'VENUE_MAP';
                    break;
                case "flask us":
                    fileName = 'Flask_FlaskUs' + "_" + infotype;
                    break;
                case "tickets":
                    fileName = 'tickets';
                    break;
                case "game day needs":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "add content":
                    fileName = 'Add_Event_Content'
                    break;
                case "hotels":
                    fileName = 'POST_HOTEL'
                    break;
                case "getting home":
                    fileName = 'POST_GETTINGHOME'
                    break;
                default:
                    fileName = 'Flask_Default_Image';
            }
            fileName = fileName + defaultExt;
            return fileName;
        }

        $scope.getImageLabel = function (imgName, infotype) {

            var defaultExt = ".svg";
            var fileName
            switch (imgName.toLowerCase()) {
                case "tradition":
                    fileName = 'Flask_Tradition';
                    break;
                case "parking":
                    fileName = 'PRE_PARKING';
                    break;
                case "bar & restaurants":
                    fileName = 'PRE_BAR_RESTAURANTS';
                    break;
                case "traffic":
                    fileName = 'PRE_TRAFFIC';
                    break;
                case "supplies":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "getting home":
                    fileName = 'flask_GettingHome';
                    break;
                case "nightlife":
                    fileName = 'POST_NIGHTLIFE';
                    break;
                case "liquor store":
                    fileName = 'flask_restaurantBar_post';
                    break;
                case "venue info":
                    fileName = 'venue_info';
                    break;
                case "venue map":
                    fileName = 'VENUE_MAP';
                    break;
                case "flask us":
                    fileName = 'Flask_FlaskUs' + "_" + infotype;
                    break;
                case "tickets":
                    fileName = 'tickets';
                    break;
                case "game day needs":
                    fileName = 'PRE_SUPPLIES';
                    break;
                case "add content":
                    fileName = 'Add_Event_Content'
                    break;
                case "hotels":
                    fileName = 'POST_HOTEL'
                    break;
                case "getting home":
                    fileName = 'POST_GETTINGHOME'
                    break;
                default:
                    fileName = 'Flask_Default_Image';
            }
            fileName = fileName + defaultExt;
            return fileName;
        }
        });
    }
})(); 
