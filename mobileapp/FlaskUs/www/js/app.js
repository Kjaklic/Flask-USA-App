(function () {
    var app = angular.module('flaskApp'); 
    app.run(function ($ionicPlatform, $rootScope, $ionicLoading, $ionicPopup, $cookies, $localStorage,$state,LoginService) {
        $ionicPlatform.ready(function () {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            //  if (cordova.platformId === 'ios' && window.cordova && window.cordova.plugins.Keyboard) {
            //      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
            //      cordova.plugins.Keyboard.disableScroll(true);
            //  }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                StatusBar.styleDefault();
            }
            if($localStorage['RememberUser'] &&  $localStorage['RememberUser'].Email &&  $localStorage['RememberUser'].password){
                var user = $localStorage['RememberUser'];
                LoginService.authenticateUser(user).then(function (respData) {
                    if (respData.data.message == "Authenticated access required") {
                        $scope.Error = true;
                        $timeout(function () { $scope.Error = false; }, 3000);
                    }
                    else if (respData.data.emailAddress == "") {
                    }
                    else {
                        $cookies.putObject('CurrentUser', respData);
                        var usercookie = $cookies.getObject('CurrentUser');
                        $rootScope.userName = respData.data.firstName + respData.data.lastName;
                        $rootScope.userEmailId = respData.data.emailAddress;
                        $rootScope.show_login = true;
                        document.login_form.reset();
                        $state.go("app.user_navigation_menu");
                    }
                });
            }
            $rootScope.$on('loading:show', function () {
                $ionicLoading.show({ template: '<ion-spinner icon="spiral" class="flask-spinner"></ion-spinner>' })
            })

            $rootScope.$on('loading:hide', function () {
                $ionicLoading.hide()
            })
             $rootScope.$on('catchAll:exception', function (event, data) { 
                 $ionicLoading.hide()
                 // if exception occurs the  redirect ro events page
                $state.go("app.events");
            })
           
            //$scope.user_location_data = [];          

            //user_location_data.push({ code: "stored" });
            // Gelocation On ionic ready
            navigator.geolocation.getCurrentPosition(
                function (position) {
                    //when Success
                    // save it
                    $localStorage = $localStorage.$default({
                        things: position
                    });
                },
                function errorCallback(error) {
                    //when Error
                    //$cookies.putObject('user_location_data', error);
                }
            );
            // Check for network connection
            if (window.Connection) {
                if (navigator.connection.type == Connection.NONE) {
                    $ionicPopup.alert({
                        title: 'No Internet Connection',
                        content: 'There is no internet connection. Only some part of aplication will work'
                    });
                }
            }

        }, false);
    });
})();