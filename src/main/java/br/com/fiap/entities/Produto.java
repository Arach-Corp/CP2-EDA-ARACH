package br.com.fiap.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "T_SMK_PRODUTO")
@SequenceGenerator(name = "produto", sequenceName = "SEQ_T_SMK_PRODUTO", allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nm_produto", nullable = false, length = 40)
    private String nome;

    @Column(name = "ds_produto", nullable = false, length = 200)
    private String descricao;

    @Column(name = "ds_marca", nullable = false, length = 40)
    private String marca;

    @Column(name = "dt_cadastro", updatable = false)
    @CreationTimestamp
    private LocalDate dataCadastro;

    @Column(name = "url_foto", length = 128)
    private String urlFoto;


    @OneToOne(mappedBy = "produto")
    private InformacaoNutricional informacaoNutricional;

    @OneToMany(mappedBy = "produto")
    private List<Lote> lotes = new ArrayList<>();

    public Produto(Long id, String nome, String descricao, String marca, String urlFoto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.urlFoto = urlFoto;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public InformacaoNutricional getInformacaoNutricional() {
        return informacaoNutricional;
    }

    public void setInformacaoNutricional(InformacaoNutricional informacaoNutricional) {
        this.informacaoNutricional = informacaoNutricional;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
