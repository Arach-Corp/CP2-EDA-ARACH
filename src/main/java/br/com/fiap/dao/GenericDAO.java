package br.com.fiap.dao;


import br.com.fiap.dao.exceptions.CommitException;
import br.com.fiap.dao.exceptions.EntityNotFoundException;

// Generic DAO
public interface GenericDAO<E, K> {

    void update(E entity);

    void insert(E entity);

    E getByID(K id) throws EntityNotFoundException;

    void delete(K id) throws EntityNotFoundException;

    void commit() throws CommitException;

}
