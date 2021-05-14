package br.com.fiap.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="T_SMK_DISPOSITIVOS")
@SequenceGenerator(name = "dispositivo", sequenceName = "SEQ_T_SMK_DISPOSITIVOS", allocationSize = 1)
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dispositivo")
    @Column(name = "id_dispositivo")
    private Long id;

    @Column(name = "ds_dispositivo", nullable = false, length = 50)
    private String descricao;

    @Column(name = "ds_key", nullable = false, length = 64)
    private String key;

    @Column(name = "dt_cadastro")
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "id.dispositivo")
    private List<UserDispositivo> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "dispositivo")
    private List<ItemDispensa> itemsDispensa = new ArrayList<>();



    public Dispositivo() {
    }

    public Dispositivo(Long id, String descricao, String key) {
        this.id = id;
        this.descricao = descricao;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<UserDispositivo> getUsuarios() {
        return usuarios;
    }

    public List<ItemDispensa> getItemsDispensa() {
        return itemsDispensa;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", key='" + key + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

}
