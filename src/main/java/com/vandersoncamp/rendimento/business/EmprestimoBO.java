package com.vandersoncamp.rendimento.business;import com.vandersoncamp.rendimento.model.Cliente;import java.math.BigDecimal;public class EmprestimoBO {    private Cliente cliente;    private BigDecimal valorSolicitado;    private Long meses;    private BigDecimal valorSimulacao;    public Cliente getCliente() {        return cliente;    }    public void setCliente(Cliente cliente) {        this.cliente = cliente;    }    public BigDecimal getValorSolicitado() {        return valorSolicitado;    }    public void setValorSolicitado(BigDecimal valorSolicitado) {        this.valorSolicitado = valorSolicitado;    }    public Long getMeses() {        return meses;    }    public void setMeses(Long meses) {        this.meses = meses;    }    public BigDecimal getValorSimulacao() {        return valorSimulacao;    }    public void setValorSimulacao(BigDecimal valorSimulacao) {        this.valorSimulacao = valorSimulacao;    }}