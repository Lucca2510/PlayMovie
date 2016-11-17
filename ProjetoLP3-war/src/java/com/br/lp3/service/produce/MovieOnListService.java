/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.service.produce;

import com.br.lp3.model.dao.MovieonlistDAO;
import com.br.lp3.model.entities.Movieonlist;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author lgd25
 */
@Path("/movieonlistservice")
public class MovieOnListService {
    MovieonlistDAO movieonlistDAO = lookupMovieonlistDAOBean();
    
    
    @GET
    @Produces("application/xml")
    public List<Movieonlist> getAll(){
        return movieonlistDAO.read();
    }
    
    @GET
    @Produces("application/xml")
    @Path("/{id}")
    public Movieonlist getById(@PathParam("id")long id){
        return movieonlistDAO.readById(id);
    }
    
    
    
    private MovieonlistDAO lookupMovieonlistDAOBean() {
        try {
            Context c = new InitialContext();
            return (MovieonlistDAO) c.lookup("java:global/ProjetoLP3/ProjetoLP3-ejb/MovieonlistDAO!com.br.lp3.model.dao.MovieonlistDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
    
}
