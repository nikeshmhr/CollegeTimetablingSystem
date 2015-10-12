package com.nikesh.scheduler.model;

import java.util.List;

/**
 *
 * @author Nikesh
 */
public class TeacherModule {

    private Teacher teacher;
    private List<Module> listOfModules;

    public TeacherModule() {

    }

    public TeacherModule(Teacher teacher, List<Module> modules) {
        this.teacher = teacher;
        this.listOfModules = modules;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Module> getListOfModules() {
        return listOfModules;
    }

    public void setListOfModules(List<Module> listOfModules) {
        this.listOfModules = listOfModules;
    }

}
