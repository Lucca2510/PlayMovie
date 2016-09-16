/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.dao;

import com.br.lp3.model.entities.Userinfo;
import com.br.lp3.model.entities.Userproj;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author lgd25
 */
@Stateful
@LocalBean
public class UserprojDAO implements GenericDAO<Userproj> {

    @PersistenceContext(unitName = "ProjetoLP3-ejbPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public void create(Userproj e) {
        em.persist(e);
    }

    @Override
    public List<Userproj> read() {
        Query query = em.createNamedQuery("Userproj.findAll", Userproj.class);
        return (List<Userproj>) query.getResultList();

    }

    @Override
    public Userproj readById(long id) {
        return em.find(Userproj.class, id);
    }

    public Userproj readByUsername(String username) {
        Query query = em.createNamedQuery("Userproj.findByUsername", Userproj.class).setParameter("username", username);

        try {
            return (Userproj) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Userproj readByEmail(String email) {
        Query query = em.createNamedQuery("Userinfo.findByEmail", Userinfo.class).setParameter("email", email);
        try {
            return ((Userinfo) query.getSingleResult()).getUserproj();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void update(Userproj e
    ) {
        em.merge(e);
    }

    @Override
    public void delete(Userproj e
    ) {
        em.merge(e);
        em.remove(e);
    }

}
