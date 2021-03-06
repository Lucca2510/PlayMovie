package com.br.lp3.json;

import com.br.lp3.model.entities.Movie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

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

    public static String openURL(String uri) {
        String content = "";

        try {
            URL url = new URL(uri);
            //Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("172.16.0.10", 3128));
            //HttpURLConnection con = (HttpURLConnection) url.openConnection(proxy);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int cod = con.getResponseCode();

            if (cod == 407) {
                System.out.println("Erro no proxy");
                content = "movienotfound";
            } else if (cod == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                con.disconnect();
                content = sb.toString();
            } else {
                content = "movienotfound";
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieJSONParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieJSONParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return content;
    }

    public static Movie parseFeed(String content) {

        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject root = reader.readObject();
        reader.close();
        Movie m = null;

        if (root.getString("Response").equals("True")) {

            String title = root.getString("Title");
            String rated = root.getString("Rated");
            String releasedStr = root.getString("Released");

            String runtime = root.getString("Runtime");
            String genre = root.getString("Genre");
            String director = root.getString("Director");
            String actors = root.getString("Actors");
            String plot = root.getString("Plot");
            String poster = root.getString("Poster");
            int metascore;
            if (root.getString("Metascore").equals("N/A")) {
                  metascore = -1;
            } else {

                 metascore = Integer.parseInt(root.getString("Metascore"));
            }
            String imdbID = root.getString("imdbID");

            m = new Movie(title, rated, releasedStr, runtime, genre, director, actors, plot, poster, metascore, imdbID);

        }
        return m;

    }

    public static String parseName(String content) {

        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject root = reader.readObject();
        reader.close();
        Movie m = null;

        if (root.getString("Response").equals("True")) {

            String title = root.getString("Title");

            return title;

        }
        return null;

    }

    public static String getError(String content) {
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject root = reader.readObject();
        reader.close();
        return root.getString("Error");
    }

}
