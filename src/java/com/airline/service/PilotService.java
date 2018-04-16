/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Flight;
import com.airline.models.Pilot;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Usado para guardar pilotos en la base de datos
 *
 * @author dlpuertaj
 */
@Stateless
@LocalBean
public class PilotService {
    
    @PersistenceContext(unitName = "WebOnePU")
    EntityManager em;
    
    public void addPilot(Pilot pilot){
        em.persist(pilot);
    }
    
    public void addNewPilotToFlight(Pilot pilot, String flightId) {
        
        //Guardar pilot en db
        
        em.persist(pilot);
        
        TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById", Flight.class);

        fQuery.setParameter("id", Integer.parseInt(flightId));

        Flight f = fQuery.getSingleResult();//El vuelo con el id del typedQuery

       
        
        List<Pilot> pList = f.getPilots();
        pList.add(pilot);
        
        f.setPilots(pList);
        
        pilot.setFlightForPilot(f);
    }
        
}
