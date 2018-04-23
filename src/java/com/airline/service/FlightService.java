/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.models.Pilot;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        /* Se persisten los dos a pesar de que avion se agrega a vuelo
         * pero se puede hacer una propagación en cascada*/
        em.persist(flight);
        //em.persist(airplane); - propagated and cascaded from flight and saved automaticlly
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
    
    public void addPassengerToFlight(String pId, String fId){
        /* Get passenger by id*/
        Passenger p; 
        
        /* Start tamplate for a criteria query*/
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Passenger> cPassenger = builder.createQuery(Passenger.class);
        
        Root<Passenger> pRoot = cPassenger.from(Passenger.class);
        /* Enf tamplate for a criteria query*/
        
        cPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), pId));
        
        TypedQuery<Passenger> pQuery = em.createQuery(cPassenger);
        
        p = pQuery.getSingleResult();
        
        /* Al hacerlo de esta manera evitamos errores ya que no se
         * usa un String como en el método getFlights() por lo
         * que es mas seguro usando CriteriaQuery*/
        
        //Buscamos el vuelo
        /* Start tamplate for a criteria query*/
        builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Flight> cFlight = builder.createQuery(Flight.class);
        
        Root<Flight> fRoot = cFlight.from(Flight.class);
        /* Enf tamplate for a criteria query*/
        
        cFlight.select(fRoot).where(builder.equal(fRoot.get("id").as(Integer.class), fId));
        
        TypedQuery<Flight> fQuery = em.createQuery(cFlight);
        
        Flight f = fQuery.getSingleResult();
        
        /*Asociamos pasajero a vuelo*/
        
        List<Passenger> pList = f.getPassengers();
        pList.add(p);
        f.setPasengers(pList);
        
        p.getFlights().add(f);
        
    }
    
    /*Get list of all the flights*/
    public List<Flight> getFlights(){
        List<Flight> fList;
        
        /*Es otra manera de buscar en la base de datos. Antes se usó un
         * namedQuery pero ahora se usa un TypedQuery*/
        TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f",Flight.class);
        
        try{
            fList = query.getResultList();
            return fList;
        }catch(NoResultException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Flight getFlight(Integer id){
        
        TypedQuery<Flight> fQuery = em.createNamedQuery("Flight.findById", Flight.class);

        fQuery.setParameter("id", id);

        Flight f = fQuery.getSingleResult();//El vuelo con el id del typedQuery

        
        return f;
    }
}
