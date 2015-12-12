/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nikesh.scheduler.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nikesh
 */
public class GroupModule {
    
    private Group group;
    private List<ModuleAndItsType> listOfModulesAndItsType;

    public GroupModule() {
        this(null, new ArrayList<ModuleAndItsType>());
    }

    public GroupModule(Group group, List<ModuleAndItsType> listOfModulesAndItsType) {
        this.group = group;
        this.listOfModulesAndItsType = listOfModulesAndItsType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<ModuleAndItsType> getListOfModulesAndItsType() {
        return listOfModulesAndItsType;
    }

    public void setListOfModulesAndItsType(List<ModuleAndItsType> listOfModulesAndItsType) {
        this.listOfModulesAndItsType = listOfModulesAndItsType;
    }   
}
