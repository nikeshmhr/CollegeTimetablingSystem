package com.nikesh.scheduler.abstractor;

/**
 *
 * @author Nikesh
 */
public abstract class ClassType {

    private int typeId;
    private String typeName;
    private double classHours;

    public ClassType(int id, String name, double classHours) {
        this.typeId = id;
        this.typeName = name;
        this.classHours = classHours;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getClassHours() {
        return classHours;
    }

    public void setClassHours(double classHours) {
        this.classHours = classHours;
    }

    @Override
    public String toString() {
        return "Type ID: " + this.typeId + " | Type Name: " + this.typeName;
    }
}
