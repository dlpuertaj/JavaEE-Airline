/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Passenger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
