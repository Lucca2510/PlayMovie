/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

import com.br.lp3.model.dao.MovielistDAO;
import com.br.lp3.model.dao.ThumbupDAO;
import com.br.lp3.model.entities.Movielist;
import com.br.lp3.model.entities.Thumbup;
import com.br.lp3.model.entities.Userproj;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lgd25
 */
public class ThumbupCommand implements Command {
    ThumbupDAO thumbupDAO = lookupThumbupDAOBean();
    MovielistDAO movielistDAO = lookupMovielistDAOBean();
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsePage = "error.jsp";
    
    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("command").split("\\.")[1];
        switch(action){
            case "likelist":
                Thumbup t = new Thumbup();
                Userproj u = (Userproj)request.getSession().getAttribute("user");
                
                Movielist mv = (Movielist)request.getSession().getAttribute("selectedmovielist");
                
                t.setFkUser(u);
                t.setFkMovielist(mv);
                thumbupDAO.create(t);
                mv.getThumbupCollection().add(t);
                movielistDAO.update(mv);
                
                request.getSession().setAttribute("selectedmovielist", mv);
                responsePage="selectedMovieList.jsp";
                break;
        }
    }

    @Override
    public String getResponsePage() {
        return responsePage;
    }

    private MovielistDAO lookupMovielistDAOBean() {
        try {
            Context c = new InitialContext();
            return (MovielistDAO) c.lookup("java:global/ProjetoLP3/ProjetoLP3-ejb/MovielistDAO!com.br.lp3.model.dao.MovielistDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ThumbupDAO lookupThumbupDAOBean() {
        try {
            Context c = new InitialContext();
            return (ThumbupDAO) c.lookup("java:global/ProjetoLP3/ProjetoLP3-ejb/ThumbupDAO!com.br.lp3.model.dao.ThumbupDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
