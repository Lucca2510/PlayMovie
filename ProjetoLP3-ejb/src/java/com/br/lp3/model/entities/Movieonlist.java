/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31520731
 */
@Entity
@Table(name = "MOVIEONLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movieonlist.findAll", query = "SELECT m FROM Movieonlist m"),
    @NamedQuery(name = "Movieonlist.findByIdMovieonlist", query = "SELECT m FROM Movieonlist m WHERE m.idMovieonlist = :idMovieonlist"),
    @NamedQuery(name = "Movieonlist.findByFkMovie", query = "SELECT m FROM Movieonlist m WHERE m.fkMovie = :fkMovie")})
public class Movieonlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MOVIEONLIST")
    private Long idMovieonlist;
    @Column(name = "FK_MOVIE")
    private BigInteger fkMovie;
    @JoinColumn(name = "FK_MOVIELIST", referencedColumnName = "ID_MOVIELIST")
    @ManyToOne
    private Movielist fkMovielist;

    public Movieonlist() {
    }

    public Movieonlist(Long idMovieonlist) {
        this.idMovieonlist = idMovieonlist;
    }

    public Long getIdMovieonlist() {
        return idMovieonlist;
    }

    public void setIdMovieonlist(Long idMovieonlist) {
        this.idMovieonlist = idMovieonlist;
    }

    public BigInteger getFkMovie() {
        return fkMovie;
    }

    public void setFkMovie(BigInteger fkMovie) {
        this.fkMovie = fkMovie;
    }

    public Movielist getFkMovielist() {
        return fkMovielist;
    }

    public void setFkMovielist(Movielist fkMovielist) {
        this.fkMovielist = fkMovielist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovieonlist != null ? idMovieonlist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movieonlist)) {
            return false;
        }
        Movieonlist other = (Movieonlist) object;
        if ((this.idMovieonlist == null && other.idMovieonlist != null) || (this.idMovieonlist != null && !this.idMovieonlist.equals(other.idMovieonlist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Movieonlist[ idMovieonlist=" + idMovieonlist + " ]";
    }
    
}
