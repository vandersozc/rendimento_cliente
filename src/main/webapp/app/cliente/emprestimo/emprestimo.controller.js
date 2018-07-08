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
      vm.emprestimo = {};

      vm.simularEmprestimo = simularEmprestimo;

      if ($stateParams.id) {
        ClienteService.findById($stateParams.id)
          .then(function (cliente) {
            vm.emprestimo.cliente = cliente;
          });
      }

      function simularEmprestimo() {
        ClienteService.simularEmprestimo(vm.emprestimo).then(function (data) {
          vm.emprestimo = data;
        })
      }
  }
})();