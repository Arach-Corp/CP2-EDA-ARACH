package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.DispositivoDAO;
import br.com.fiap.entities.Dispositivo;

import javax.persistence.EntityManager;

public class DispositivoDAOImpl extends DAO<Dispositivo, Long> implements DispositivoDAO {
    public DispositivoDAOImpl(EntityManager em) {
        super(em);
    }
}
