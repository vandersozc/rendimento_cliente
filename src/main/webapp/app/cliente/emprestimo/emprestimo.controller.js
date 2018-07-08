(function () {
  'use strict'

  angular.module('app')
    .controller('EmprestimoController', EmprestimoController);

    EmprestimoController.$inject = [
      'ClienteService',
      '$state',
      '$stateParams'
  ];

  function EmprestimoController(ClienteService, $state, $stateParams) {

      var vm = this;
      vm.cliente = {};

      vm.simularEmprestimo = simularEmprestimo;

      if ($stateParams.id) {
        ClienteService.findById($stateParams.id)
          .then(function (data) {
              vm.cliente = data;
          });
      }

      function simularEmprestimo() {
        console.log("dasgdhjasgdhsagjhdgjhasd");
      }
  }
})();