/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lgd25
 */
@Entity
@Table(name = "USERPROJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userproj.findAll", query = "SELECT u FROM Userproj u"),
    @NamedQuery(name = "Userproj.findByIdUserproj", query = "SELECT u FROM Userproj u WHERE u.idUserproj = :idUserproj"),
    @NamedQuery(name = "Userproj.findByUsername", query = "SELECT u FROM Userproj u WHERE u.username = :username"),
    @NamedQuery(name = "Userproj.findByPassword", query = "SELECT u FROM Userproj u WHERE u.password = :password")})
public class Userproj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USERPROJ")
    private Long idUserproj;
    @Size(max = 30)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userproj")
    private Userinfo userinfo;

    public Userproj() {
    }

    public Userproj(Long idUserproj) {
        this.idUserproj = idUserproj;
    }

    public Long getIdUserproj() {
        return idUserproj;
    }

    public void setIdUserproj(Long idUserproj) {
        this.idUserproj = idUserproj;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserproj != null ? idUserproj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userproj)) {
            return false;
        }
        Userproj other = (Userproj) object;
        if ((this.idUserproj == null && other.idUserproj != null) || (this.idUserproj != null && !this.idUserproj.equals(other.idUserproj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Userproj[ idUserproj=" + idUserproj + " ]";
    }
    
}
