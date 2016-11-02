/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

import com.br.lp3.json.MovieJSONParser;
import com.br.lp3.model.entities.Movie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31520731
 */
public class MovieCommand implements Command {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String responsePage = "error.jsp";

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }

    @Override
    public void execute() {
        String action = request.getParameter("command").split("\\.")[1];
        switch (action) {
            case "searchByName":
                String movieName = request.getParameter("movieName");
                movieName = movieName.replace(" ", "+");
                String uri = "http://www.omdbapi.com/?t=" + movieName + "&y=&plot=short&r=json";
                String content = MovieJSONParser.openURL(uri);
                Movie m = MovieJSONParser.parseFeed(content);
                
                request.getSession().setAttribute("selectedMovie", m);
                responsePage = "movie.jsp";

                break;
                
            
        }
    }

    @Override
    public String getResponsePage() {
        return this.responsePage;
    }

}
