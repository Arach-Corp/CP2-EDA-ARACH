package br.com.fiap.entities;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "T_SMK_PRODUTO_DISPENSA")
@SequenceGenerator(name = "prodDisp", sequenceName = "SEQ_T_SMK_PROD_DISP", allocationSize = 1)
public class ItemDispensa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodDisp")
    @Column(name = "id_produto_dispensa")
    private Long id;

    @Column(name = "nr_quantidade")
    private Integer quantidade;

    @Column(name = "bl_ativo")
    private boolean ativo;

    @CreationTimestamp
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;


    @Column(name = "dt_retirada")
    private LocalDateTime dataRetirada;

    @ManyToOne
    @JoinColumn(name="lote_id")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name="dispositivo_id")
    private Dispositivo dispositivo;


    public ItemDispensa(Long id, Integer quantidade, boolean ativo, Lote lote, Dispositivo dispositivo) {
        this.id = id;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.lote = lote;
        this.dispositivo = dispositivo;
    }


    public ItemDispensa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public String toString() {
        return "ProdutoDispensa{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", ativo=" + ativo +
                ", dataCadastro=" + dataCadastro +
                ", dataRetirada=" + dataRetirada +
                '}';
    }
}
