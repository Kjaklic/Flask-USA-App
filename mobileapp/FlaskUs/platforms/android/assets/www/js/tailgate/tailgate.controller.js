﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('my_tailgateCtrl', my_tailgateCtrl);

    my_tailgateCtrl.$inject = ['$scope', 'TailgateService', '$state', '$ionicSlideBoxDelegate', '$cookies','SERVER','$ionicPopup'];

    /* @ngInject */
    function my_tailgateCtrl($scope, TailgateService, $state, $ionicSlideBoxDelegate, $cookies,SERVER,$ionicPopup) {
        var self = this;
        $scope.myTailgate = [];
        $cookies.remove("editUserTailgate");
        $cookies.remove("newtailgateId");
        $cookies.remove("newtailgatedata");
        var userResponse = $cookies.getObject('CurrentUser');
        var UserId = userResponse.data.userId;
        $scope.imgUrl = SERVER.hostName + "c/document_library/get_file?uuid=";
         $scope.allTailgate = [];
        getAlltailgates();
        $scope.goBack = function () {
            $state.go("app.user_navigation_menu");
        }

        function getAlltailgates() {
            TailgateService.getMyTailgates(UserId).then(function (respData) {
                var myTailgates = respData.data;
                setLogoUrl(myTailgates);
            });
        }
        function setLogoUrl(myTailgates) {
            angular.forEach(myTailgates, function(object, index) {
                if(object.logoId > 0) {
                    $scope.getTailGateLogo(object);
                }else {
                    $scope.allTailgate.push(object);
                }
            })
        }
      
        $scope.getTailGateLogo = function (tailgateObj) {
            var url  = angular.copy($scope.imgUrl);
            TailgateService.getTailgateLogo(tailgateObj.tailgateId).then(function (respData) {
                var groupId = respData.data.groupId;
                if (groupId != undefined && groupId > 0) {
                   url  = url+ respData.data.uuid + "&groupId="+groupId;
                   tailgateObj.logoUrl = url;
                    $scope.allTailgate.push(tailgateObj);
                } 
            });
        };
        $scope.editTailgate = function (tailgateId, index) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailgateId).then(function (respData) {
                console.log(respData.data);
                addTailgateParams.tailgateId = tailgateId;
                addTailgateParams.tailgateName = respData.data.tailgateName;
                addTailgateParams.tailgateDescription = respData.data.tailgateDescription;
                addTailgateParams.eventId = respData.data.eventId;
                addTailgateParams.eventName = respData.data.eventName;
                addTailgateParams.endTime =respData.data.endTime;
                addTailgateParams.startTime =  respData.data.startTime;
                addTailgateParams.venmoAccountId = respData.data.venmoAccountId;
                addTailgateParams.amountToPay = respData.data.amountToPay;
                addTailgateParams.tailgateDate = respData.data.tailgateDate;
                addTailgateParams.logoId = respData.data.logoId;
                $cookies.put('currtailGateId', tailgateId);
                $state.go("app.add_my_tailgate");
                $cookies.putObject("editUserTailgate", addTailgateParams);
            });
        };
       

        $scope.leaveTailgate = function (tailgateId, index) {
            console.log(tailgateId, index);
            var confirmPopup = $ionicPopup.confirm({
                title: 'Delete Tailgate?'
            });
            confirmPopup.then(function(res) {
                if(res) {
                    TailgateService.deleteTailgate(tailgateId).then(function (respData) {
                        console.log(respData);
                        $scope.allTailgate.splice(index, 1);
                    });

                } else {
                }
            });





        }
        $scope.addMyTailgate = function () {
            $cookies.put("currtailGateId", "0");
            $state.go("app.add_my_tailgate");
        }
    }
})();

