(function () {
  'use strict'

  angular.module('app')
    .controller('ClienteCadController', ClienteCadController);

    ClienteCadController.$inject = [
      'ClienteService',
      '$state',
      '$stateParams',
      'DialogBuilder'
  ];

  function ClienteCadController(ClienteService, $state, $stateParams, DialogBuilder) {

      var vm = this;
      vm.cadastro = {
         enderecos: []
      };

      vm.error = {};
      vm.salvar = salvar;
      vm.itemOriginal = null;
      vm.itemLista = {};

      vm.excluirEndereco = excluirEndereco;
      vm.editarEndereco = editarEndereco;
      vm.salvarEndereco = salvarEndereco;
      vm.novoEndereco = novoEndereco;
      vm.alteraRisco = alteraRisco;

      if ($stateParams.id) {
        ClienteService.findById($stateParams.id)
          .then(function (data) {
              vm.cadastro = data;
              vm.cadastro.enderecos = vm.cadastro.enderecos || [];
          });
      }

      function salvar() {
          if (!vm.cadastro.id) {
            ClienteService.insert(vm.cadastro)
                .then(function (dado) {
                    DialogBuilder.message('Registro incluído com sucesso!');
                    $state.go('clienteList');
                })
                .catch(function (error) {
                    vm.error = error.data;
                });
          } else {
            ClienteService.update(vm.cadastro)
              .then(function (dado) {
                  DialogBuilder.message('Registro alterado com sucesso!');
                  $state.go('clienteList');
              })
              .catch(function (error) {
                  vm.error = error.data;
              });
          } 
      }

      function novoEndereco() {
          vm.itemOriginal = null;
          vm.itemLista = {};
      }

      function editarEndereco(item) {
          vm.itemOriginal = item;
          angular.copy(item, vm.itemLista);
      }

      function salvarEndereco() {
          var index = vm.cadastro.enderecos.indexOf(vm.itemOriginal);
          if (index != -1) {
              vm.cadastro.enderecos[index] = vm.itemLista;
          } else {
              vm.cadastro.enderecos.push(vm.itemLista);
          }
          vm.itemOriginal = null;
          vm.itemLista = {};
          $('#formEndereco').modal('hide');
      }

      function excluirEndereco(item) {
          var index = vm.cadastro.enderecos.indexOf(item);
          vm.cadastro.enderecos.splice(index, 1);
      }

      function alteraRisco() {
          if (vm.cadastro.rendimentoMensal) {
              var rendimento = vm.cadastro.rendimentoMensal;
              if (rendimento <= 2000) {
                vm.cadastro.risco = 'C';
              } else if (rendimento > 2000 && rendimento <= 8000) {
                vm.cadastro.risco = 'B';
              } else {
                vm.cadastro.risco = 'A';
              }
          }
      }
  }
})();