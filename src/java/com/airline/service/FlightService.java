/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;
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
public class FlightService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public FlightService(){}
    
    @PersistenceContext(unitName = "WebOnePU")
    EntityManager em;
    
    public void addFlight(Flight flight, Airplane airplane){
        em.persist(flight);
        em.persist(airplane);
    }
    
}
