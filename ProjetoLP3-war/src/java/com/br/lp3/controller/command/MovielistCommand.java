/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

import com.br.lp3.model.dao.MovielistDAO;
import com.br.lp3.model.dao.MovieonlistDAO;
import com.br.lp3.model.dao.UserprojDAO;
import com.br.lp3.model.entities.Movie;
import com.br.lp3.model.entities.Movielist;
import com.br.lp3.model.entities.Movieonlist;
import com.br.lp3.model.entities.Userproj;
import java.util.List;
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
public class MovielistCommand implements Command {
    MovieonlistDAO movieonlistDAO = lookupMovieonlistDAOBean();

    UserprojDAO userprojDAO = lookupUserprojDAOBean();
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
        switch (action) {
            case "newMovielist":
                Userproj u = (Userproj) request.getSession().getAttribute("user");
                Movielist mvlist = new Movielist();
                String mvname = request.getParameter("mvname");
                mvlist.setName(mvname);
                mvlist.setFkUser(u);

                u.getMovielistCollection().add(mvlist);
                movielistDAO.create(mvlist);
                userprojDAO.update(u);
                request.getSession().setAttribute("user", u);
                List<Movielist> movielistsbyuser= movielistDAO.readByUser((Userproj)request.getSession().getAttribute("user"));
                 request.getSession().setAttribute("movielistsbyuser", movielistsbyuser);
                responsePage = "myMovieLists.jsp";
                break;

            case "showLists":

                Userproj u2 = (Userproj) request.getSession().getAttribute("user");
                request.getSession().setAttribute("lists", u2.getMovielistCollection());

                break;

            case "viewmovielist":

                long id_movielist = Long.parseLong(request.getParameter("id_movielist"));
                Movielist m = movielistDAO.readById(id_movielist);
                request.getSession().setAttribute("selectedmovielist", m);
                responsePage = "selectedMovieList.jsp";

                break;

            case "deletemovielist":
                long id_movielist2 = Long.parseLong(request.getParameter("id_movielist"));
                Movielist m2 = movielistDAO.readById(id_movielist2);
                movielistDAO.delete(m2);
                Userproj uaux3 = (Userproj)request.getSession().getAttribute("user");
                Userproj u3 = userprojDAO.readById(uaux3.getIdUserproj());
                request.getSession().setAttribute("user", u3);               
                responsePage = "Controller?command=Movielist.getByUser";
                break;
                
            case "getAll":
                
                List<Movielist> movielists= movielistDAO.read();
                 request.getSession().setAttribute("allmovielists", movielists);
                responsePage = "home.jsp";
                
                break;
                
            case "getByUser":
                
                 List<Movielist> movielistsbyuser2= movielistDAO.readByUser((Userproj)request.getSession().getAttribute("user"));
                 request.getSession().setAttribute("movielistsbyuser", movielistsbyuser2);
                responsePage = "myMovieLists.jsp";
                
                break;
                
            case "addMovie":
                
                Movie m3 = (Movie)request.getSession().getAttribute("selectedMovie");
                request.getSession().setAttribute("movieforplaylist", m3);
                 List<Movielist> movielistsbyuser3= movielistDAO.readByUser((Userproj)request.getSession().getAttribute("user"));
                 request.getSession().setAttribute("movielistsbyuser", movielistsbyuser3);
                responsePage = "selectPlaylistForMovie.jsp";
                
                break;
            
            case "addMovieToList":
                
                
                Movie m4 =(Movie)request.getSession().getAttribute("selectedMovie");
                long id_list = Long.parseLong(request.getParameter("id_movielist"));
                Movielist m5 = movielistDAO.readById(id_list);
                
                Movieonlist mvon = new Movieonlist();
                mvon.setFkMovie(m4.getImdbID());
                mvon.setFkMovielist(m5);
                m5.getMovieonlistCollection().add(mvon);
                movielistDAO.update(m5);
                
               
                request.getSession().setAttribute("movielistsbyuser", movielistDAO.readById(id_list));
                request.getSession().setAttribute("allmovielists", movielistDAO.read());
                request.getSession().setAttribute("user", userprojDAO.readById(m5.getFkUser().getIdUserproj()));
                request.getSession().setAttribute("success", "Movie added with success!");
                responsePage = "home.jsp";
                
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
