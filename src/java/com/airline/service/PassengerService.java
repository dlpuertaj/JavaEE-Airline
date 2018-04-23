/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Flight;
import com.airline.models.Passenger;
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
import javax.ws.rs.core.Response;

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
    
    public Passenger addPassenger(Passenger p){
        em.persist(p);
        
        return p;
    }
    
    public void addFlightTicketToPassenger(String fId,String pId){
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
        
        /*Asociamos vuelo a pasajero*/
        
        List<Flight> fList = p.getFlights();
        fList.add(f);
        p.setFlights(fList);
        
        //asociamos pasajero a vuelo
        f.getPassengers().add(p);
    }
    
        public Passenger getPassenger(Integer id){
        /* Start tamplate for a criteria query*/
        CriteriaBuilder builder = em.getCriteriaBuilder();
        
        CriteriaQuery<Passenger> cPassenger = builder.createQuery(Passenger.class);
        
        Root<Passenger> pRoot = cPassenger.from(Passenger.class);
        /* Enf tamplate for a criteria query*/
        
        cPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), id));
        
        TypedQuery<Passenger> pQuery = em.createQuery(cPassenger);
        
        try{
            Passenger p = pQuery.getSingleResult();
            return p;
        }catch(NoResultException e){
            e.printStackTrace();
        }
        return null;
    }
        
        
    public List<Passenger> getPassengers(){
        TypedQuery<Passenger> query = em.createQuery("SELECT p FROM Passenger p",Passenger.class);
        List<Passenger> pList = query.getResultList();
        return pList;
    }
}
