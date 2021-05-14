package br.com.fiap.entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;

@Entity
@Table(name = "T_SMK_NOTIFICACAO")
@SequenceGenerator(name= "notificacao", sequenceName = "SEQ_T_SMK_NOTIFICACAO", allocationSize = 1)
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificacao")
    @Column(name = "id_notificacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Usuario usuario;

    @Column(name = "ds_titulo", nullable = false, length = 80)
    private String titulo;

    @Column(name = "ds_mensagem", nullable = false)
    private String mensagem;

    @Column(name = "dt_notificacao", updatable = false)
    @CreationTimestamp
    private LocalDateTime dataNotificacao;


    public Notificacao(Long id, Usuario usuario, String titulo, String mensagem) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public Notificacao() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(LocalDateTime dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }
}



