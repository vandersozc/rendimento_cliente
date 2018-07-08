package com.vandersoncamp.rendimento.model;import javax.persistence.*;import javax.validation.constraints.Max;import javax.validation.constraints.NotNull;import javax.validation.constraints.Size;import java.math.BigDecimal;import java.util.List;/** * Classe de modelo para persistência dos dados do cliente * @author vanderson.campanholi * EntityID utilizada para retornar o id das classes de modelo */@Entity@Table(name = "CLIENTES")@SequenceGenerator(name = "SEQ_CLIENTES", sequenceName = "SEQ_CLIENTES", initialValue = 1, allocationSize = 1)public class Cliente implements EntityID {    @Id    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTES")    private Long id;    @NotNull(message = "{Cliente.nome.NotNull}")    @Size(max = 100, message = "{Cliente.nome.Size}")    @Column(name = "NOME", length = 100, nullable = false)    private String nome;    @NotNull(message = "{Cliente.rendimentoMensal.NotNull}")    @Column(name = "RENDIMENTO_MENSAL", nullable = false, precision = 14, scale = 3)    private BigDecimal rendimentoMensal;    @NotNull(message = "{Cliente.risco.NotNull}")    @Column(name = "RISCO", nullable = false)    @Enumerated(EnumType.STRING)    private RiscoEnum risco;    @JoinColumn(name = "ID_ENDERECO")    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)    private List<Endereco> enderecos;    @Override    public Long getId() {        return id;    }    public void setId(Long id) {        this.id = id;    }    public String getNome() {        return nome;    }    public void setNome(String nome) {        this.nome = nome;    }    public BigDecimal getRendimentoMensal() {        return rendimentoMensal;    }    public void setRendimentoMensal(BigDecimal rendimentoMensal) {        this.rendimentoMensal = rendimentoMensal;    }    public RiscoEnum getRisco() {        return risco;    }    public void setRisco(RiscoEnum risco) {        this.risco = risco;    }    public List<Endereco> getEnderecos() {        return enderecos;    }    public void setEnderecos(List<Endereco> enderecos) {        this.enderecos = enderecos;    }}