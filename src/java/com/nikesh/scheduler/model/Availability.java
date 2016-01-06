package com.nikesh.scheduler.model;

import com.nikesh.scheduler.dao.RetrieveResources;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class holds all the available resources.
 *
 * @author Nikesh
 */
public class Availability {

    private static Map<String, Integer> availableClassrooms = new HashMap<String, Integer>();   // <roomCode, roomType>
    private static Set<String> availableGroups = new HashSet<String>(); // <groupCode>
    //private static Set<String> availableModule = new HashSet<String>();
    private static Set<String> availableTeachers = new HashSet<String>(); // <teacherId>
    //private static ArrayList<String> availableTeacherModule = new ArrayList<String>();
    //private static ArrayList<String> availableGroupModule = new ArrayList<String>();

    public static void resetResources() throws SQLException, ClassNotFoundException {
        resetClassrooms();
        resetGroups();
        resetTeachers();
    }

    public static Map<String, Integer> getAvailableClassrooms() {
        return availableClassrooms;
    }

    public static void setAvailableClassrooms(Map<String, Integer> availableClassrooms) {
        Availability.availableClassrooms = availableClassrooms;
    }

    public static Set<String> getAvailableGroups() {
        return availableGroups;
    }

    public static void setAvailableGroups(Set<String> availableGroups) {
        Availability.availableGroups = availableGroups;
    }

    public static Set<String> getAvailableTeachers() {
        return availableTeachers;
    }

    public static void setAvailableTeachers(Set<String> availableTeachers) {
        Availability.availableTeachers = availableTeachers;
    }

    /**
     * Checks whether the teacher with provided id is available right now.
     *
     * @param teacherId
     * @return
     */
    public static boolean isTeacherAvailable(String teacherId) {
        boolean status = false;

        for (String teacher : availableTeachers) {
            if (teacher.equals(teacherId)) {
                status = true;
                break;
            }
        }

        return status;
    }

    public static boolean isGroupAvailable(String groupCode) {
        boolean status = false;

        for (String group : availableGroups) {
            if (group.equals(groupCode)) {
                status = true;
                break;
            }
        }

        return status;
    }

    public static boolean isGroupsAvailable(List<String> groupCodes) {
        boolean available = false;

        for (String code : groupCodes) {
            available = isGroupAvailable(code);
        }

        return available;
    }
    
    public static boolean isRoomAvailableForType(int roomType){
        boolean status = false;
        
        if(availableClassrooms.containsValue(roomType)){
            Set<String> roomKeys = availableClassrooms.keySet();
            for(String key : roomKeys){
                if(availableClassrooms.get(key) == roomType){
                    status = true;
                }
            }
        }
        
        return status;
    }

    public static String getClassroomForType(int roomType) {
        String roomCode = null;

        if (availableClassrooms.containsValue(roomType)) {
            Set<String> keys = availableClassrooms.keySet();
            //System.out.println(keys);
            for (String key : keys) {
                if (availableClassrooms.get(key).equals(roomType)) {
                    roomCode = key;
                    break;
                }
            }
        }

        return roomCode;
    }

    private static void resetTeachers() throws SQLException, ClassNotFoundException {
        List<Teacher> teachers = RetrieveResources.getTeachers();
        for (Teacher t : teachers) {
            availableTeachers.add(t.getTeacherId());
        }
    }

    private static void resetClassrooms() throws SQLException, ClassNotFoundException {
        List<Classroom> classrooms = RetrieveResources.getClassrooms();
        for (Classroom c : classrooms) {
            availableClassrooms.put(c.getRoomCode(), c.getRoomType().getTypeId());
        }
    }

    private static void resetGroups() throws SQLException, ClassNotFoundException {
        List<Group> groups = RetrieveResources.getGroups();
        for (Group g : groups) {
            availableGroups.add(g.getGroupCode());
        }
    }

}
