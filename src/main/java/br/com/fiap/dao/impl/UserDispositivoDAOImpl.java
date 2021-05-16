package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.UserDispositivoDAO;
import br.com.fiap.entities.UserDispositivo;

import javax.persistence.EntityManager;

public class UserDispositivoDAOImpl extends DAO<UserDispositivo, Long> implements UserDispositivoDAO {
    public UserDispositivoDAOImpl(EntityManager em) {
        super(em);
    }
}
