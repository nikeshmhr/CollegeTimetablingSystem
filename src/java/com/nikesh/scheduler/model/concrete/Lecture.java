package com.nikesh.scheduler.model.concrete;

import com.nikesh.scheduler.abstractor.ClassType;

/**
 *
 * @author Nikesh
 */
public class Lecture extends ClassType {

    public Lecture(double hour) {
        super(1, "Lecture", hour);
    }
    
}
