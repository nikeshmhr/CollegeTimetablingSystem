package com.nikesh.scheduler.model.concrete;

import com.nikesh.scheduler.abstractor.ClassType;

/**
 *
 * @author Nikesh
 */
public class Tutorial extends ClassType {

    public Tutorial(double hour) {
        super(2, "Tutorial", hour);
    }
    
    public Tutorial(){
        this(0);
    }
    
}
