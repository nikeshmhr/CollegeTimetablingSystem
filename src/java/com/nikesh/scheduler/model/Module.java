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
    private int year, sem;

    public Module(String moduleCode, String moduleName, Set<ClassType> typeOfClasses) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.typeOfClasses = typeOfClasses;
        this.sem = 0;
        this.year = 0;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
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
    
    @Override
    public String toString(){
        return moduleCode + " " + moduleName;
    }
}
