/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.service;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author dlpuertaj
 * A singleton bean is a bean for whoom the ejb container creates one instance
 * Thats why it uses the same counter if we inyect it twice in two different servlets
 */
@Singleton
@LocalBean
public class CounterBean {

    Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    public void addOneToCount(){
        this.count++;
    }
}
