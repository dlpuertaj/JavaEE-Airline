/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controllers;

import com.airline.service.CounterStatefulBean;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author dlpuertaj
 */
public class SessionListener implements HttpSessionListener {

    @EJB
    CounterStatefulBean cbStateful;
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        
        HttpSession s = event.getSession();
        
        s.setAttribute("cbStateful", cbStateful );
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
