/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Movieonlist;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author lgd25
 */
@Stateful
@LocalBean
public class MovieonlistDAO implements GenericDAO<Movieonlist>{
    @PersistenceContext(unitName = "ProjetoLP3-ejbPU", type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    @Override
    public void create(Movieonlist e) {
        em.persist(e);
    }

    @Override
    public List<Movieonlist> read() {
        Query query = em.createNamedQuery("Movieonlist.findAll",Movieonlist.class);
        return query.getResultList();
    }

    @Override
    public Movieonlist readById(long id) {
        return em.find(Movieonlist.class, id);
    }

    @Override
    public void update(Movieonlist e) {
        em.merge(e);
    }

    @Override
    public void delete(Movieonlist e) {
        em.merge(e);
        em.remove(e);
    }
}
