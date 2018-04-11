/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Pilot;
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
public class FlightService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public FlightService() {
    }

    @PersistenceContext(unitName = "WebOnePU")
    EntityManager em;

    public void addFlight(Flight flight, Airplane airplane) {
        em.persist(flight);
        em.persist(airplane);
    }

    public void addPilotToFlight(String pilotId, String flightId) {
        TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById", Flight.class);

        fQuery.setParameter("id", Integer.parseInt(flightId));

        Flight f = fQuery.getSingleResult();//El vuelo con el id del typedQuery

        TypedQuery<Pilot> pQuery = em.createNamedQuery("Pilot.findById", Pilot.class);

        pQuery.setParameter("id", Integer.parseInt(pilotId));

        Pilot p = pQuery.getSingleResult();
        
        List<Pilot> pList = f.getPilots();
        pList.add(p);
        
        f.setPilots(pList);
        
        p.setFlightForPilot(f);
    }
    
    /*Get list of all the flights*/
    public List<Flight> getFlights(){
        List<Flight> fList;
        
        /*Es otra manera de buscar en la base de datos. Antes se usó un
         * namedQuery pero ahora se usa un TypedQuery*/
        TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f",Flight.class);
        fList = query.getResultList();
        return fList;
    }
}
