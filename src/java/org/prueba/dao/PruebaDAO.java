/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prueba.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.prueba.model.Compania;
import org.prueba.model.CuerpoEjercito;
import org.prueba.model.Soldado;

/**
 *
 * @author david
 */
public class PruebaDAO {
    

//
//protected EntityManager getEntityManager(){
//    EntityManagerFactory factory = Persistence.createEntityManagerFactory("DistritoAppPU");
//    EntityManager em = factory.createEntityManager();
//return em;
//
//}

    public void guardar(Soldado soldado) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DistritoAppPU");
        EntityManager em = factory.createEntityManager();           
        em.getTransaction().begin();
        em.persist(soldado);
        em.getTransaction().commit();
    }

    public List<Compania> traerCompanias() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DistritoAppPU");
        EntityManager em = factory.createEntityManager(); 
        
        TypedQuery<Compania> q = em.createQuery("SELECT c FROM Compania c", Compania.class);
        
        List<Compania> results = q.getResultList();
        
        return results;
        
        
    }
     public List<CuerpoEjercito> traerCuerpos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DistritoAppPU");
        EntityManager em = factory.createEntityManager(); 
        TypedQuery<CuerpoEjercito> q = em.createQuery("SELECT c FROM CuerpoEjercito c", CuerpoEjercito.class);
        List<CuerpoEjercito> results = q.getResultList();
        
        return results;
        
        
    }


    
}
