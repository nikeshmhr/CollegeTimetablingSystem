package com.nikesh.scheduler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class holds the resources that are occupied with additional information
 * like time (till the resource is occupied)
 *
 * @author Nikesh
 */
public class OccupiedTable {

    /**
     * <Codes, EndTime> *
     */
    private static Map<String, Double> occupiedTeacher = new HashMap<String, Double>();
    private static Map<String, Double> occupiedClassroom = new HashMap<String, Double>();
    //private static Map<Module, String> occupiedModule = new HashMap<Module, String>();
    private static Map<String, Double> occupiedGroup = new HashMap<String, Double>();

    public static void resetOccupiedResource() {
        if (!occupiedClassroom.isEmpty()) {
            occupiedClassroom = new HashMap<String, Double>();
        }
        if (!occupiedTeacher.isEmpty()) {
            occupiedTeacher = new HashMap<String, Double>();
        }
        if (!occupiedGroup.isEmpty()) {
            occupiedGroup = new HashMap<String, Double>();
        }
    }

    public static Map<String, Double> getOccupiedTeacher() {
        return occupiedTeacher;
    }

    public static void setOccupiedTeacher(Map<String, Double> occupiedTeacher) {
        OccupiedTable.occupiedTeacher = occupiedTeacher;
    }

    public static Map<String, Double> getOccupiedClassroom() {
        return occupiedClassroom;
    }

    public static void setOccupiedClassroom(Map<String, Double> occupiedClassroom) {
        OccupiedTable.occupiedClassroom = occupiedClassroom;
    }

    public static Map<String, Double> getOccupiedGroup() {
        return occupiedGroup;
    }

    public static void setOccupiedGroup(Map<String, Double> occupiedGroup) {
        OccupiedTable.occupiedGroup = occupiedGroup;
    }

    public static Double getEndTimeForClassroom(String roomCode) {
        double hour = 0;

        if (occupiedClassroom.containsKey(roomCode)) {
            hour = occupiedClassroom.get(roomCode);
        }

        return hour;
    }

    public static Double getEndTimeForTeacher(String teacherId) {
        double hour = 0;

        if (occupiedTeacher.containsKey(teacherId)) {
            hour = occupiedTeacher.get(teacherId);
        }

        return hour;
    }

    public static Double getEndTimeForGroup(String groupCode) {
        double hour = 0;

        if (occupiedGroup.containsKey(groupCode)) {
            hour = occupiedGroup.get(groupCode);
        }

        return hour;
    }

    public static Double getEndTimeForGroups(ArrayList<String> groupCodes) {
        double hour = 0;

        for (String code : groupCodes) {
            if (hour < occupiedGroup.get(code)) {
                hour = occupiedGroup.get(code);
            }
        }

        //System.out.println("MAX END TIME FOR GROUP " + hour);
        
        return hour;
    }

    public static String getOccupiedRoomForType(int roomType) {
        String room = "";

        System.out.println("TYPE REQUES : " + roomType);
        if (occupiedClassroom.containsValue(roomType)) {

            Set<String> roomKey = occupiedClassroom.keySet();
            int endTime = 0;
            for (String key : roomKey) {
                if (occupiedClassroom.get(key) == roomType) {
                    room = key;
                    break;
                }
            }
        }

        return room;
    }

    static String getOccupiedRoomForTypeAndEndTime(int classType, int startTime) {
        String room = "";

        if (occupiedClassroom.containsValue(classType)) {

        }

        return room;
    }

}
