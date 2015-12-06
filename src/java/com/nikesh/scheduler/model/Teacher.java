package com.nikesh.scheduler.model;

import java.io.Serializable;

/**
 *
 * @author Nikesh
 */
public class Teacher {

    private String teacherId;
    private String teacherName;

    public Teacher(String id, String name) {
        this.teacherId = id;
        this.teacherName = name;
    }

    public Teacher() {
        this(null, null);
    }

    /*public Teacher(String name) {
        this(null, name);
    }*/

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return this.teacherName;
    }

    @Override
    public boolean equals(Object teacher) {
        if (!(teacher instanceof Teacher)) {
            return false;
        }
        Teacher t = (Teacher) teacher;

        return this.teacherId.equalsIgnoreCase(t.getTeacherId()) && this.teacherName.equalsIgnoreCase(t.getTeacherName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.teacherId != null ? this.teacherId.hashCode() : 0);
        hash = 47 * hash + (this.teacherName != null ? this.teacherName.hashCode() : 0);
        return hash;
    }

    
}
