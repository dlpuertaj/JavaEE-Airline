/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import com.airline.models.Pilot;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
