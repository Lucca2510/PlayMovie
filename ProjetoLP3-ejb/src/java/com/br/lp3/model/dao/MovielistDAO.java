/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Movielist;
import com.br.lp3.model.entities.Userproj;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author 31520731
 */
@Stateful
@LocalBean
public class MovielistDAO implements GenericDAO<Movielist>{
    @PersistenceContext(unitName = "ProjetoLP3-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public void create(Movielist e) {
        em.persist(e);
    }

    @Override
    public List<Movielist> read() {
        Query query = em.createNamedQuery("Movielist.findAll",Movielist.class);
        return query.getResultList();
    }
    
   
    
    @Override
    public Movielist readById(long id) {
        return em.find(Movielist.class, id);
    }
    
    

    @Override
    public void update(Movielist e) {
        em.merge(e);
    }

    @Override
    public void delete(Movielist e) {
        em.merge(e);
        em.remove(e);
    }
    
    
}
