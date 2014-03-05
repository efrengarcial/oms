define(["angular", "services"], function (angular, services) {

    services.factory('UserService', [ function () {
            var sdo = {
                isLogged: false,
                userSession: null
            };
            return sdo;
        }
    ]);
});