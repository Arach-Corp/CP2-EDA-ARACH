package br.com.fiap.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "T_SMK_LOTE")
@SequenceGenerator(name = "lote", sequenceName = "SEQ_T_SMK_LOTE", allocationSize = 1)
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lote")
    @Column(name = "id_lote")
    private Long id;

    @Column(name = "dt_fabricacao", nullable = false)
    private LocalDateTime dataFabricacao;

    @Column(name = "dt_validade")
    private  LocalDateTime dataValidade;

    @Column(name = "bl_perecivel", nullable = false)
    private boolean perecivel;


    @Column(name = "dt_cadastro", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @OneToMany(mappedBy = "lote", fetch = FetchType.LAZY)
    private List<ItemDispensa> registros = new ArrayList<>();


    public Lote() {
    }

    public Lote(Long id, LocalDateTime dataFabricacao, LocalDateTime dataValidade, Boolean perecivel, Produto produto) {
        this.id = id;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.perecivel = perecivel;
        this.produto = produto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDateTime dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Boolean getPerecivel() {
        return perecivel;
    }

    public void setPerecivel(Boolean perecivel) {
        this.perecivel = perecivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", dataFabricacao=" + dataFabricacao +
                ", dataValidade=" + dataValidade +
                ", perecivel=" + perecivel +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
