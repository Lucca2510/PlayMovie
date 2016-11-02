/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

import com.br.lp3.model.dao.MovielistDAO;
import com.br.lp3.model.dao.UserprojDAO;
import com.br.lp3.model.entities.Movielist;
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
public class MovielistCommand implements Command{
    UserprojDAO userprojDAO = lookupUserprojDAOBean();
    MovielistDAO movielistDAO = lookupMovielistDAOBean();
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsePage = "error.jsp";
    

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request=request;
        this.response=response;
    }

    @Override
    public void execute() {
       String action = request.getParameter("command").split("\\.")[1];
       switch(action){
           case "newMovielist":
               Userproj u = (Userproj)request.getSession().getAttribute("user");
               Movielist mvlist = new Movielist();
               String mvname = request.getParameter("mvname");
               mvlist.setName(mvname);
               mvlist.setFkUser(u);
               
               u.getMovielistCollection().add(mvlist);
               movielistDAO.create(mvlist);
               userprojDAO.update(u);
               request.getSession().setAttribute("user", u);
               responsePage = "myMovieLists.jsp";
               break;
               
           case "showLists":
               
               Userproj u2 = (Userproj)request.getSession().getAttribute("user");
               request.getSession().setAttribute("lists",u2.getMovielistCollection());
               
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

    private UserprojDAO lookupUserprojDAOBean() {
        try {
            Context c = new InitialContext();
            return (UserprojDAO) c.lookup("java:global/ProjetoLP3/ProjetoLP3-ejb/UserprojDAO!com.br.lp3.model.dao.UserprojDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
