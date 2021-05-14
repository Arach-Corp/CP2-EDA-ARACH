package br.com.fiap.dao.impl;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.generic.UsuarioDAO;
import br.com.fiap.entities.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDAOImpl extends DAO<Usuario, Long> implements UsuarioDAO {
    public UsuarioDAOImpl(EntityManager em) {
        super(em);
    }
}
