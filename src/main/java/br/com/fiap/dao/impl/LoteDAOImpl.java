package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.LoteDAO;
import br.com.fiap.entities.Lote;

import javax.persistence.EntityManager;

public class LoteDAOImpl extends DAO<Lote, Long> implements LoteDAO {
    public LoteDAOImpl(EntityManager em) {
        super(em);
    }
}
