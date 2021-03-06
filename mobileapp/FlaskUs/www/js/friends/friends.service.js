
(function () {
    'use strict';
    angular
        .module('flaskApp')
        .service('FriendsService', FriendsService);

    FriendsService.$inject = ['$http','SERVER','$q'];

    function FriendsService($http, SERVER,$q) {
        var services =  {
            getMyFriends :getMyFriends,
            getFriendByUserId :getFriendByUserId ,
            sendMessage:sendMessage,
            unFriend : unFriend,
            blockUser : blockUser,
            searchUserContact:searchUserContact,
            sendFriendRequest : sendFriendRequest,
            unBlockUser : unBlockUser,
            showStatusofAPIonFaliure : showStatusofAPIonFaliure
        }
        this.data={};
        this.mediatorUserId={};
        var searchMyFriend = "/flask-social-portlet.entry/search-my-friends";
        var searchFriendById = "/flask-social-portlet.entry/get-user-by-id";
        var searchUserContactPath = '/flask-social-portlet.entry/search-users-and-contacts';
        var sendFlaskMessage = "/flask-social-portlet.flaskmessages/send-flask-message";
        var blockUserPath = "/flask-social-portlet.entry/block-user";
        var unFriendPath = "/flask-social-portlet.entry/delete-social-relation";
        var addFriendsPath  ="/flask-social-portlet.entry/request-social-relation";
        var unBlockUserPath = "/flask-social-portlet.entry/unblock-user";
        var companyId = SERVER.companyId;
         function getMyFriends(searchText) {
                    return $http.get(SERVER.url+searchMyFriend,{params:{
                        companyId: companyId,
                        keywords: searchText
                    }})
                    .then(function success(response) {
                        return response.data;
                    }, function failure(response) {
                        showStatusofAPIonFaliure(response);
                        return $q.$inject(response);
                        //add errror handling 
                    });
        }
        function searchUserContact(keyword, start, end) {
                    return $http.get(SERVER.url+searchUserContactPath,{params:{
                        companyId: companyId,
                        keywords: keyword,
                        start:start,
                        end:end
                    }})
                    .then(function success(response) {
                        return response.data;
                    }, function failure(response) {
                        showStatusofAPIonFaliure(response);
                        return $q.$inject(response);
                        //add errror handling 
                    });
        }
        function getFriendByUserId(userId) {
                return $http.get(SERVER.url+searchFriendById,{params:{
                    userId: userId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    showStatusofAPIonFaliure(response);
                    return $q.$inject(response);
                    //add errror handling 
                });
        }

        function sendMessage (userId,messgae) {
                return $http.get(SERVER.url+sendFlaskMessage,{params:{
                    recipients: userId,
                    message:messgae,
                    sendEmail:true
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    showStatusofAPIonFaliure(response);
                    return $q.$inject(response);
                    //add errror handling 
                });
        }
        function blockUser(blockUserId) {
                return $http.get(SERVER.url+blockUserPath,{params:{
                    blockUserId: blockUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    showStatusofAPIonFaliure(response);
                    return $q.$inject(response);
                    //add errror handling 
                });
        }
        function unFriend(receiverUserId) {
                return $http.get(SERVER.url+unFriendPath,{params:{
                    receiverUserId: receiverUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    showStatusofAPIonFaliure(response);
                    return $q.$inject(response);
                    //add errror handling 
                });
        }

        function sendFriendRequest (receiverUserId) {
                return $http.get(SERVER.url+addFriendsPath,{params:{
                    receiverUserId: receiverUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    showStatusofAPIonFaliure(response);
                    return $q.$inject(response);
                    //add errror handling 
                });
        }
        function unBlockUser (unblockUserId) {
                return $http.get(SERVER.url+unBlockUserPath,{params:{
                    unblockUserId: unblockUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    showStatusofAPIonFaliure(response);
                    return $q.$inject(response);
                    //add errror handling 
                });
        }

        function showStatusofAPIonFaliure(err){
            if(err.status == 400){
                $flaskUtil.alert('Bad Request from server');
            }else if(err.status == 401){
                $flaskUtil.alert('Please check if your username and password are correct.');}
            else if(err.status == 403){
                $flaskUtil.alert('Too many connections on server');
            }else if(err.status == 500){
                $flaskUtil.alert('Something wrong with server');
                $state.go("app.events");
            }else if(err.status == -1){
                $flaskUtil.alert(" Please Check your Internet Connection and restart the App");     
            }else if(err.status == 503){
                $flaskUtil.alert("Server is currently Unavailable, please try after sometime");
                $state.go("app.events");
            }else if(err.status == 404){
                $flaskUtil.alert("Requested data not found on server");
            }else if(err.status == 502){
                $flaskUtil.alert("Invalid response from server");
                $state.go("app.events");
            }else if(err.status == 504){
                $flaskUtil.alert("Server response timeout");
                $state.go("app.events");
            }else{
                $state.go("app.events");
            }
        }

        return services;

    }
})();