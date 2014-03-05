define(["angular", "services"], function (angular, services) {

    services.factory('Usuario', ['$resource',
        function ($resource) {
            var Usuario = $resource('/api/usuario/AutorizarUsuario', {},
                {
                    update: { method: 'POST'}
                });
            return Usuario;
        }
    ]);
});