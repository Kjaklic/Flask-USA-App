
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
            unBlockUser : unBlockUser
        }
        var url = SERVER.url;
        var searchMyFriend = "/flask-social-portlet.entry/search-my-friends";
        var searchFriendById = "/flask-social-portlet.entry/get-user-by-id"
        var searchUserContactPath = '/flask-social-portlet.entry/search-users-and-contacts';
        var sendFlaskMessage = "/flask-social-portlet.flaskmessages/send-flask-message";
        var blockUserPath = "/flask-social-portlet.entry/block-user";
        var unFriendPath = "/flask-social-portlet.entry/delete-social-relation";
        var addFriendsPath  ="/flask-social-portlet.entry/request-social-relation";
        var unBlockUserPath = "/flask-social-portlet.entry/unblock-user";
        var companyId = SERVER.companyId;
         function getMyFriends(searchText) {
                    return $http.get(url+searchMyFriend,{params:{
                        companyId: companyId,
                        keywords: searchText
                    }})
                    .then(function success(response) {
                        return response.data;
                    }, function failure(response) {
                        return $q.$inject(response);
                        //add errror handling 
                    });
        }
        function searchUserContact(keyword, start, end) {
                    return $http.get(url+searchUserContactPath,{params:{
                        companyId: companyId,
                        keywords: keyword,
                        start:start,
                        end:end
                    }})
                    .then(function success(response) {
                        return response.data;
                    }, function failure(response) {
                        return $q.$inject(response);
                        //add errror handling 
                    });
        }
        function getFriendByUserId(userId) {
                return $http.get(url+searchFriendById,{params:{
                    userId: userId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling 
                });
        }

        function sendMessage (userId,messgae,sendEmail) {
                return $http.get(url+sendFlaskMessage,{params:{
                    recipients: userId,
                    message:messgae,
                    sendEmail:sendEmail
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling 
                });
        }
        function blockUser(blockUserId) {
                return $http.get(url+blockUserPath,{params:{
                    blockUserId: blockUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling 
                });
        }
        function unFriend(receiverUserId) {
                return $http.get(url+unFriendPath,{params:{
                    receiverUserId: receiverUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling 
                });
        }

        function sendFriendRequest (receiverUserId) {
                return $http.get(url+addFriendsPath,{params:{
                    receiverUserId: receiverUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling 
                });
        }
        function unBlockUser (unblockUserId) {
                return $http.get(url+unBlockUserPath,{params:{
                    unblockUserId: unblockUserId
                }})
                .then(function success(response) {
                    return response.data;
                }, function failure(response) {
                    return $q.$inject(response);
                    //add errror handling 
                });
        }

return services;

    }
})();