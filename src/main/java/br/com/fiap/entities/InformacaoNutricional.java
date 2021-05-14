package br.com.fiap.entities;

import javax.persistence.*;

@Entity
@Table(name = "T_SMK_INFO_NUTRI")
@SequenceGenerator(name = "infoNutri", sequenceName = "SEQ_T_SMK_INFO_NUTRI", allocationSize = 1)
public class InformacaoNutricional {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "infoNutri")
    @Column(name = "id_info_nutri")
    private Long id;

    @Column(name = "ds_porcao", length = 20)
    private String porcao;

    @Column(name = "ds_carboidratos", length = 20)
    private String carboidratos;

    @Column(name = "ds_proteinas", length = 20)
    private String proteinais;

    @Column(name = "ds_gordura_totais", length = 20)
    private String gordurasTotais;

    @Column(name = "ds_gordura_saturadas", length = 20)
    private String gordurasSaturadas;

    @Column(name = "ds_gorduras_trans", length = 20)
    private String gorduraTrans;

    @Column(name = "ds_sodio", length = 20)
    private String sodio;

    @Column(name = "ds_fibra_alimentar", length = 20)
    private String fibraAlimentar;

    @OneToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public InformacaoNutricional() {
    }

    public InformacaoNutricional(Long id, String porcao, String carboidratos, String proteinais, String gordurasTotais, String gordurasSaturadas, String gorduraTrans, String sodio, String fibraAlimentar, Produto produto) {
        this.id = id;
        this.porcao = porcao;
        this.carboidratos = carboidratos;
        this.proteinais = proteinais;
        this.gordurasTotais = gordurasTotais;
        this.gordurasSaturadas = gordurasSaturadas;
        this.gorduraTrans = gorduraTrans;
        this.sodio = sodio;
        this.fibraAlimentar = fibraAlimentar;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPorcao() {
        return porcao;
    }

    public void setPorcao(String porcao) {
        this.porcao = porcao;
    }

    public String getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(String carboidratos) {
        this.carboidratos = carboidratos;
    }

    public String getProteinais() {
        return proteinais;
    }

    public void setProteinais(String proteinais) {
        this.proteinais = proteinais;
    }

    public String getGordurasTotais() {
        return gordurasTotais;
    }

    public void setGordurasTotais(String gordurasTotais) {
        this.gordurasTotais = gordurasTotais;
    }

    public String getGordurasSaturadas() {
        return gordurasSaturadas;
    }

    public void setGordurasSaturadas(String gordurasSaturadas) {
        this.gordurasSaturadas = gordurasSaturadas;
    }

    public String getGorduraTrans() {
        return gorduraTrans;
    }

    public void setGorduraTrans(String gorduraTrans) {
        this.gorduraTrans = gorduraTrans;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }

    public String getFibraAlimentar() {
        return fibraAlimentar;
    }

    public void setFibraAlimentar(String fibraAlimentar) {
        this.fibraAlimentar = fibraAlimentar;
    }




    @Override
    public String toString() {
        return "InformacaoNutricional{" +
                "id=" + id +
                ", porcao='" + porcao + '\'' +
                ", carboidratos='" + carboidratos + '\'' +
                ", proteinais='" + proteinais + '\'' +
                ", gordurasTotais='" + gordurasTotais + '\'' +
                ", gordurasSaturadas='" + gordurasSaturadas + '\'' +
                ", gorduraTrans='" + gorduraTrans + '\'' +
                ", sodio='" + sodio + '\'' +
                ", fibraAlimentar='" + fibraAlimentar + '\'' +
                '}';
    }
}
