/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prueba.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "cuerpo_ejercito")
@NamedQueries({
    @NamedQuery(name = "CuerpoEjercito.findAll", query = "SELECT c FROM CuerpoEjercito c")
    , @NamedQuery(name = "CuerpoEjercito.findById", query = "SELECT c FROM CuerpoEjercito c WHERE c.id = :id")
    , @NamedQuery(name = "CuerpoEjercito.findByNombreCuerpo", query = "SELECT c FROM CuerpoEjercito c WHERE c.nombreCuerpo = :nombreCuerpo")})
public class CuerpoEjercito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre_cuerpo")
    private String nombreCuerpo;
    @OneToMany(mappedBy = "idcuerpo")
    private Collection<Soldado> soldadoCollection;

    public CuerpoEjercito() {
    }

    public CuerpoEjercito(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCuerpo() {
        return nombreCuerpo;
    }

    public void setNombreCuerpo(String nombreCuerpo) {
        this.nombreCuerpo = nombreCuerpo;
    }

    public Collection<Soldado> getSoldadoCollection() {
        return soldadoCollection;
    }

    public void setSoldadoCollection(Collection<Soldado> soldadoCollection) {
        this.soldadoCollection = soldadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuerpoEjercito)) {
            return false;
        }
        CuerpoEjercito other = (CuerpoEjercito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.prueba.model.CuerpoEjercito[ id=" + id + " ]";
    }
    
}
