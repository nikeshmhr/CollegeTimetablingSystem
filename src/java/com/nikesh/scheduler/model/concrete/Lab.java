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
