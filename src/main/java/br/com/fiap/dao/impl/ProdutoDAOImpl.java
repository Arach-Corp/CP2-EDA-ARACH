package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.ProdutoDAO;
import br.com.fiap.entities.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAOImpl extends DAO<Produto, Long> implements ProdutoDAO {
    public ProdutoDAOImpl(EntityManager em) {
        super(em);
    }
}
