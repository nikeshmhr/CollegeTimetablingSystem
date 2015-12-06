package com.nikesh.scheduler.model;

import com.nikesh.scheduler.abstractor.ClassType;

/**
 *
 * @author Nikesh
 */
public class ModuleAndItsType {

    private Module module;  // a module (specific)
    private ClassType typeOfClass;     // type of class for this specific module 
    private String identifier;      // the combined string of module code and classtype code.

    public ModuleAndItsType() {
        this(null, null, null);
    }

    public ModuleAndItsType(Module module, ClassType typeOfClass, String identifier) {
        this.module = module;
        this.typeOfClass = typeOfClass;
        this.identifier = identifier;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ClassType getTypeOfClass() {
        return typeOfClass;
    }

    public void setTypeOfClass(ClassType typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

}
