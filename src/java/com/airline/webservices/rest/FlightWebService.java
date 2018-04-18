/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.webservices.rest;

import com.airline.models.Flight;
import com.airline.service.FlightService;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author dlpuertaj
 */
@Path("/flights")//airlineservices/rest/flights
public class FlightWebService {
    /*Inyectamos*/
    @PersistenceContext(unitName = "WebOnePU")
    EntityManager em;//Para hacer query a la base de datos
    
    @EJB
    FlightService fs;//
    
    /*Lo usaremos para construir enlaces a recursos de nuestro server*/
    @Context
    UriInfo fUriInfo;
    
    public FlightWebService(){
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> getFlights(){
        List<Flight> fList = fs.getFlights();
        
        return fList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{flight_id}")
    public Flight getFlight(@PathParam("flight_id") Integer flight_id){
        //localhost:8080/WebOne/airlineservices/rest/flights/id
        Flight f = fs.getFlight(flight_id);
        
        return f;
    }
}
