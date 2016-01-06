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
