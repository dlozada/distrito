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
@Table(name = "compania")
@NamedQueries({
    @NamedQuery(name = "Compania.findAll", query = "SELECT c FROM Compania c")
    , @NamedQuery(name = "Compania.findById", query = "SELECT c FROM Compania c WHERE c.id = :id")
    , @NamedQuery(name = "Compania.findByNombreCompania", query = "SELECT c FROM Compania c WHERE c.nombreCompania = :nombreCompania")
    , @NamedQuery(name = "Compania.findByNumeroCompania", query = "SELECT c FROM Compania c WHERE c.numeroCompania = :numeroCompania")})
public class Compania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre_compania")
    private String nombreCompania;
    @Column(name = "numero_compania")
    private Integer numeroCompania;
    @OneToMany(mappedBy = "idcompania")
    private Collection<Soldado> soldadoCollection;

    public Compania() {
    }

    public Compania(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public Integer getNumeroCompania() {
        return numeroCompania;
    }

    public void setNumeroCompania(Integer numeroCompania) {
        this.numeroCompania = numeroCompania;
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
        if (!(object instanceof Compania)) {
            return false;
        }
        Compania other = (Compania) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.prueba.model.Compania[ id=" + id + " ]";
    }
    
}
