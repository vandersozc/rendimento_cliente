package com.vandersoncamp.rendimento.business;import com.vandersoncamp.rendimento.business.validate.ClienteStatusValidate;import com.vandersoncamp.rendimento.business.validate.ClienteValidate;import com.vandersoncamp.rendimento.model.Cliente;import com.vandersoncamp.rendimento.service.ClienteService;import javax.enterprise.context.RequestScoped;import javax.inject.Inject;import java.math.BigDecimal;import java.time.LocalDate;import java.time.temporal.ChronoUnit;import java.util.List;import java.util.UUID;@RequestScopedpublic class ClienteBusiness {    @Inject    private ClienteService service;    @Inject    private ClienteValidate clienteValidate;    @Inject    private ClienteStatusValidate clienteStatusValidate;    private static final Integer CEM = 100;    public Cliente find(Long id) {        Cliente cliente = service.find(id);        //BigDecimal valorAtualizado;        //valorAtualizado = calculaValorBoleto(cliente);        //cliente.setTotal_in_cents(valorAtualizado);        return cliente;    }    public List<Cliente> findAll(String filterField, String filterData, String order) {        return service.findAll(filterField, filterData, order);    }    public Cliente create(Cliente cliente) {        //cliente.setId(generateHashId());        clienteValidate.validate(cliente);        return service.create(cliente);    }    public Cliente update(Long id, Cliente cliente) {        Cliente clienteSave = service.find(id);        clienteValidate.validate(clienteSave);        //clienteStatusValidate.validate(clienteSave, cliente.getStatus());        //clienteSave.setStatus(cliente.getStatus());        return service.update(clienteSave);    }//    private BigDecimal calculaValorBoleto(Cliente cliente) {//        BigDecimal valorJuros = BigDecimal.ZERO;//        if (cliente.getDue_date().isBefore(LocalDate.now())) {//            valorJuros = getValorMulta(cliente);//        }//        return cliente.getTotal_in_cents().add(valorJuros);//    }//    private BigDecimal getValorMulta(Cliente cliente) {//        BigDecimal valorBoleto = cliente.getTotal_in_cents();//        if (getdiferencaDias(cliente.getDue_date()) > 10) {//            return valorBoleto.multiply(BigDecimal.ONE.divide(BigDecimal.valueOf(CEM)));//        }//        return valorBoleto.multiply(BigDecimal.valueOf(0.5).divide(BigDecimal.valueOf(CEM)));//    }//    private Long getdiferencaDias(LocalDate dataVencimento) {//        return ChronoUnit.DAYS.between(dataVencimento, LocalDate.now());//    }}