(function() {
    'use strict';
    angular.module('flaskApp')
        .controller('FriendsGroupDetailCtrl', FriendsGroupDetailCtrl);

    FriendsGroupDetailCtrl.$inject = ['$scope','GroupService','$stateParams','$state','$ionicModal','$ionicHistory'];
    function FriendsGroupDetailCtrl($scope,GroupService,$stateParams,$state,$ionicModal,$ionicHistory) {

        $scope.groupTitle=$stateParams.groupName;

        $scope.allMember=[];
        $scope.test=true;
        $scope.groupId=GroupService.groupId;
        $scope.groupDetail=GroupService.groupDetail;
        $scope.editGroup=false;
        if(!$scope.groupDetail){
            $scope.editGroup=false;
        }else{
            $scope.editGroup=true;
        }
        $scope.goBack = function(){
            $ionicHistory.goBack();
        }
        GroupService.getAllGroupMember($scope.groupId).then(function(response){
            $scope.allMember=response;
        });
        $ionicModal.fromTemplateUrl('templates/modal.html', {
            scope: $scope
        }).then(function (modal) {
            $scope.modal = modal;
        });
        $scope.updateGroup=function(groupName,groupDescription){
       GroupService.updateGroup(groupName,groupDescription,$scope.groupDetail.isDelete,$scope.groupDetail.isActive,$scope.groupDetail.createdBy,$scope.groupId,$scope.groupDetail.createdDate).then(function(response){
           $scope.groupTitle=response.groupName;
           $scope.editGroup=false;
       });
        }

        $scope.groupMemberDetail=function(data){
            $state.go('app.groupMemberDetail');
            GroupService.groupMemberDetail=data;

        }

        $scope.showInviteFriendPopup = function(){
            // $scope.searchUserContact('',$scope.startIndex, $scope.endIndex);
            GroupService.getMyFriendList().then(function(resopnse){
                $scope.userContactList=resopnse;
                angular.forEach($scope.userContactList,function(value1,key1){
                    angular.forEach($scope.allMember,function(value2,key2){
                     if(value1.userId==value2.userId){
                         $scope.userContactList[key1]="";
                     }
                    })
                });
                Array.prototype.clean = function(deleteValue) {
                    for (var i = 0; i < this.length; i++) {
                        if (this[i] == deleteValue) {
                            this.splice(i, 1);
                            i--;
                        }
                    }
                    return this;
                };
                $scope.userContactList.clean("");
                $scope.userContactList.clean(undefined);
                $scope.memberNotAdded(null);

            });
            $scope.modal.show();
        };

        $scope.closeInviteFriendPopup = function () {
            $scope.modal.hide();
            //$scope.resetPopup();
        };
        $scope.resetPopup = function() {
            $scope.endIndex = 9;
            $scope.searchContact.searchtext =  "";
        };
        $scope.memberNotAdded=function(userId){
            $scope.memberToAddInGroup=[];
            var counter=-1;
            $scope.MatchedIndex=-1;
            angular.forEach($scope.userContactList,function(value,key){
                counter++
                if(value.userId!=userId){
                    $scope.memberToAddInGroup.push(value);
                }else{
                    $scope.MatchedIndex=counter;
                }
            });
            if($scope.MatchedIndex!=-1){
                $scope.userContactList.splice($scope.MatchedIndex,1);
            }

        }
        $scope.addUserToGroup=function(data){
            GroupService.addUserToGroup($scope.groupId,data.emailAddress,data.userId,data.fullName,0).then(function(response){
                var userId=response.userId;
                $scope.memberNotAdded(userId);
            });

        }
        $scope.finishAddingMember=function(){
            $scope.modal.hide();
            GroupService.getAllGroupMember($scope.groupId).then(function(response){
                $scope.allMember=response;
            });
        }
        $scope.removeMember=function(data,index){

            GroupService.deleteGroupUser($scope.groupId,data.userId).then(function(response){
                $scope.allMember.splice(index,1);
            });

        }


    }
})();