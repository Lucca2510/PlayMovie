/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
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
@Table(name = "THUMBUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thumbup.findAll", query = "SELECT t FROM Thumbup t"),
    @NamedQuery(name = "Thumbup.findByIdThumbup", query = "SELECT t FROM Thumbup t WHERE t.idThumbup = :idThumbup")})
public class Thumbup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_THUMBUP")
    private Long idThumbup;
    @JoinColumn(name = "FK_MOVIELIST", referencedColumnName = "ID_MOVIELIST")
    @ManyToOne
    private Movielist fkMovielist;
    @JoinColumn(name = "FK_USER", referencedColumnName = "ID_USERPROJ")
    @ManyToOne
    private Userproj fkUser;

    public Thumbup() {
    }

    public Thumbup(Long idThumbup) {
        this.idThumbup = idThumbup;
    }

    public Long getIdThumbup() {
        return idThumbup;
    }

    public void setIdThumbup(Long idThumbup) {
        this.idThumbup = idThumbup;
    }

    public Movielist getFkMovielist() {
        return fkMovielist;
    }

    public void setFkMovielist(Movielist fkMovielist) {
        this.fkMovielist = fkMovielist;
    }

    public Userproj getFkUser() {
        return fkUser;
    }

    public void setFkUser(Userproj fkUser) {
        this.fkUser = fkUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idThumbup != null ? idThumbup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thumbup)) {
            return false;
        }
        Thumbup other = (Thumbup) object;
        if ((this.idThumbup == null && other.idThumbup != null) || (this.idThumbup != null && !this.idThumbup.equals(other.idThumbup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Thumbup[ idThumbup=" + idThumbup + " ]";
    }
    
}
