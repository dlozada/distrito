/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prueba.model;

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

/**
 *
 * @author david
 */
@Entity
@Table(name = "soldado")
@NamedQueries({
    @NamedQuery(name = "Soldado.findAll", query = "SELECT s FROM Soldado s")
    , @NamedQuery(name = "Soldado.findById", query = "SELECT s FROM Soldado s WHERE s.id = :id")
    , @NamedQuery(name = "Soldado.findByNombres", query = "SELECT s FROM Soldado s WHERE s.nombres = :nombres")
    , @NamedQuery(name = "Soldado.findByApellidos", query = "SELECT s FROM Soldado s WHERE s.apellidos = :apellidos")
    , @NamedQuery(name = "Soldado.findByCiudad", query = "SELECT s FROM Soldado s WHERE s.ciudad = :ciudad")
    , @NamedQuery(name = "Soldado.findByDepto", query = "SELECT s FROM Soldado s WHERE s.depto = :depto")})
public class Soldado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "depto")
    private String depto;
    @JoinColumn(name = "idcompania", referencedColumnName = "id")
    @ManyToOne
    private Compania idcompania;
    @JoinColumn(name = "idcuerpo", referencedColumnName = "id")
    @ManyToOne
    private CuerpoEjercito idcuerpo;

    public Soldado() {
    }

    public Soldado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public Compania getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Compania idcompania) {
        this.idcompania = idcompania;
    }

    public CuerpoEjercito getIdcuerpo() {
        return idcuerpo;
    }

    public void setIdcuerpo(CuerpoEjercito idcuerpo) {
        this.idcuerpo = idcuerpo;
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
        if (!(object instanceof Soldado)) {
            return false;
        }
        Soldado other = (Soldado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.prueba.model.Soldado[ id=" + id + " ]";
    }
    
}
