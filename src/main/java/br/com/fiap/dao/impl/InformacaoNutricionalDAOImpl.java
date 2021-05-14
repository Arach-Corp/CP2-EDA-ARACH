package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.InformacaoNutricionalDAO;
import br.com.fiap.entities.InformacaoNutricional;

import javax.persistence.EntityManager;

public class InformacaoNutricionalDAOImpl extends DAO<InformacaoNutricional, Long> implements InformacaoNutricionalDAO {
    public InformacaoNutricionalDAOImpl(EntityManager em) {
        super(em);
    }
}
