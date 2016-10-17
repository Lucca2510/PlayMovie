package com.br.lp3.json;

import com.br.lp3.model.entities.Movie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lgd25
 */
public class MovieJSONParser {
    
    
    public static String openURL(String uri){
        String content="";
        
        try {
            URL url = new URL(uri);
            
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            int cod = con.getResponseCode();
            
           if(cod==407){
               System.out.println("Erro no proxy");
           }else if(cod==200){
               BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
               StringBuilder sb = new StringBuilder();
               String line;
               
               while ((line=br.readLine())!=null){
                   sb.append(line);
               }
               br.close();
               con.disconnect();
               content=sb.toString();
           }else{
               System.out.println("Erro diferente");
           }
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieJSONParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieJSONParser.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
        return content;
    }
    
    
    public static List<Movie> parseFeed(String content){
        List<Movie> movies = new ArrayList<>();
        
        
        return movies;
    }
    
}
