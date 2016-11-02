/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;



/**
 *
 * @author lgd25
 */
public class Movie {

    private String title;    
    private String rated;
    private String release;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String poster;
    private int metascore;
    private String imdbID;

    public Movie() {
    }

    public Movie(String title, String rated, String release, String runtime, String genre, String director, String actors, String plot, String poster, int metascore, String imdbID) {
        this.title = title;
        this.rated = rated;
        this.release = release;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", rated=" + rated + ", release=" + release + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", actors=" + actors + ", plot=" + plot + ", poster=" + poster + ", metascore=" + metascore + ", imdbID=" + imdbID + '}';
    }
    
    

}
