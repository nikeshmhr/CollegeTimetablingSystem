package com.nikesh.scheduler.model;

/**
 *
 * @author Nikesh
 */
public class Group {
    
    private String groupCode;
    private int noOfStudents;
    
    public Group(){
        
    }
    
    public Group(String groupCode, int noOfStudents){
        this.groupCode = groupCode;
        this.noOfStudents = noOfStudents;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }    
    
}
