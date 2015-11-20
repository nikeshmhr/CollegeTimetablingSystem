package com.nikesh.scheduler.factory;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.model.concrete.Lab;
import com.nikesh.scheduler.model.concrete.Lecture;
import com.nikesh.scheduler.model.concrete.Tutorial;
import com.nikesh.scheduler.model.concrete.Workshop;

/**
 *
 * @author Nikesh
 */
public class ClassTypeFactory {
    
    public static ClassType getClassType(int typeId){
        ClassType type = null;
        switch(typeId){
            case 1:
                type = new Lecture();
                break;
            case 2:
                type = new Tutorial();
                break;
            case 3:
                type= new Lab();
                break;
            case 4:
                type= new Workshop();
                break;
        }
        return type;
    }
    
    public static ClassType getClassType(String classTypeName){
        if(classTypeName.equalsIgnoreCase("Lecture")){
            return getClassType(1);
        }else if(classTypeName.equalsIgnoreCase("Tutorial")){
            return getClassType(2);
        }else if(classTypeName.equalsIgnoreCase("Lab")){
            return getClassType(3);
        }else if(classTypeName.equalsIgnoreCase("Workshop")){
            return getClassType(4);
        }
        return null;
    }
    
    /* MIGHT NOT NEED THIS METHOD 
    public static String getTypeName(int typeId){
        String typeName = "";
        
        switch(typeId){
            case 1:
                typeName = "Lecture";
                break;
                
            case 2:
                typeName = "Tutorial";
                break;
                
            case 3:
                typeName = "Lab";
                break;
                
            case 4:
                typeName = "Workshop";
                break;
        }
        return typeName;
    }
    */
}
