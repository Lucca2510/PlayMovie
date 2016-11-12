/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

import com.br.lp3.model.dao.MovielistDAO;
import com.br.lp3.model.dao.UserprojDAO;
import com.br.lp3.model.entities.Movielist;
import com.br.lp3.model.entities.Userinfo;
import com.br.lp3.model.entities.Userproj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class UserprojCommand implements Command {
    MovielistDAO movielistDAO = lookupMovielistDAOBean();

    UserprojDAO userprojDAO = lookupUserprojDAOBean();
    

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsePage = "error.jsp";
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;
    private Userproj useraux;
   

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }

    @Override
    public void execute() {
        String action = request.getParameter("command").split("\\.")[1];
        switch (action) {
            
            case "login":
                username = request.getParameter("username");
                password = request.getParameter("password");
                useraux = userprojDAO.readByUsername(username);
                if (useraux == null) {
                    request.getSession().setAttribute("error", "User not registered");

                } else if (!password.equals(useraux.getPassword())) {
                    request.getSession().setAttribute("error", "Wrong password");
                } else {
                    List<Movielist> movielists= movielistDAO.read();
                    request.getSession().setAttribute("allmovielists", movielists);
               
                    request.getSession().setAttribute("user", useraux);
                    this.responsePage = "home.jsp";
                }
                break;

            case "register":
                username = request.getParameter("username");
                password = request.getParameter("password");
                String password2 = request.getParameter("password2");
                email = request.getParameter("email");
                fullname = request.getParameter("fullname");
                phone = request.getParameter("phone");
                String bddate = request.getParameter("birthday");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                useraux = userprojDAO.readByUsername(username);
                Userproj useraux2 = userprojDAO.readByEmail(email);
                Date birthday = new Date();
                try {
                    birthday = sdf.parse(bddate);
                } catch (ParseException ex) {
                    Logger.getLogger(UserprojCommand.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (!password.equals(password2)) {
                    request.getSession().setAttribute("error", "Passwords doesn't match!");
                } else if (useraux != null) {
                    request.getSession().setAttribute("error", "Username already exists!");
                } else if (useraux2 != null) {
                    request.getSession().setAttribute("error", "This email is already registered!");
                } else {
                    Userproj usernew = new Userproj();
                    usernew.setUsername(username);
                    usernew.setPassword(password);
                    Userinfo uinew = new Userinfo();
                    uinew.setBirthday(birthday);
                    uinew.setEmail(email);
                    uinew.setFullname(fullname);
                    uinew.setPhone(phone);
                    uinew.setUserproj(usernew);
                    usernew.setUserinfo(uinew);
                    userprojDAO.create(usernew);
                    responsePage = "index.jsp";
                }

                break;
            case "logout":
                request.getSession().invalidate();
                responsePage = "index.jsp";
                break;
                
            case "update":
                
                username = request.getParameter("username");
                email = request.getParameter("email");
                fullname = request.getParameter("fullname");
                phone = request.getParameter("phone");
                String bddate2 = request.getParameter("birthday");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday2 = new Date();

                try {
                    birthday2 = sdf2.parse(bddate2);
                } catch (ParseException ex) {
                    Logger.getLogger(UserprojCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                Userproj usernew2= (Userproj)request.getSession().getAttribute("user");
                              
                usernew2.getUserinfo().setBirthday(birthday2);
                usernew2.getUserinfo().setFullname(fullname);
                usernew2.getUserinfo().setPhone(phone);
                userprojDAO.update(usernew2);
                request.getSession().setAttribute("user", usernew2);
                
                request.getSession().setAttribute("success", "Your profile has been updated");
                responsePage="home.jsp";

                break;

        }
    }

    @Override
    public String getResponsePage() {
        return responsePage;
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

    private MovielistDAO lookupMovielistDAOBean() {
        try {
            Context c = new InitialContext();
            return (MovielistDAO) c.lookup("java:global/ProjetoLP3/ProjetoLP3-ejb/MovielistDAO!com.br.lp3.model.dao.MovielistDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
