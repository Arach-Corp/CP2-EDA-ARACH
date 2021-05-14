package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.NotificacaoDAO;
import br.com.fiap.entities.Notificacao;

import javax.persistence.EntityManager;

public class NotificacaoDAOImpl extends DAO<Notificacao, Long> implements NotificacaoDAO {
    public NotificacaoDAOImpl(EntityManager em) {
        super(em);
    }
}
