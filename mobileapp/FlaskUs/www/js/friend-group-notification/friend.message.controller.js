(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsMessageCtrl', FriendsMessageCtrl);

    FriendsMessageCtrl.$inject = ['$scope', '$http', '$ionicModal', 'FriendsNotificationService', '$flaskUtil', '$state','$ionicHistory','$timeout','$ionicLoading'];

    /* @ngInject */
    function FriendsMessageCtrl($scope, $http, $ionicModal, FriendsNotificationService, $flaskUtil, $state,$ionicHistory,$timeout,$ionicLoading) {
        $scope.allMessages=[];
        $scope.showTextArea={show:false};
        $scope.textMessage={messageToSend:""};
        $scope.ShowReplyButton=true;
        $scope.getNotification=function() {
            $scope.myTimeOut= $timeout(function () {
                FriendsNotificationService.getMessageCount().then(function (response2) {
                    $scope.messageCount = response2;
                    if ($scope.copyCount!=undefined && $scope.messageCount!=undefined) {
                        if ($scope.copyCount != $scope.messageCount) {
                            FriendsNotificationService.getMyAllMessages().then(function (response) {
                                $scope.allMessages = response;
                                $scope.getMessagesTime();
                            });
                        }
                    }

                    $scope.copyCount = angular.copy($scope.messageCount);
                });
                $scope.getNotification();
                $scope.$on('$locationChangeStart', function() {
                    $timeout.cancel($scope.myTimeOut);
                });
            }, 2000);
        }
        $scope.getTimeWithInterval=function(){
            $scope.messageTimeOut=$timeout(function(){
                $scope.getMessagesTime();
                $scope.getTimeWithInterval();
            },10000);

        };
       /* $scope.replyMessage=function(msgDetail,index) {
            angular.forEach($scope.allMessages, function (value, key) {

                value.reply = false
            });


            $scope.allMessages[index].reply = true;
        }*/
        $scope.replyMessage=function(msgDetail,index,textMessage,string) {
            angular.forEach($scope.allMessages, function (value, key) {

                value.reply = false
            });


            $scope.allMessages[index].reply = true;
            $scope.showTextArea.show = true;
            $scope.ShowReplyButton=true;
            setTimeout(startToggleFunction, 20)

            function startToggleFunction() {

                $scope.messageBoxClasses = document.getElementById("textArea").classList;

                if ($scope.messageBoxClasses.contains("hideAll")) {
                    $scope.messageBoxClasses.remove("hideAll");
                }
                ;
                setTimeout(removeText, 10);
                function removeText() {
                    if ($scope.messageBoxClasses.contains("hidemsgTexArea")) {
                        $scope.messageBoxClasses.remove("hidemsgTexArea");
                    }
                    else {
                        if (textMessage == undefined || textMessage.trim() === '' && string!="") {
                            $scope.messageBoxClasses.add("hidemsgTexArea");
                            setTimeout(hideArea, 400);
                            return;
                        }
                        if(string!=""){
                        FriendsNotificationService.sendMessage(msgDetail.senderUserId, textMessage).then(function (res) {
                            if (res != undefined && res.sendEmail == true) {
                                $scope.messageSentStatus = true;

                                $scope.textMessage={messageToSend:""};

                                $timeout(function () {  $scope.ShowReplyButton=false;},1000);
                                $ionicLoading.show({ template: 'Message sent', noBackdrop: false, duration: 5000 });

                                $timeout(function () {  $scope.messageBoxClasses.add("hidemsgTexArea");
                                    setTimeout(hideArea, 400);},1200);

                            } else {
                                $flaskUtil.alert("Failed to send message");
                            }

                        });}

                    }
                }
            }

            function hideArea() {
                $scope.messageBoxClasses.add("hideAll");
                $timeout(function () { $scope.showTextArea.show = false; }, 10);
            }
        }
        function hideMessageDiv(){
            $scope.messageSentStatus = false;
        }
        $scope.getMessagesTime=function() {
            angular.forEach($scope.allMessages, function (value, key) {
                $scope.messageDate = new Date(value.dateTime);
                var result = getTimeDifference();
                value.diffDate = result;

            });
        }


    FriendsNotificationService.getMyAllMessages().then(function(response){
       $scope.allMessages=response;
        angular.forEach($scope.allMessages,function(value,key){
            $scope.messageDate=new Date(value.dateTime);
            var result=getTimeDifference();
            value.diffDate=result;
        });
    });
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
   function getTimeDifference(){
       var todayDate=new Date();
       var differenceTravel = todayDate.getTime()-$scope.messageDate.getTime();
       var seconds = Math.floor((differenceTravel) / (1000));
       var days=parseInt((seconds/(3600*24) ));
       var hours=parseInt(seconds/3600);
       var minutes=parseInt(seconds/60);
       var months=parseInt(days/30);
       var year=parseInt(months/12);
       if(seconds<60){
           return seconds+" seconds ago"
       }
       else if(minutes<60){
           return minutes+' minutes ago';
       }else if(hours<24){
           return hours+" hours ago";
       }
       else if(days<31){
           return days+" days ago"
       }else if(months<12){
           return months+" months ago"

       }else {
           year+" years ago"
       }
   }


    $scope.deleteMessage=function(messageId,index){
    FriendsNotificationService.deleteMessageById(messageId).then(function(response){
        if(response){
            $scope.allMessages.splice(index,1);
        }

    })
    }
       /* $timeout(function(){
            $scope.getTimeWithInterval();
        },10000);*/
    }


})();