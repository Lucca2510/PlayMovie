/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Thumbup;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author lgd25
 */
public class ThumbupDAO implements GenericDAO<Thumbup>{
     @PersistenceContext(unitName = "ProjetoLP3-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void create(Thumbup e) {
        em.persist(e);
    }

    @Override
    public List<Thumbup> read() {
        Query query = em.createNamedQuery("Thumbup.findAll");
        return query.getResultList();
    }

    @Override
    public Thumbup readById(long id) {
        return em.find(Thumbup.class, id);
    }

    @Override
    public void update(Thumbup e) {
        em.merge(e);
    }

    @Override
    public void delete(Thumbup e) {
        em.merge(e);
        em.remove(e);
    }
    
}
