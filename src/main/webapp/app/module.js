(function () {
  angular.module('app', ['ui.router', 'ui.utils.masks']);

  angular.module('app')
    .config(AppConfig);

  AppConfig.$inject = ['$stateProvider'];

  function AppConfig($stateProvider) {

    $stateProvider
      .state({
        name: 'clienteList',
        url: '/clientes',
        templateUrl: '/app/cliente/cliente-list/cliente-list.html',
        controller: 'ClienteListController',
        controllerAs: 'vm'
      })
      .state({
        name: 'clienteNovo',
        url: '/clientes/novo',
        templateUrl: '/app/cliente/cliente-cad/cliente-cad.html',
        controller: 'ClienteCadController',
        controllerAs: 'vm'
      })
      .state({
        name: 'clienteEditar',
        url: '/clientes/{id}',
        templateUrl: '/app/cliente/cliente-cad/cliente-cad.html',
        controller: 'ClienteCadController',
        controllerAs: 'vm'
      })

  }
})();