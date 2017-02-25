﻿(function () {
    'use strict';
    angular.module('flaskApp')
        .controller('mytailgatePlanCtrl', mytailgatePlanCtrl);

    mytailgatePlanCtrl.$inject = ['$scope', '$state', '$stateParams', 'TailgateService', '$cookies', '$ionicModal'];

    /* @ngInject */
    function mytailgatePlanCtrl($scope, $state, $stateParams, TailgateService, $cookies, $ionicModal) {
        $scope.myTailgaters;
        var supplyItemName;
        $scope.tailgateItems = [];
        $scope.myTailgateMember = [];
        $scope.tailgateSupplyItems = [];
        $scope.isTailgateAdmin = false;
        var tailGateId = $cookies.get('currtailGateId');
        
        $scope.userId = "";
        $scope.goBack = function () {
            $state.go("app.my_tailgate");
        }

        $scope.user = {
            supplyItemName: ['user']
        };

        function getTailgaters() {
            TailgateService.getMyTailgateUsers(tailGateId).then(function (respData) {
                $scope.myTailgaters = respData.data;
               getItems();
            });
        }

        function getMyTailgate() {
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                $scope.myTailgate = respData.data;
            });
        }


        // function getAllMyTailgates(userId) {
        //     TailgateService.getMyTailgates(userId).then(function (respData) {
        //         $scope.allMyTailgate = respData.data;
        //     });
        // }

        function getItems() {
            TailgateService.getItemsByTailgateId(tailGateId).then(function (respData) {
                $scope.allMyTailgateItems = respData.data;
                setMyTailGateItems();
            });
        }
        function setMyTailGateItems(){
            angular.forEach($scope.allMyTailgateItems,function(val,index){
            val.itemAssignedUserId = val.itemAssignedUserId+"";
            val.supplyListItemName = decodeURIComponent(val.supplyListItemName);
            val.itemAssignedUserName = getUserNameById(val.itemAssignedUserId);
            })
        }

        $scope.isUserTailgateAdmin = function (tailGateId) {
            TailgateService.isUserTailgateAdmin(tailGateId).then(function (respData) {
                $scope.isTailgateAdmin = respData.data;
            });
        };

        $scope.isUserTailgateAdmin(tailGateId);

        //for editing plan now page on tab
        $scope.goToPlanNowTab = function () {
            //add cookie data for editing particular page on tab.
            $cookies.putObject("tabtoEdit", [3,'planNowTab']);
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

        function editTailgate(tailGateId) {
            var addTailgateParams = {}
            TailgateService.getTailgate(tailGateId).then(function (respData) {
                console.log("console.log(respData.data);");
                console.log(respData.data);
                $cookies.putObject("editUserTailgate", respData.data);     
                $state.go("app.add_my_tailgate");
            });
        }

        function getUserNameById(userId) {
            var userName = "";
            angular.forEach($scope.myTailgaters,function(val,idx){
                if(val.userId == userId) {
                    userName = val.userName;
                    return false;
                }
                }
            )
            return userName;
        }
        //Adding supply items to tailgate
        $scope.updateSupplyItems = function (data, user_selected) {
            console.log(user_selected);
            $scope.userId = user_selected;
            TailgateService.updateTailgateSupplyItem(data.tailgateSupplyItemId, data.supplyListItemName, tailGateId, $scope.userId).then(function (respData) {

            });
        };

        //venmo Account pay now
        $scope.fnPayNow = function() {
            var tailgateId = $scope.myTailgate.tailgateId;
            var tailgateName = $scope.myTailgate.tailgateName;
            var tailgateAccount = $scope.myTailgate.venmoAccountId;
            var amountToPay = $scope.myTailgate.amountToPay;
            var paymentUrl = "https://venmo.com/?txn=pay&amount=" + amountToPay + "&note= for tailgate " + tailgateName +
            "&recipients=" + tailgateAccount;
            window.open(paymentUrl, '_system', 'location=yes'); // for inapp browser or system app
        };

        getMyTailgate();
        // getAllMyTailgates();
        getTailgaters();
    }
})();