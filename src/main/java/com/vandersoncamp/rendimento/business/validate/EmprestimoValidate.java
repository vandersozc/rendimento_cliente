package com.vandersoncamp.rendimento.business.validate;import com.vandersoncamp.rendimento.model.Cliente;import javax.enterprise.context.RequestScoped;@RequestScopedpublic class EmprestimoValidate {    public void validate(Cliente cliente) {//        if (cliente.getDue_date() == null) {//            throw new BusinessException("Não foi informada a data de vencimento do cliente");//        }////        if (cliente.getTotal_in_cents() == null) {//            throw new BusinessException("Não foi informado valor para o cliente");//        }////        if (cliente.getCustomer() == null) {//            throw new BusinessException("Não foi informado o pagador do cliente");//        }////        if (cliente.getStatus() == null) {//            throw new BusinessException("Não foi informada a situação do cliente");//        }////        if (cliente.getId() == null) {//            throw new BusinessException("Identificador do cliente não pode ser nulo");//        }////        if (cliente.getId().length() != 36) {//            throw new BusinessException("Identificador do cliente incorreto");//        }    }}