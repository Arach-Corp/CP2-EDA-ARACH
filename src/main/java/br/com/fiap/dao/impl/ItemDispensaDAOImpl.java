package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.ItemDispensaDAO;
import br.com.fiap.entities.ItemDispensa;

import javax.persistence.EntityManager;

public class ItemDispensaDAOImpl extends DAO<ItemDispensa, Long> implements ItemDispensaDAO {
    public ItemDispensaDAOImpl(EntityManager em) {
        super(em);
    }
}
