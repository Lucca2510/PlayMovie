/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 31520731
 */
@Entity
@Table(name = "MOVIELIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movielist.findAll", query = "SELECT m FROM Movielist m"),
    @NamedQuery(name = "Movielist.findByIdMovielist", query = "SELECT m FROM Movielist m WHERE m.idMovielist = :idMovielist"),
    @NamedQuery(name = "Movielist.findByUser", query = "SELECT m FROM Movielist m WHERE m.fkUser = :fkUser"),
    @NamedQuery(name = "Movielist.findByName", query = "SELECT m FROM Movielist m WHERE m.name = :name")})
public class Movielist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MOVIELIST")
    private Long idMovielist;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "FK_USER", referencedColumnName = "ID_USERPROJ")
    @ManyToOne
    private Userproj fkUser;
    @OneToMany(mappedBy = "fkMovielist")
    private Collection<Thumbup> thumbupCollection;
    @OneToMany(mappedBy = "fkMovielist")
    private Collection<Movieonlist> movieonlistCollection;

    public Movielist() {
    }

    public Movielist(Long idMovielist) {
        this.idMovielist = idMovielist;
    }

    public Long getIdMovielist() {
        return idMovielist;
    }

    public void setIdMovielist(Long idMovielist) {
        this.idMovielist = idMovielist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Userproj getFkUser() {
        return fkUser;
    }

    public void setFkUser(Userproj fkUser) {
        this.fkUser = fkUser;
    }

    @XmlTransient
    public Collection<Thumbup> getThumbupCollection() {
        return thumbupCollection;
    }

    public void setThumbupCollection(Collection<Thumbup> thumbupCollection) {
        this.thumbupCollection = thumbupCollection;
    }

    @XmlTransient
    public Collection<Movieonlist> getMovieonlistCollection() {
        return movieonlistCollection;
    }

    public void setMovieonlistCollection(Collection<Movieonlist> movieonlistCollection) {
        this.movieonlistCollection = movieonlistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovielist != null ? idMovielist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movielist)) {
            return false;
        }
        Movielist other = (Movielist) object;
        if ((this.idMovielist == null && other.idMovielist != null) || (this.idMovielist != null && !this.idMovielist.equals(other.idMovielist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Movielist[ idMovielist=" + idMovielist + " ]";
    }
    
}
