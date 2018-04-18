/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.webservices.rest;

import com.airline.models.Passenger;
import com.airline.service.PassengerService;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author dlpuertaj
 */
@Path("/passengers")//airlineservices/rest/passengers
public class PassengerWebService {
    /*Inyectamos*/
    @PersistenceContext(unitName = "WebOnePU")
    EntityManager em;
    
    @EJB
    PassengerService ps;
    /*Lo usaremos para construir enlaces a recursos de nuestro server*/
    @Context
    UriInfo pUriInfo;
    
    public PassengerWebService(){
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Passenger> getPassenger(){
        List<Passenger>pList = ps.getPassengers();
        
        return pList;
    }
}
