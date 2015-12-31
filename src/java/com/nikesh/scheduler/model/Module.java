package com.nikesh.scheduler.model;

import com.nikesh.scheduler.abstractor.ClassType;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nikesh
 */
public class Module {

    private String moduleCode;
    private String moduleName;
    private Set<ClassType> typeOfClasses;

    public Module(String moduleCode, String moduleName, Set<ClassType> typeOfClasses) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.typeOfClasses = typeOfClasses;
    }

    public Module() {
        this.typeOfClasses = new HashSet<ClassType>();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Set<ClassType> getTypeOfClasses() {
        return typeOfClasses;
    }

    public void setTypeOfClasses(Set<ClassType> typeOfClasses) {
        this.typeOfClasses = typeOfClasses;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.moduleCode != null ? this.moduleCode.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Module)){
            return false;
        }
        
        Module m = (Module) obj;
        
        return this.moduleCode.equals(m.getModuleCode());
    }
}
