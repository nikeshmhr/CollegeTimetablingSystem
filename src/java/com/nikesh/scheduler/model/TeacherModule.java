package com.nikesh.scheduler.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikesh
 */
public class TeacherModule {

    private Teacher teacher;
    private List<ModuleAndItsType> listOfModulesAndItsType;

    public TeacherModule() {
        this(null, new ArrayList<ModuleAndItsType>());
    }

    public TeacherModule(Teacher teacher, List<ModuleAndItsType> listOfMAIT) {
        this.teacher = teacher;
        this.listOfModulesAndItsType = listOfMAIT;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<ModuleAndItsType> getListOfModulesAndItsType() {
        return listOfModulesAndItsType;
    }

    public void setListOfModulesAndItsType(List<ModuleAndItsType> listOfModulesAndItsType) {
        this.listOfModulesAndItsType = listOfModulesAndItsType;
    }
    
    @Override
    public String toString(){
        return teacher.toString();
    }

}
