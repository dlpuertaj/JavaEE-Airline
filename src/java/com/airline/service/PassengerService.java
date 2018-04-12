/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Passenger;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dlpuertaj
 */
@Stateless
@LocalBean
public class PassengerService {

    /*Inyectamos por medio de CDI el entity managere*/
    @PersistenceContext(unitName = "WebOnePU")
    private EntityManager em;
    
    public void addPassenger(Passenger p){
        em.persist(p);
    }
    
    public List<Passenger> getPassengers(){
        TypedQuery<Passenger> query = em.createQuery("SELECT p FROM Passenger p",Passenger.class);
        List<Passenger> pList = query.getResultList();
        return pList;
    }
}
