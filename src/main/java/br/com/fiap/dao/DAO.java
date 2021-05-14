package br.com.fiap.dao;

import br.com.fiap.dao.exceptions.CommitException;
import br.com.fiap.dao.exceptions.EntityNotFoundException;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

// Generic DAO Implement
public abstract class DAO<E, K> implements GenericDAO<E, K> {
    private EntityManager em;
    private Class<E> clazz;


    public DAO(EntityManager em){
        this.em= em;
        this.clazz = ((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }


    @Override
    public void update(E entity) {
        em.merge(entity);
    }

    @Override
    public void insert(E entity) {
        em.persist(entity);
    }

    @Override
    public E getByID(K id) throws EntityNotFoundException {
        E entity = em.find(clazz, id);
        if (entity != null) return entity;
        throw new EntityNotFoundException("Nenhum resultado encontrado para o ID: " + id);
    }

    @Override
    public void delete(K id) throws EntityNotFoundException {
        em.remove(getByID(id));
    }

    @Override
    public void commit() throws CommitException {
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new CommitException(e.getMessage());
        }
    }
}
