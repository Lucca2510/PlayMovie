/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

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
        
    }

    @Override
    public String getResponsePage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
