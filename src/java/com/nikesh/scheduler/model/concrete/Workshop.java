/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nikesh.scheduler.model.concrete;

import com.nikesh.scheduler.abstractor.ClassType;

/**
 *
 * @author Nikesh
 */
public class Workshop extends ClassType {

    public Workshop(double hour) {
        super(4, "Workshop", hour);
    }
    
    public Workshop(){
        this(0);
    }
    
}
