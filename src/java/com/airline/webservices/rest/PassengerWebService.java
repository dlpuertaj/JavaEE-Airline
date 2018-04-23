/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.webservices.rest;

import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;
import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{passenger_id}")
    public Passenger getPassenger(@PathParam("passenger_id") Integer passengerId){
        //localhost:8080/WebOne/airlineservices/rest/flights/id
        Passenger p = ps.getPassenger(passengerId);
        if(p == null){
            throw new NotFoundException("The passenger with id "+passengerId+" was not found");
        }
        return p;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPassenger(Passenger p){
        p = ps.addPassenger(p);
       
        UriBuilder pUriBuilder = pUriInfo.getAbsolutePathBuilder();
        
        URI pUri = pUriBuilder.path(String.valueOf(p.getId())).build();
        
        return Response.created(pUri).build();
    }
}
