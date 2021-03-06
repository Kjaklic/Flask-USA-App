﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('add_mytailgateCtrl', add_mytailgateCtrl);

    add_mytailgateCtrl.$inject = ['$scope', '$state', 'SERVER', '$stateParams', 'TailgateService', '$cordovaDatePicker', '$timeout', '$ionicSlideBoxDelegate', '$ionicScrollDelegate', '$filter', '$ionicModal', '$flaskUtil', '$cookies', 'ionicDatePicker', 'ionicTimePicker', '$ionicPopup', '$cordovaCamera', '$cordovaFileTransfer', 'IonicClosePopupService', '$rootScope', '$ionicTabsDelegate', '$ionicLoading', '$localStorage', 'UserService','$cordovaGeolocation'];

    / @ngInject /
    function add_mytailgateCtrl($scope, $state, SERVER, $stateParams, TailgateService, $cordovaDatePicker, $timeout, $ionicSlideBoxDelegate, $ionicScrollDelegate, $filter, $ionicModal, $flaskUtil, $cookies, ionicDatePicker, ionicTimePicker, $ionicPopup, $cordovaCamera, $cordovaFileTransfer, IonicClosePopupService, $rootScope, $ionicTabsDelegate, $ionicLoading, $localStorage, UserService,$cordovaGeolocation) {
        //for adding tailgate
        var tailgateId = $cookies.get("currtailGateId");
        $scope.copytTailgateId = tailgateId;
        var self = this;
        var newtailGateId;
        getAllFriends();
        getAllGroups();
        $scope.allGroups = [];
        $scope.CurrEvent = [];
        $scope.Details = [];
        $scope.eventDetails = [];
        $scope.eventNames = [];
        $scope.groupUserDetails = [];
        $scope.friendsToInvite = [];
        $scope.disableDorpDown = false;
        var currentDate = new Date();/*Today's Date*/
        $scope.startDate = $filter('date')(new Date(), 'yyyy-MM-dd');
        currentDate.setDate(currentDate.getDate() - 1); /*adding days to today's date*/
        $scope.startDate = $filter('date')(currentDate, 'yyyy-MM-dd');
        $scope.eventTypeIds = '';
        $scope.searchString = 'a';
        $scope.showSavedMarker = false;
        $scope.taligateMarkers = "";
        $scope.latitude = '42.34';
        $scope.longitude = '-83.0456';
        $scope.sList = [];
        var userDetail = $cookies.getObject('CurrentUser');
        $scope.loggedInUserId = userDetail.data.userId;
        $scope.addNewSuppliesItem = false;
        $scope.addNewTailgateSuppliesItem = false;
        $scope.taigateSupplyList = [];
        $scope.isUserMarkerShown = false;
        currentDate.setDate(currentDate.getDate() + 60); /*adding days to today's date*/
        $scope.endDate = $filter('date')(currentDate, 'yyyy-MM-dd');
        $scope.tailgateSupplyList = [];
        $scope.supplyList = { 'selectedSupplyList': '' };
        var supplyListstId;
        var supplyItemName;
        $scope.items = [];
        var userResponse;
        var UserId;
        var itemArray;
        $scope.marker = {};
        $scope.supplyItemList = [];
        $scope.downloadProgress = 0;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
        $scope.tailgateLogoUrl = "";
        $scope.tailgateLogoInfo = {};
        $scope.isTailgateAdmin = false;
        $scope.selectedImageURIToUpload = "";
        $scope.isImageSelectedToUpload = false;
        $scope.tailgateLogoId = 0;
        $scope.defaultImageUrl = "img/flask_images/Fotolia_20387372_Subscription_Monthly_M.jpg";
        $scope.hideItem = false;
        $scope.hideSupplyItem = false;
        $scope.selectedSupplyListItems = [];
        $scope.allMyTailgateItems = [];
        $scope.newUpdate = { 'amountToPay': '', 'venmoAccountId': '' };
        $scope.haveTailgatorsDEtail = false;

        $scope.isMobile = {
            Android: function () {
                return ionic.Platform.isAndroid();
            },
            iOS: function () {
                return ionic.Platform.isIOS();
            },
            Windows: function () {
                return ionic.Platform.isWindowsPhone();
            }
        };

        getTailgateMarkers(tailgateId);
        getMySupplyList();
        getTailgate(tailgateId);
        getGeoLocation();
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
            $cookies.remove('tabtoEdit');
        }
        function getTailgate(tailGateId) {
            if (tailGateId != undefined && tailGateId > 0) {
                TailgateService.getTailgate(tailGateId).then(function (respData) {
                    $scope.tUserId = respData.data.userId;
                });
            }
        }
        function getTailgateMarkers(tailGateId) {
            if (tailGateId != undefined && tailGateId > 0) {
                TailgateService.getMapMarkers(tailGateId).then(function (respData) {
                    $scope.taligateMarkers = respData.data;
                    if ($scope.taligateMarkers != undefined && $scope.taligateMarkers.tailgatemarkerid != undefined) {
                        $scope.latitude = $scope.taligateMarkers.latitude;
                        $scope.longitude = $scope.taligateMarkers.longitude
                        $scope.showSavedMarker = true;
                    } else {
                        $scope.latitude = '42.34';
                        $scope.longitude = '-83.0456';
                    }
                    getallEventnames();
                    callMap($scope.latitude, $scope.longitude);
                });
            } else {
                getallEventnames();
                callMap($scope.latitude, $scope.longitude);
            }

        }

        $scope.initialize = function () {
            var x = new Date();
            var hour = x.getHours();
            var minute = x.getMinutes();
            var year = x.getYear() + 1900;
            var month = x.getMonth();
            var day = x.getDate();

            $scope.addTailgateParams = {
                tailgateName: '',
                tailgateDescription: '',
                eventId: '',
                eventName: '',
                venmoAccountId: '',
                amountToPay: '',
                tailgateId: '',
                startTime: new Date(year, month, day, hour, minute, 0),
                endTime: new Date(year, month, day, hour, minute, 0)
            }
            checkTailgateId();
            if (tailgateId != undefined && tailgateId > 0) {
                $scope.isUserTailgateAdmin(tailgateId);
                getTailgaters(tailgateId);
                if ($scope.tailgateLogoId > 0) {
                    $scope.getTailGateLogo(tailgateId);
                }
            } else {
                $scope.isTailgateAdmin = true;
            }

        }
        $scope.selectTab = function (index) {
            $timeout(function () {
                $ionicTabsDelegate.select(index);
                $cookies.remove('tabtoEdit');
            }, 300);
            //$ionicTabsDelegate.select(index);
            if (tailgateId != undefined && tailgateId > 0) {
                getItems();
            }
        }
        $scope.user = {
            supplyItemName: ['user']
        };



        //calling map on load and on events change
        function callMap(currlatitude, currlongitude) {
            angular.extend($scope, {
                map: {
                    center: {
                        latitude: currlatitude,
                        longitude: currlongitude
                    },
                    zoom: 16,
                    icon: 'img/map_icons/large_marker.svg',
                    options: { icon: 'img/map_icons/large_marker.svg' },
                    markers: [{
                        options: { icon: 'img/map_icons/large_marker.svg' }
                    }],
                    events: {
                        click: function (map, eventName, originalEventArgs) {
                            var e = originalEventArgs[0];
                            var lat = e.latLng.lat(), lon = e.latLng.lng();
                            var marker = {
                                id: 1,
                                coords: {
                                    latitude: lat,
                                    longitude: lon
                                },
                                icon: 'img/map_icons/large_marker.svg',
                                options: { icon: 'img/map_icons/large_marker.svg' },
                                showWindow: true
                            };
                            $scope.map.markers.push(marker);
                            if ($scope.map.markers.length > 1) {
                                $scope.map.markers.shift();
                            }
                            //$scope.map.markers.pop();
                            //console.log($scope.map.markers);
                            $scope.$apply();
                            $scope.onClick(marker);
                        }
                    }
                }
            });
            if ($scope.showSavedMarker) {
                var marker = {
                    id: 2,
                    coords: {
                        latitude: currlatitude,
                        longitude: currlongitude
                    },
                    icon: 'img/map_icons/large_marker.svg',
                    options: { icon: 'img/map_icons/large_marker.svg' },
                    showWindow: true,
                    name: $scope.taligateMarkers.name,
                    description: $scope.taligateMarkers.description
                }

                $scope.map.markers.push(marker);
            }

        }
        $scope.windowOptions = {
            show: true
        };
        $scope.currMarker = function (loc) {
            var markerData = {};
            //console.log(loc, $scope.map.markers[0].coords);
            markerData.tailgateId = tailgateId;
            markerData.latitude = $scope.map.markers[0].coords.latitude;
            markerData.longitude = $scope.map.markers[0].coords.longitude;
            markerData.name = loc.name;
            markerData.description = loc.description == undefined ? '' : loc.description;
            saveMaker(markerData);
        }
        function saveMaker(markerData) {
            $scope.locationPopup.close();
            if ($scope.taligateMarkers != undefined && $scope.taligateMarkers.tailgatemarkerid > 0) {
                TailgateService.deleteTailgateMarker(tailgateId).then(function (response) {
                    saveTailgateMarker(markerData);
                })
            } else {
                saveTailgateMarker(markerData);
            }

        }
        function saveTailgateMarker(markerData) {
            TailgateService.addTailgateMarkers(markerData).then(function (respData) {
                $scope.taligateMarkers = respData.data;
                $scope.map.markers[0].name = markerData.name;
                $scope.map.markers[0].description = markerData.description;
            });
        }
        //call on marker click
        $scope.onClick = function (marker, eventName, model) {
            $scope.loc = { 'name': marker.name, 'description': marker.description };
            var customTemplate =
                '<form novalidate name="markerPOpup"><div class="list">'
                + '        <label class="item item-input item-floating-label">'
                + '         <span class="input-label">Place Name</span>'
                + '           <input type="text" placeholder="Place Name" ng-model="loc.name" required="true" name="locationName">'
                + '<div ng-show="(markerPOpup.$submitted || markerPOpup.locationName.$touched) && markerPOpup.locationName.$error.required"  style="color:red">Enter location.</div>'
                + '        </label>'
                + '         <label class="item item-input item-floating-label">'
                + '      <span class="input-label">Description</span>'
                + '        <textarea rows="4" cols="50" placeholder="Description" ng-model="loc.description" style="background-color:transparent;"/>'
                + '       </label>                 '
                + '    </div>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="markerPOpup.$valid && currMarker(loc);">'
                + 'Save'
                + '</button>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="clearMArkersOnMap();" >'
                + 'Remove'
                + '</button>'
                + ' </div>'
                + '</form>';

            $scope.locationPopup = $ionicPopup.show({
                template: customTemplate,
                title: 'Enter Location Details',
                scope: $scope
            });
            IonicClosePopupService.register($scope.locationPopup);


        };
        $scope.clearMArkersOnMap = function (addMarker) {
            TailgateService.deleteTailgateMarker(tailgateId).then(function (res) {
                $scope.map.markers.pop();
                $scope.locationPopup.close();
            });
        }


        // invoke on type search box
        $scope.loadeventData = function (eventId) {
            if (eventId > 0) {
                $scope.addTailgateParams.eventName = $("#EventNameList option:selected").text();
                getEventDetails(eventId);
            } else {
                $scope.addTailgateParams.startTime = '';
                $scope.addTailgateParams.endTime = '';
                $scope.tailgateDate = '';
            }
        }
        //get event and venue details in select box
        function getEventDetails(eventId) {
            TailgateService.getEvent(eventId).then(function (respData) {
                $scope.CurrEvent = respData.data;
                var venueID = $scope.CurrEvent.venueId;
                var currStartTime = getTailgateTime($scope.CurrEvent.startTime);
                var currEndTime = getTailgateTime($scope.CurrEvent.endTime);
                var currDate = $filter('date')($scope.CurrEvent.eventDate, 'MM-dd-yyyy');
                $scope.currEventDate = $filter('date')($scope.CurrEvent.eventDate, 'yyyy-MM-dd');
                $scope.addTailgateParams.startTime = currStartTime;
                $scope.addTailgateParams.endTime = currEndTime;
                $scope.tailgateDate = currDate;

                TailgateService.getvenueDetails(venueID).then(function (VENUEData) {
                    callMap(VENUEData.latitude, VENUEData.longitude);
                });
            });
        }

        function checkTailgateId() {
            var tailgateDetails = $cookies.getObject("editUserTailgate");
            if (!tailgateDetails) {

            } else {
                editTailgateData(tailgateDetails);
            }
        }
        function checkTailgateExpired(tailgateDetails) {
            var currentDate = new Date().getTime();
            var tailgateDate = tailgateDetails.tailgateDate;
            if (currentDate > tailgateDetails.tailgateDate) {
                return true;
            } else {
                return false;
            }

        }

        //edit tailgate data
        function editTailgateData(tailgateDetails) {
            if (checkTailgateExpired(tailgateDetails)) {
                $scope.expiredEventDetail = { "eventName": "", "eventId": "" }
                $scope.expiredEventDetail.eventName = tailgateDetails.eventName;
                $scope.expiredEventDetail.eventId = tailgateDetails.eventId;
                $scope.disableDorpDown = true;
            }

            $cookies.remove('newtailgatedata');
            $scope.newUpdate = { 'amountToPay': tailgateDetails.amountToPay, 'venmoAccountId': tailgateDetails.venmoAccountId };
            $scope.tailgateDate = $filter('date')(tailgateDetails.tailgateDate, 'MM-dd-yyyy');
            $scope.currEventDate = $filter('date')(tailgateDetails.tailgateDate, 'yyyy-MM-dd');
            var tailgateStartTime = new Date(tailgateDetails.startTime);
            var tailgateEndTime = new Date(tailgateDetails.endTime);
            $scope.tailgateLogoId = tailgateDetails.logoId;
            $scope.addTailgateParams = {
                tailgateName: tailgateDetails.tailgateName,
                tailgateDescription: tailgateDetails.tailgateDescription,
                eventId: tailgateDetails.eventId + "",
                eventName: tailgateDetails.eventName,
                venmoAccountId: tailgateDetails.venmoAccountId,
                amountToPay: tailgateDetails.amountToPay,
                tailgateId: tailgateDetails.tailgateId,
                startTime: tailgateStartTime,
                endTime: tailgateEndTime,
                logoId: tailgateDetails.logoId,
                tailgateDate: tailgateDetails.tailgateDate

            }
            $scope.editData = angular.copy($scope.addTailgateParams);
            $scope.editData.startTime = tailgateDetails.startTime;
            $scope.editData.tailgateDate = tailgateDetails.tailgateDate;
            $scope.editData.endTime = tailgateDetails.endTime

            $cookies.putObject('newtailgatedata', $scope.editData);
            var getTabIndex = $cookies.getObject('tabtoEdit');
            if (getTabIndex == undefined) {
                //do nothing
            } else {
                getTabWithIndex(getTabIndex);
            }

        };

        /*--get Tab index and go to particular tab with that index--*/
        function getTabWithIndex(getTabIndex) {
            if (getTabIndex[1] == 'planNowTab') {
                $scope.selectTab(getTabIndex[0]);
                $scope.collapsedItems = false;
            }
            else if (getTabIndex[1] == 'locationTab') {
                callMap($scope.latitude, $scope.longitude);
                changeTabWithIndex(getTabIndex[0]);
            }
            else {
                changeTabWithIndex(getTabIndex[0]);
            }
        }

        function changeTabWithIndex(index) {
            //let all the data in html page load properly then redirect to particular tab.
            $timeout(function () {
                $ionicTabsDelegate.select(index);
            }, 300);
        }

        //show actin sheet on picture click
        $scope.show = function () {
            // Show the action sheet
            $scope.loc = {};
            var customTemplate =
                '<div class="list">'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="camera();">'
                + 'Camera'
                + '</button>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="gallery();">'
                + 'Gallery'
                + '</button>'
                + '<button nav-clear class="button button-block button-positive pay_now_button" ng-click="removePicture(copytTailgateId);" ng-if="isTailgateAdmin && tailgateLogoId > 0">'
                + 'Remove Picture'
                + '</button>'
                + '</div>'
                + '</div>';
            $scope.cameraPopup = $ionicPopup.show({
                template: customTemplate,
                cssClass: 'no-popup-header',
                scope: $scope
            });
            IonicClosePopupService.register($scope.cameraPopup);
        };

        $scope.removePicture = function (id) {
            if (id > 0) {
                var confirmPopup = $ionicPopup.confirm({
                    title: 'Remove tailgate logo ?'
                });

                confirmPopup.then(function (res) {
                    if (res) {
                        $scope.cameraPopup.close();
                        TailgateService.removeTailgateLogo(id).then(function (res) {
                            $scope.tailgateLogoId = 0;
                        }, function (err) {
                            // show alert can not delete logo
                        })
                    } else {
                        $scope.cameraPopup.close();
                    }
                });
                IonicClosePopupService.register(confirmPopup);
            }

        }
        //camera plugin
        $scope.camera = function () {
            $scope.cameraPopup.close();
            if ($scope.isMobile.Android()) {
                $scope.checkPermission();
            } else if ($scope.isMobile.iOS()) {
                $scope.openCamera();
            }
        }
        $scope.openCamera = function () {
            // var options = {
            //     quality: 50,
            //     destinationType: Camera.DestinationType.FILE_URI,
            //     sourceType: Camera.PictureSourceType.CAMERA,
            //     allowEdit: true,
            //     encodingType: Camera.EncodingType.JPEG,
            //     popoverOptions: CameraPopoverOptions,
            //     saveToPhotoAlbum: false,
            //     correctOrientation: true
            // };

            // $cordovaCamera.getPicture(options).then(function (imageURI) {
            //     if (tailgateId && tailgateId > 0) {
            //         $scope.uploadFileToServer(imageURI, tailgateId, "Image uploaded");
            //     } else {
            //         $("#tailgateImage").attr("src", imageURI);
            //         $scope.setSelectedImageURIToUpload(imageURI);
            //     }
            // }, function (err) {
            //     $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+err+'</div>', noBackdrop: false, duration: 2000 });
            // });

            navigator.camera.getPicture(onSuccess, onFail, { 
                quality: 50,
                allowEdit: true,
                encodingType: Camera.EncodingType.JPEG,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false,
                correctOrientation: true,
                destinationType: Camera.DestinationType.NATIVE_URI,
                targetWidth: 760,
                targetHeight: 760 
            });
        };

        function onSuccess(imageURI) {
            if (tailgateId && tailgateId > 0) {
                $scope.uploadFileToServer(imageURI, tailgateId, "Image uploaded");
            } else {
                $("#tailgateImage").attr("src", imageURI);
                $scope.setSelectedImageURIToUpload(imageURI);
            }
        }

        function onFail(message) {
            $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+message+'</div>', noBackdrop: false, duration: 2000 });
        }

        $scope.checkPermission = function () {
            var hasPermission = false;
            var permissions = cordova.plugins.permissions;
            permissions.hasPermission(permissions.READ_EXTERNAL_STORAGE, checkPermissionCallback, null);
            function checkPermissionCallback(status) {
                if (!status.hasPermission) {
                    var errorCallback = function () {
                    }

                    permissions.requestPermission(
                        permissions.READ_EXTERNAL_STORAGE,
                        function (status) {
                            if (!status.hasPermission) {
                                errorCallback();
                            } else {
                                $scope.openCamera();
                                hasPermission = status.hasPermission;
                            }
                        },
                        errorCallback);
                } else {
                    hasPermission = status.hasPermission;
                    $scope.openCamera();
                }
            }
            return hasPermission;
        };
        // for accessing gallery on mobile
        $scope.gallery = function () {
            $scope.cameraPopup.close();
            var options = {
                destinationType: Camera.DestinationType.FILE_URI,
                sourceType: Camera.PictureSourceType.PHOTOLIBRARY,
                allowEdit: true,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false,
                correctOrientation: false
            };
            $cordovaCamera.getPicture(options).then(function (imageURI) {
                if (tailgateId && tailgateId > 0) {
                    $scope.uploadFileToServer(imageURI, tailgateId, "Image Uploaded");
                } else {
                    $("#tailgateImage").attr("src", imageURI);
                    $scope.setSelectedImageURIToUpload(imageURI);
                }
            }, function (err) {
                if(err=='has no access to assets'){
                    $ionicLoading.show({ template: '<div style="text-transform: capitalize;"> Please provide permission to Access Gallery</div>', noBackdrop: false, duration: 2000 });
                }else{
                    $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+err+'</div>', noBackdrop: false, duration: 2000 });
                }
            });

        }
        $scope.setSelectedImageURIToUpload = function (imageURI) {
            // $scope.defaultImageUrl = imageURI;
            $scope.isImageSelectedToUpload = true;
            $scope.selectedImageURIToUpload = imageURI;
        };
        $scope.reSetSelectedImageURIToUpload = function () {
            $scope.isImageSelectedToUpload = false;
            $scope.selectedImageURIToUpload = '';
        }

        $scope.isUserTailgateAdmin = function (tailgateId) {
            TailgateService.isUserTailgateAdmin(tailgateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };
        $scope.uploadFileToServer = function (fileURL, tailgateId, message) {
            $rootScope.$broadcast('loading:show');
            var options = {};
            options.fileKey = "file";
            var params = {};
            params.tailgateId = tailgateId;
            options.params = params;
            var authdata = $cookies.get("authData");
            var headers = {};
            headers.Authorization = 'Basic ' + authdata;
            options.headers = headers;
            $cordovaFileTransfer.upload(encodeURI(SERVER.url + '/flask-user-tailgate-portlet.tailgateimages/upload-tailgate-logo'), fileURL, options)
                .then(function (r) {
                    $rootScope.$broadcast('loading:hide')
                    $scope.reSetSelectedImageURIToUpload();
                    var data = $.parseJSON(r.response);
                    var uuid = data.uuid;
                    $scope.addTailgateParams.logoId = data.fileEntryId;
                    var groupId = data.groupId;
                    $scope.tailgateLogoId = 1;
                    // var title = data.title;
                    $scope.setLogoImageUrl(groupId, uuid);
                    showToastMessage(message);
                }, function (error) {
                    $scope.reSetSelectedImageURIToUpload();
                    $rootScope.$broadcast('loading:hide');
                    $ionicLoading.show({ template: '<div style="text-transform: capitalize;">'+error.code+'</div>', noBackdrop: false, duration: 2000 });
                    //alert("An error has occurred: Code = " + error.code);
                    //$ionicLoading.show({ template: 'An error has occurred: Code ..!'+error.code, noBackdrop: false, duration: 2000 });
                    //console.log("upload error source " + error.source);
                    //console.log("upload error target " + error.target);
                }, function (progress) {
                    //                    $scope.downloadProgress = (progress.loaded / progress.total) * 100;
                });
        }

        $scope.setLogoImageUrl = function (groupId, uuid) {
            $scope.tailgateLogoUrl = SERVER.hostName + "c/document_library/get_file?uuid=" + uuid + "&groupId=" + groupId;
        }

        //add new tailgate
        $scope.addmyTailgate = function (tailgatedata) {

            tailgatedata = angular.copy(tailgatedata);
            var startTime = Date.parse(tailgatedata.startTime); // Your timezone!
            var endTime = Date.parse(tailgatedata.endTime);
            tailgatedata.tailgateDate = Date.parse($scope.currEventDate);
            tailgatedata.endTime = endTime;
            tailgatedata.startTime = startTime;
            tailgatedata.venmoAccountId = "";
            tailgatedata.amountToPay = 0;

            tailgatedata.eventId = angular.isString(tailgatedata.eventId) ? parseInt(tailgatedata.eventId) : tailgatedata.eventId;
            if (tailgatedata.tailgateId && tailgatedata.tailgateId > 0) {
                tailgatedata.tailgateId = parseInt(tailgatedata.tailgateId)
                TailgateService.updateTailgateInfo(tailgatedata).then(function (respdata) {

                    $cookies.putObject('newtailgatedata', respdata);
                    showToastMessage('Tailgate updated successfully');
                });
            }
            else {
                tailgatedata.logoId = 0;
                TailgateService.addTailgate(tailgatedata).then(function (respData) {
                    tailgateId = respData.data.tailgateId;
                    if (tailgateId > 0) {
                        $scope.copytTailgateId = tailgateId;
                        $scope.addTailgateParams.tailgateId = tailgateId;
                        $scope.addTailgateParams.logoId = respData.data.logoId;
                        $cookies.putObject('newtailgatedata', respData.data);
                        if ($scope.isImageSelectedToUpload) {
                            $scope.uploadFileToServer($scope.selectedImageURIToUpload, tailgateId, 'Tailgate created. Tap next tab to add location');
                        } else {
                            showToastMessage('Tailgate created. Tap next tab to add location');
                        }
                    } else {
                        $flaskUtil.alert('Failed to create tailgate');
                    }
                });
            }
        }

        function showToastMessage(message) {
            if (message.length > 0) {
                $ionicLoading.show({ template: message, noBackdrop: true, duration: 2000 });
            }
        }


        //update tailgate
        $scope.updatetailgate = function (newUpdate) {
            var updateData = $cookies.getObject("newtailgatedata");
            updateData.venmoAccountId = newUpdate.venmoAccountId;
            updateData.amountToPay = parseFloat(newUpdate.amountToPay);
            //console.log(updateData);
            TailgateService.updateTailgateInfo(updateData).then(function (respdata) {
                showToastMessage('Payment details saved');
            });
            //fnPayNow();
        }
        // get selected venue details
        $scope.getvenuefromSelect = function (tailgatedata) {
            TailgateService.addTailgate(tailgatedata).then(function (respData) {
            });
        }
        // to get all filtered event list in the select box.
        function getallEventnames() {
            $scope.tailgateParams = {
                eventTypeIds: $scope.eventTypeIds,
                startDate: $scope.startDate,
                endDate: $scope.endDate,
                searchString: $scope.searchString,
                latitude: $scope.latitude,
                longitude: $scope.longitude
            }
            TailgateService.getallFilteredEvents($scope.tailgateParams).then(function (respData) {
                $scope.eventDetails = respData.Events;
                if ($scope.disableDorpDown == true) {
                    var eventExistInDropdown = false
                    angular.forEach($scope.eventDetails, function (value, key) {
                        if (value.eventName == $scope.expiredEventDetail.eventName) {
                            eventExistInDropdown = true;
                        }

                    })
                    if (eventExistInDropdown == false) {
                        $scope.eventDetails.push($scope.expiredEventDetail);
                    }
                }
            });
        }

        //for adding attendees in new tailgate
        $scope.myTailgaters = [];
        $scope.active = true; // define the tab in add group and add friend section
        $scope.active1 = true;
        $scope.collapsed = true;
        $scope.collapsedItems = true;
        $scope.myFriends = [];
        $scope.taigaterFriends = [];


        function getTailgaters(newtailgateId) {
            TailgateService.getMyTailgateUsers(newtailgateId).then(function (respData) {
                //console.log(respData);
                $scope.haveTailgatorsDEtail = true;
                $scope.myTailgaters = respData.data;
                $scope.filterMemberToAdd();
            });
        }
        function getAllFriends() {
            TailgateService.getUserFrends().then(function (response) {
                $scope.taigaterFriends = response;
                $scope.friendsResponseLegth = response.length;
                if ($localStorage["myFriendDetail"].length == response.length) {
                    $scope.myFriends = $localStorage["myFriendDetail"];
                    if ($scope.haveTailgatorsDEtail == true)
                        $scope.filterMemberToAdd();
                }
                else {
                    angular.forEach(response, function (value, key) {
                        if (value.portraitId > 0) {
                            $scope.getUserProfile(value);
                        } else {
                            $scope.myFriends.push(value);
                            if ($scope.friendsResponseLegth == $scope.myFriends.length && $scope.haveTailgatorsDEtail == true) {
                                $scope.filterMemberToAdd();
                            }
                            if (userExistInLocal(value) == false) {
                                $localStorage["myFriendDetail"].push(value);
                            }
                        }
                    })

                }
            })
        }
        $scope.getUserProfile = function (UserDetail) {
            UserService.getUserProfile(UserDetail.userId).then(function (res) {
                if (res.data.fileEntryId != undefined) {
                    UserDetail.friendProfilePicUrl = $scope.imgUrl + res.data.uuid + "&groupId=" + res.data.groupId;
                    $scope.myFriends.push(UserDetail);
                    if ($scope.friendsResponseLegth == $scope.myFriends.length && $scope.haveTailgatorsDEtail == true) {
                        $scope.filterMemberToAdd();
                    }

                    if (userExistInLocal(UserDetail) == false) {
                        $localStorage["myFriendDetail"].push(UserDetail);
                    }
                } else {
                    $scope.myFriends.push(UserDetail);
                    if ($scope.friendsResponseLegth == $scope.myFriends.length && $scope.haveTailgatorsDEtail == true) {
                        $scope.filterMemberToAdd();
                    }

                    if (userExistInLocal(UserDetail) == false) {
                        $localStorage["myFriendDetail"].push(UserDetail);
                    }
                }


            }, function (err) {
                $ionicLoading.show({ template: 'Error in getting user Profile Picture!', noBackdrop: false, duration: 2000 });
            })
        };
        function userExistInLocal(userDetail) {
            var exist = false;
            angular.forEach($localStorage["myFriendDetail"], function (value, key) {
                if (value.userId == userDetail.userId) {
                    exist = true
                }
            });
            return exist;
        }
        $scope.filterMemberToAdd = function () {
            $scope.friendsToInvite = [];
            angular.forEach($scope.myFriends, function (value, key) {
                if (!(IsUserTailgateMember(value))) {
                    $scope.friendsToInvite.push(value);
                }
            });


        }
        function IsUserTailgateMember(value) {
            var userExist = false;
            angular.forEach($scope.myTailgaters, function (value2, key2) {
                if (value2.userId == value.userId) {
                    userExist = true;
                    return userExist
                }
            });
            return userExist;

        }

        //add single member to the tailgate
        $scope.addTailgateMembers = function (currUserData, index) {
            var addUserparams = {};
            addUserparams.groupId = 0;
            addUserparams.userId = currUserData.userId;
            addUserparams.userName = currUserData.firstName + " " + currUserData.lastName;
            addUserparams.emailAddress = currUserData.emailAddress;
            addUserparams.isAdmin = 0;
            addUserparams.tailgateId = tailgateId;
            addUserparams.isPaid = 0;
            addUserparams.paymentMode = "None";
            addUsertoTailgate(addUserparams, index);
            $scope.taigaterFriends.splice(index, 1)

        }
        //get all groups either created by user or is a member of particular group.
        function getAllGroups() {
            userResponse = $cookies.getObject('CurrentUser');
            UserId = userResponse.data.userId;
            TailgateService.getGroupbyId(UserId).then(function (respData) {
                $scope.allGroups = respData;
            });
        }
        //add user info to current tailgate
        function addUsertoTailgate(userparams, index) {
            TailgateService.addcurrentUser(userparams).then(function (respData) {
                if (index != undefined) {
                    $scope.friendsToInvite.splice(index, 1);
                }
                getTailgaters(tailgateId);
            });
        }
        $scope.getUseData = [];
        //get all the members of the group
        $scope.getusersofGroup = function (groupId, index) {
            TailgateService.getGroupUsers(groupId).then(function (respData) { //get data of group from group id
                for (var i = 0; i < respData.length; i++) {
                    $scope.getUseData.push(respData[i]); //to get users of particular group
                    var adduser = {};
                    adduser.groupId = $scope.getUseData[i].groupId;
                    adduser.userId = $scope.getUseData[i].userId;
                    adduser.userName = $scope.getUseData[i].userName;
                    adduser.emailAddress = $scope.getUseData[i].emailAddress;
                    adduser.isAdmin = 0;
                    adduser.tailgateId = tailgateId;
                    adduser.isPaid = 0;
                    adduser.paymentMode = "None";
                    addUsertoTailgate(adduser);
                }
                $scope.allGroups.splice(index, 1);
                //console.log($scope.getUseData)
                $scope.groupUserDetails = respData;
            });
        }

        //list of supplies
        function getMySupplyList(selected1) {
            TailgateService.getMySupplyLists().then(function (respData) {
                $scope.allSupplyList = respData.data;
                // for (var i = 0; i < $scope.allSupplyList.length; i++) {
                //     $scope.tailgateSupplyList.push({ supplyListName: $scope.allSupplyList[i].supplyListName, supplyListsId: $scope.allSupplyList[i].supplyListId });
                // }
            });
        }

        //getting supply items
        $scope.getSupplyItem = function (selected) {
            supplyListstId = selected.supplyListsId;
            TailgateService.getItemsbylistid(supplyListstId).then(function (respData) {
                $scope.supplyItemList = respData.data;
            });

        }

        //Get tailgators
        /* function getAllFriends() {
             TailgateService.getUserFrends().then(function (respData) {
                 $scope.myFriends = respData;
             })
         }*/

        //Get tailgates of particular user
        // function getAllMyTailgates(userId) {
        //     TailgateService.getMyTailgates(userId).then(function (respData) {
        //         $scope.allMyTailgate = respData.data;
        //     });
        // }

        //Adding supply items to tailgate
        $scope.addSupplyItems = function () {
            var str = [];
            var replaceStr;
            $scope.items = [];
            angular.forEach($scope.selectedSupplyListItems, function (val, idx) {
                var tempItemName;
                tempItemName = val.supplyItemName;
                if (tempItemName.indexOf("/") > -1) {
                    tempItemName = encodeURIComponent(tempItemName);
                }
                $scope.items.push(tempItemName);
            })
            for (var i = 0; i < $scope.items.length; i++) {
                if ($scope.items[i].match("%2F")) {
                    replaceStr = $scope.items[i].replace(/%2F/g, " or ");
                    str.push(replaceStr);
                }
                else {
                    str.push($scope.items[i]);
                }
            }
            itemArray = JSON.stringify(str);          
            // var tailgateId = $cookies.get("currtailGateId");
            TailgateService.addTailgateSupplyItems(itemArray, tailgateId, "-1").then(function (respData) {
                $scope.alltailgateSupplyItem = respData.data;
                $scope.associateUserWithSupplyItem();
            });

        }


        $scope.associateUserWithSupplyItem = function () {
            angular.forEach($scope.alltailgateSupplyItem, function (value, index) {
                //console.log(value.itemAssignedUserId);
                value.itemAssignedUserId = getAssigenUserId(decodeURIComponent(value.supplyListItemName));
                $scope.updateSupplyItems(value);
            })



        };

        function getAssigenUserId(supplyItemName) {
            var userId;
            angular.forEach($scope.selectedSupplyListItems, function (value, idx) {
                if (value.itemAssignedUserId > 0 && supplyItemName == value.supplyItemName) {
                    userId = value.itemAssignedUserId;
                    return;
                    // $scope.updateSupplyItems(val);
                }
            })
            return userId;
        }

        //venmo Account pay now
        function fnPayNow() {
            $scope.newdata = $cookies.getObject("newtailgatedata");
            var tailgateName = $scope.newdata.tailgateName;
            var tailgateAccount = $scope.newdata.venmoAccountId;
            var amountToPay = $scope.newdata.amountToPay;
            var paymentUrl = "https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName +
                "&recipients=" + tailgateAccount;
            window.open(paymentUrl, '_system', 'location=yes'); // for inapp browser or system app
        }

        $scope.getTailGateLogo = function (tailgateId) {
            TailgateService.getTailgateLogo(tailgateId).then(function (respData) {
                $scope.tailgateLogoInfo = respData.data;
                $scope.setLogoImageUrl($scope.tailgateLogoInfo.groupId, $scope.tailgateLogoInfo.uuid);
            });
        };

        $scope.togglePayment = function () {
            $scope.hidePayment = !$scope.hidePayment;
            $("#paymentDiv").slideToggle("slow", function () {
                $ionicScrollDelegate.resize();
            });
        }

        //$scope.toggleItem = function () {
        //    var supplyItem = $("#supplyItemDiv");
        //    $scope.hideItem = !$scope.hideItem;
        //    $("#FlaskUsListdiv").slideToggle("slow", function () {
        //        $ionicScrollDelegate.resize();
        //        if ($scope.hideItem && supplyItem.is(":visible") === false) {
        //            $scope.hideSupplyItem = !$scope.hideSupplyItem;
        //            supplyItem.slideToggle("slow", function () {
        //                $ionicScrollDelegate.resize();
        //            });
        //        }
        //    });

        //}
        $scope.toggleSupplyItem = function () {
            $scope.hideSupplyItem = !$scope.hideSupplyItem;
            $("#supplyItemDiv").slideToggle("slow", function () {
                $ionicScrollDelegate.resize();
            });
        };

        /*Add the supply list items in already existing array*/
        $scope.copyForMyGameDaySupply = function (supplyObject) {
            $scope.MyGameDaysSupply = [];
            angular.forEach($scope.allSupplyList, function (value, key) {
                if (value.supplyListId == supplyObject.supplyListId) {
                    value.checked = true;

                } else {
                    value.checked = false;
                }
            });
            TailgateService.getItemsbylistid(supplyObject.supplyListId).then(function (response) {
                var currSupplyItemsLength = response.data;
                for (var i = 0 ; i < currSupplyItemsLength.length; i++) {
                    $scope.selectedSupplyListItems.push(currSupplyItemsLength[i]);
                }
                //console.log( $scope.selectedSupplyListItems);
                if ($scope.hideItem == false) {
                    //$scope.toggleItem();
                }
            });

        }
        $scope.removeSelectedSupply = function (list) {
            $scope.selectedSupplyListItems = [];
        }

        $scope.selectGameDaySupply = function (list, checked) {
            if (checked == true) {
                $scope.collapsedItems = false;
                $scope.taigateSupplyList = list;
                $scope.copyForMyGameDaySupply(list);
                $scope.addNewTailgateSuppliesItem = true;
            } else {
                $scope.removeSelectedSupply(list);
            }
        }
        /*Save supply Item in selected supply List
        */
        $scope.saveTailgateSupplyItem = function (listItemName) {
            if (listItemName != undefined && listItemName != "") {
                    if ($scope.taigateSupplyList.supplyListId > 0) {
                        TailgateService.addSupplyItem(listItemName, $scope.taigateSupplyList.supplyListId).then(function (response) {
                            $scope.selectedSupplyListItems.push({
                                supplyItemName: response.supplyItemName,
                                supplyItemId: response.supplyItemId
                            });
                            $scope.addNewSuppliesItem = false;                            
                        });
                    }
                    else {
                        TailgateService.addTailgateSupplyItem(listItemName, tailgateId, "-1").then(function (response) {
                            $scope.selectedSupplyListItems.push({
                                supplyItemName: response.supplyListItemName,
                                supplyItemId: response.tailgateSupplyItemId
                            });
                        });
                    }
                    $ionicLoading.show({ template: listItemName + ' Suppy item added', noBackdrop: false, duration: 2000 });
            }
            else {
                $ionicLoading.show({ template: 'Item name should not be empty', noBackdrop: false, duration: 2000 });
            }
        }
        $scope.addNewTailgateSupplyListItem = function () {
            $scope.addNewSuppliesItem = !$scope.addNewSuppliesItem
            if ($scope.addTailgateSuppliesItem == true) {

            }
        }
        $scope.cancelTailgateSupplyItemAdding = function () {
            $scope.addNewSuppliesItem = false;
        }

        // function getTailgaters() {
        //     var tailgateId = $cookies.get("currtailGateId");
        //     TailgateService.getMyTailgateUsers(tailgateId).then(function (respData) {
        //         $scope.myTailgaters = respData.data;
        //     });
        // }
        $scope.updateSupplyItems = function (data) {
            // if(data.supplyListItemName.indexOf("/") > -1) {
            //     data.supplyListItemName = decodeURIComponent(data.supplyListItemName);
            // }
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, data.tailgateId, data.itemAssignedUserId).then(function (respData) {
                $ionicLoading.show({ template: 'Supply list added successfully', noBackdrop: false, duration: 2000 });
            });
        }
        function getItems() {
            TailgateService.getItemsByTailgateId(tailgateId).then(function (respData) {
                $scope.setSelectedSupplyItemArray(respData.data);
               // $scope.toggleItem();
            });
        }
        //for displaying items from supply list selected
        $scope.setSelectedSupplyItemArray = function (data) {
            $scope.selectedSupplyListItems = [];
            var tempItem = {};
            angular.forEach(data, function (object, idx) {
                tempItem = {};
                tempItem.createdDate = object.createdDate;
                tempItem.modifiedDate = object.modifiedDate;
                tempItem.supplyItemId = object.tailgateSupplyItemId;
                tempItem.supplyItemName = decodeURIComponent(object.supplyListItemName);
                tempItem.itemAssignedUserId = object.itemAssignedUserId + "";
                $scope.selectedSupplyListItems.push(tempItem)
            })
        };
        function getTailgateTime(date) {
            var x = new Date(date);
            var hour = x.getHours();
            var minute = x.getMinutes();
            var year = x.getYear() + 1900;
            var month = x.getMonth();
            var day = x.getDate();
            return new Date(year, month, day, hour, minute, 0);
        }

        $scope.initialize();

        $scope.updateSupplyItemsUser = function (data, index) {
            TailgateService.updateTailgateSupplyItem(data.supplyItemId, data.supplyItemName, tailgateId, data.itemAssignedUserId).then(function (respData) {
                $ionicLoading.show({ template: 'User changed successfully!', noBackdrop: false, duration: 3000 });
            });
        }

        $scope.leaveSupplyItem = function (supplyItemId, index) {
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Supply Item?'
            });
            confirmPopup.then(function (res) {
                if (res) {
                    TailgateService.deleteTailgateSupplyItem(supplyItemId).then(function (respData) {
                        $scope.selectedSupplyListItems.splice(index, 1);
                    });

                } else {
                }
            });
        }

        $scope.deleteTailgateUser = function (currUserId, index) {

            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Tailgater ?'
            });
            confirmPopup.then(function (res) {

                if (res) {
                    if (currUserId != $scope.loggedInUserId) {
                        TailgateService.deleteTailgateUser(tailgateId, currUserId).then(function (response) {
                            for (var i = 0; i < $scope.myTailgaters.length; i++) {
                                if ($scope.myTailgaters[i].userId == currUserId) {
                                    $scope.myTailgaters.splice(i, 1);
                                }
                            }
                        })
                    } else {
                        $flaskUtil.alert("Tailgate admin can't be remove.")
                    }
                } else {
                }
            });

        }

        $scope.changeTailgaterRole = function (currUserId, index) {
            var tailgateDetails = $cookies.getObject("editUserTailgate");
            //console.log(tailgateDetails);
            if (currUserId != tailgateDetails.userId) {
                if ($scope.loggedInUserId == tailgateDetails.userId) {
                    TailgateService.addTailgateAdmin(currUserId, tailgateId).then(function (respData) {
                        $rootScope.role = respData.data;
                        $ionicLoading.show({ template: 'Role changed successfully', noBackdrop: false, duration: 3000 });
                    });
                }
                else {
                    $ionicLoading.show({ template: 'You do not have the permission to change the role!', noBackdrop: false, duration: 3000 });
                }
            }
            else {
                $ionicLoading.show({ template: 'Tailgate admin cannot be removed!', noBackdrop: false, duration: 3000 });
            }
        }


        //Flask user locator when user clicks on "Find Me" button
        $scope.centerOnMe = function () {
            $scope.isUserMarkerShown = !$scope.isUserMarkerShown;
            if ($scope.isUserMarkerShown) {
                    if($scope.userlat!=undefined && $scope.userlong!=undefined){
                        $scope.map = {
                            center: {
                                latitude: $scope.userlat,
                                longitude: $scope.userlong
                            },
                            zoom: 14
                        }
                        $scope.marker = {
                            id: 1,
                            coords: {
                                latitude: $scope.userlat,
                                longitude: $scope.userlong
                            },
                            options: { icon: 'img/map_icons/tailgateMarker.svg', labelContent: "You Are Here", labelAnchor: "50 85", labelClass: 'UserGeolabels' }
                        }
                    }else{
                        $flaskUtil.alert("Unable to Get Location, Please Switch on GPS and Check App Location Permissions");
                    }
            } else {
                $scope.marker = {};
                callMap($scope.latitude, $scope.longitude);
            }
        }
        function getGeoLocation() {
            var posOptions = { timeout: 10000, enableHighAccuracy: false };
            $cordovaGeolocation
              .getCurrentPosition(posOptions)
              .then(function (pos) {
                  $scope.userlat = pos.coords.latitude;
                  $scope.userlong = pos.coords.longitude;
              }, function (err) {
                  // error
                  // $flaskUtil.alert("Unable to Get Location");
                  $ionicLoading.show({ template: 'Unable to Get Location!', noBackdrop: false, duration: 2000 });
              });
        }

    }
})();
