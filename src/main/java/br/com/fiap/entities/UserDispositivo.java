package br.com.fiap.entities;

import br.com.fiap.entities.pk.UserDispositivoPK;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_SMK_USER_DISPOSITIVO")
public class UserDispositivo {

    @EmbeddedId
    private UserDispositivoPK id;

    @Column(name = "bl_principal")
    private boolean principal;

    @CreationTimestamp
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dataCadastro;


    public UserDispositivoPK getId() {
        return id;
    }

    public void setId(UserDispositivoPK id) {
        this.id = id;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Dispositivo getDispositivo(){
        return getId().getDispositivo();
    }

    public void setDispositivo(Dispositivo dispositivo){
        getId().setDispositivo(dispositivo);
    }

    public Usuario getUser(){
        return getId().getUser();
    }

    public void setUser(Usuario user){
        getId().setUser(user);
    }


}
