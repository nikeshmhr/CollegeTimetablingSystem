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
public class Lab extends ClassType {

    public Lab(double hours) {
        super(3, "Lab", hours);
    }
    
    public Lab(){
        this(0);
    }
    
}
