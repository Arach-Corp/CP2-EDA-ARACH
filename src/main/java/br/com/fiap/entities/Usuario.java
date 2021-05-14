package br.com.fiap.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_SMK_USER")
@SequenceGenerator(name = "usuario", sequenceName = "SEQ_T_SMK_USER", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @Column(name = "id_user")
    private Long id;

    @Column(name = "ds_nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "ds_email", nullable = false, length = 60)
    private String email;

    @Column(name = "ds_password", nullable = false)
    private String password;

    @Column(name = "dt_cadastro")
    @CreationTimestamp
    private LocalDateTime cadastro;

    @Column(name = "url_foto", length = 128)
    private String urlFoto;

    
    @OneToMany(mappedBy = "usuario")
    private List<Notificacao> notificacoes = new ArrayList<>();

    @OneToMany(mappedBy = "id.user")
    private List<UserDispositivo> dispositivos = new ArrayList<>();



    public Usuario() { }
    
    public Usuario(Long id, String nome, String email, String password, String urlFoto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.urlFoto = urlFoto;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDateTime cadastro) {
        this.cadastro = cadastro;
    }

    public String geturlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public List<UserDispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<UserDispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cadastro=" + cadastro +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
