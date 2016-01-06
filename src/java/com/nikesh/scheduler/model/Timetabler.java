package com.nikesh.scheduler.model;

import com.nikesh.scheduler.abstractor.ClassType;
import com.nikesh.scheduler.dao.RetrieveResources;
import com.nikesh.scheduler.factory.ClassTypeFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nikesh
 */
public class Timetabler {

    private List<Timeslot> timeslots, sortedTimeslot, groupedTimeslot, groupedAndSortedTimeslot;
    private List<Module> listOfModules;

    public Timetabler() throws SQLException, ClassNotFoundException {
        timeslots = new ArrayList<Timeslot>();
        sortedTimeslot = new ArrayList<Timeslot>();
        groupedTimeslot = new ArrayList<Timeslot>();
        listOfModules = RetrieveResources.getModules();
        groupedAndSortedTimeslot = new ArrayList<Timeslot>();

        List<TeacherModule> teacherModule = RetrieveResources.getTeacherModules();
        List<GroupModule> groupModule = RetrieveResources.getGroupModule();

        int count = mapGroupModuleTeacher(groupModule, teacherModule);

        //System.out.println("TOTAL: " + count);
        sortMappedTimeslot();
//        for (Timeslot t : sortedTimeslot) {
//            System.out.println(t);
//        }

        assignDays();
//        System.out.println("SORTED: " + sortedTimeslot.size());
//        for (Timeslot t : sortedTimeslot) {
//            System.out.println(t);
//        }

        /**
         * GROUPING THE TIMESLOT IF THE CLASS TYPE IS LECTURE AND MAX UPTO 3
         */
        groupLectureClasses();

        /*System.out.println("SORTED, GROUPED AND DAY ASSIGNED: " + groupedTimeslot.size());
         for (Timeslot t : groupedTimeslot) {
         System.out.println(t);
         }*/
        formatDayAndClasstypeWise(groupedTimeslot);
        //System.out.println("GROUPED AND SORTED");
        /*for (Timeslot t : groupedAndSortedTimeslot) {
         //System.out.println(t);
         String teacherName = RetrieveResources.getTeacherName(t.getTeacherId());
         String moduleName = RetrieveResources.getModuleName(t.getModuleCode());
         String classType = ClassTypeFactory.getClassType(t.getClassType()).getTypeName();

         System.out.println(t.getDayString()+ ", " + moduleName + "(" + t.getModuleCode() + ")" + ", " + classType + ", " + teacherName + ", " + t.getGroupCode());
         }*/

        //Availability.resetResources();
        //System.out.println(Availability.getAvailableClassrooms());
        //Availability.getAvailableClassrooms().remove("LT-101");
        //System.out.println(Availability.getAvailableClassrooms());
        //OccupiedTable.resetOccupiedResource();
        //OccupiedTable.getOccupiedClassroom().put("LT-101", (7 + groupedAndSortedTimeslot.get(0).getHours()));
        //System.out.println(OccupiedTable.getOccupiedClassroom());

        scheduleTimetabe();
        /*System.out.println("OCCUPIED");
         System.out.println(OccupiedTable.getOccupiedClassroom());
         System.out.println(OccupiedTable.getOccupiedGroup());
         System.out.println(OccupiedTable.getOccupiedTeacher());*/

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new Timetabler();
    }

    public List<Timeslot> getTimeslots() {
        return this.groupedAndSortedTimeslot;
    }

    private List<Timeslot> getGroupableTimeslots(String moduleCode) {
        List<Timeslot> groupables = new ArrayList<Timeslot>();

        for (Timeslot t : sortedTimeslot) {
            if (t.getModuleCode().equals(moduleCode)) {
                if (t.getClassType() == ClassType.LECTURE && t.isIsScheduled() == false) {
                    if (groupables.size() < 3) {
                        groupables.add(t);
                        t.setIsScheduled(true);
                    }
                } else if (t.getClassType() != ClassType.LECTURE && t.isIsScheduled() == false) {
                    groupedTimeslot.add(t);
                    t.setIsScheduled(true);
                }
            }
        }
        //System.out.println(groupables);
        //System.out.println(groupedTimeslot);
        //System.out.println(groupedTimeslot.size());
        return groupables;
    }

    private int mapGroupModuleTeacher(List<GroupModule> groupModule, List<TeacherModule> teacherModule) throws SQLException, ClassNotFoundException {
        int count = 0;
        // each group module
        for (int i = 0; i < groupModule.size(); i++) {
            GroupModule gm = groupModule.get(i);
            String gmModuleCode = gm.getListOfModulesAndItsType().get(0).getModule().getModuleCode();
            String groupCode = gm.getGroup().getGroupCode();
            for (int j = 0; j < teacherModule.size(); j++) {    // each teacher module
                TeacherModule tm = teacherModule.get(j);
                String tmModuleCode = tm.getListOfModulesAndItsType().get(0).getModule().getModuleCode();
                if (gmModuleCode.equalsIgnoreCase(tmModuleCode)) {  // match module code from GROUPMODULE and TEACHERMODULE and if match found make new timeslot object.
                    Timeslot ts = new Timeslot();
                    String teacherId = tm.getTeacher().getTeacherId();
                    String moduleCode = tm.getListOfModulesAndItsType().get(0).getModule().getModuleCode();
                    int classType = tm.getListOfModulesAndItsType().get(0).getTypeOfClass().getTypeId();

                    double hours = RetrieveResources.getClassHours(moduleCode, classType);

                    ts.setGroupCode(groupCode);
                    ts.setClassType(classType);
                    ts.setModuleCode(tmModuleCode);
                    ts.setTeacherId(teacherId);
                    ts.setHours(hours);

                    timeslots.add(ts);
                    count++;
                }
            }
        }
        return count;
    }

    private void sortMappedTimeslot() {
        /**
         * FOrmatted only class type wise and module wise *
         */
        for (int i = 1; i < 5; i++) {
            for (Module m : listOfModules) {
                String moduleCode = m.getModuleCode();
                for (Timeslot t : timeslots) {
                    if (t.getModuleCode().equalsIgnoreCase(moduleCode) && t.getClassType() == i) {
                        sortedTimeslot.add(t);
                    }
                }
            }
        }
    }

    private void formatDayAndClasstypeWise(List<Timeslot> grouped) {
        for (int i = 1; i < 7; i++) {
            for (Timeslot t : grouped) {
                if (t.getDay() == i) {
                    groupedAndSortedTimeslot.add(t);
                }
            }
        }
    }

    private void assignDays() {
        int sun = 0;
        int mon = 0;
        int tue = 0;
        int wed = 0;
        int thu = 0;
        int fri = 0;

        for (int i = 1; i <= 3; i++) {
            for (Timeslot t : sortedTimeslot) {
                int classType = t.getClassType();
                if (classType == i || (classType) == (i + 1)) {
                    if (classType == ClassType.LECTURE) {
                        if (t.getDay() == 0) {
                            //int rand = (int)(Math.random() * 2) + 1;
                            if (sun > mon) {
                                t.setDay(2);
                                mon += 1;
                            } else {
                                t.setDay(1);
                                sun += 1;
                            }
                        }
                        //System.out.println(t.getModuleCode() + ", ClassType: " + t.getClassType() + ", Day: " + t.getDay() + ", " + t.getTeacherId());
                    } else if (classType == ClassType.TUTORIAL) {
                        if (t.getDay() == 0) {
                            if (tue > wed) {
                                t.setDay(4);
                                wed += 1;
                            } else {
                                t.setDay(3);
                                tue += 1;
                            }
                        }
                        //System.out.println(t.getModuleCode() + ", ClassType: " + t.getClassType() + ", Day: " + t.getDay() + ", " + t.getTeacherId());
                    } else if (classType == ClassType.LAB || classType == ClassType.WORKSHOP) {
                        if (t.getDay() == 0) {
                            if (thu > fri) {
                                t.setDay(6);
                                fri += 1;
                            } else {
                                t.setDay(5);
                                thu += 1;
                            }
                        }
                        //System.out.println(t.getModuleCode() + ", ClassType: " + t.getClassType() + ", Day: " + t.getDay() + ", " + t.getTeacherId());
                    }
                }
            }
        }
    }

    private void groupLectureClasses() {
        for (Module m : listOfModules) {
            List<Timeslot> groupableTimeslots;
            String moduleCode = m.getModuleCode();
            do {
                groupableTimeslots = getGroupableTimeslots(moduleCode);
                //System.out.println(" SIZE: " + groupableTimeslots.size());
                if (!groupableTimeslots.isEmpty()) {
                    Timeslot t = groupableTimeslots.get(0);

                    Timeslot tCopy = new Timeslot();
                    tCopy.setClassType(t.getClassType());
                    tCopy.setDay(t.getDay());
                    tCopy.setGroupCode(t.getGroupCode());
                    tCopy.setModuleCode(t.getModuleCode());
                    tCopy.setTeacherId(t.getTeacherId());
                    tCopy.setHours(t.getHours());

                    sortedTimeslot.remove(t); // might not work coz once an element is removed the index of element will change
                    t.setIsScheduled(true);

                    for (int i = 1; i < groupableTimeslots.size() && groupableTimeslots.size() > 1; i++) {
                        Timeslot ts = groupableTimeslots.get(i);

                        tCopy.setGroupCode(tCopy.getGroupCode() + "_" + ts.getGroupCode());

                        sortedTimeslot.remove(ts);
                        ts.setIsScheduled(true);
                    }
                    if (tCopy != null) {
                        groupedTimeslot.add(tCopy);
                    }
                }
            } while (!groupableTimeslots.isEmpty());
        }
    }

    private void scheduleTimetabe() throws SQLException, ClassNotFoundException {
        for (int day = 1; day <= Timeslot.FRI; day++) {
            Availability.resetResources();
            OccupiedTable.resetOccupiedResource();
            System.out.println("DAY " + day);
            for (Timeslot t : groupedAndSortedTimeslot) {
                ArrayList<String> groupCodes = t.getGroupCodes();
                String teacherId = t.getTeacherId();
                int classType = t.getClassType();
                double hours = t.getHours();

                if (t.getDay() == day && t.isIsOccupied() == false) {
                    System.out.println("AVAILABLE ROOMS TO ASSIGN " + Availability.getAvailableClassrooms());
                    System.out.println("AVAILABLE TEACHERS " + Availability.getAvailableTeachers());
                    boolean groupAvailability = Availability.isGroupsAvailable(groupCodes);
                    boolean teacherAvailability = Availability.isTeacherAvailable(teacherId);
                    boolean classroomAvailability = Availability.isRoomAvailableForType(classType);
                    if (groupAvailability && teacherAvailability && classroomAvailability) {
                        double startTime = (double) ((int) ((Math.random() * 2) + 7));    // random no. between 7 or 8
                        double endTime = startTime + hours;
                        String selectedClassroom = Availability.getClassroomForType(classType);
                        t.setRoomCode(selectedClassroom);
                        t.setStartTime(startTime);
                        t.setEndTime(endTime);

//                        System.out.println("CLASSROOM BEFORE REMOVE");
//                        System.out.println(Availability.getAvailableClassrooms());
                        Availability.getAvailableGroups().removeAll(groupCodes);
                        Availability.getAvailableTeachers().remove(teacherId);
                        Availability.getAvailableClassrooms().remove(selectedClassroom);

                        OccupiedTable.getOccupiedTeacher().put(teacherId, endTime);
                        OccupiedTable.getOccupiedClassroom().put(selectedClassroom, endTime);
                        for (String s : groupCodes) {
                            OccupiedTable.getOccupiedGroup().put(s, endTime);
                        }
//                        System.out.println("CLASSROOM AFTER REMOVE");
//                        System.out.println(Availability.getAvailableClassrooms());
//                        System.out.println("_________");
                        //System.out.println("SELECTED CLASSROOM " + selectedClassroom);
                    } else {
                        double startTime = (double) ((int) ((Math.random() * 2) + 7));    // random no. between 7 or 8;
                        double endTime = 0;
                        String selectedClassroom = "";
                        double gAvailabilityTime = 7;
                        double tAvailabilityTime = 7;

                        System.out.println("GROUP AVAILABILITY: " + Availability.isGroupsAvailable(t.getGroupCodes()));
                        if (!groupAvailability) {
                            System.out.println("Group " + t.getGroupCodes() + " will be available at " + OccupiedTable.getEndTimeForGroups(t.getGroupCodes()));
                            gAvailabilityTime = OccupiedTable.getEndTimeForGroups(groupCodes);
                            if (startTime < gAvailabilityTime) {
                                startTime = gAvailabilityTime;
                                System.out.println("So start time is " + startTime);
                            }
                        }
                        if(day == 5 && (t.getGroupCode().equals("L3C5") || t.getGroupCode().equals("L3C3")))
                            System.out.println("TEACHER AVAILABILITY: " + Availability.isTeacherAvailable(teacherId));
                        if (!teacherAvailability) {
                            System.out.println("Teacher " + t.getTeacherId() + " will be available at " + OccupiedTable.getEndTimeForTeacher(t.getTeacherId()));
                            tAvailabilityTime = OccupiedTable.getEndTimeForTeacher(teacherId);
                            if (startTime < tAvailabilityTime) {
                                startTime = tAvailabilityTime;
                                System.out.println("SO START TIME IS " + startTime);
                            }
                        }
                        System.out.println("AVAILABILITY OF ROOM : " + Availability.isRoomAvailableForType(classType));
                        if (!classroomAvailability) {
                            System.out.println(ClassTypeFactory.getClassType(classType).getTypeName() + " not found or is not available.");

                            List<String> possibleRoomSelection = RetrieveResources.getClassroomsForType(classType);
                            Collections.shuffle(possibleRoomSelection);
                            String roomCodeToSearch = "";
                            System.out.println("POSSIBLE ROOMS :  " + possibleRoomSelection);
                            //double max = OccupiedTable.getEndTimeForClassroom(possibleRoomSelection.get(0));
                            for (String room : possibleRoomSelection) {
                                double selectedTime = OccupiedTable.getEndTimeForClassroom(room);
                                if (startTime >= selectedTime && (selectedTime >= gAvailabilityTime && selectedTime >= tAvailabilityTime)) {
                                    startTime = selectedTime;
                                    roomCodeToSearch = room;
                                    break;
                                }
                            }

//                            if(roomCodeToSearch.isEmpty() || roomCodeToSearch == null){
//                                roomCodeToSearch = possibleRoomSelection.get(0);
//                                startTime = OccupiedTable.getEndTimeForClassroom(roomCodeToSearch);
//                            }
                            /*int randomSelection = (int)(Math.random() * possibleRoomSelection.size());
                             roomCodeToSearch = possibleRoomSelection.get(randomSelection);
                             startTime = OccupiedTable.getEndTimeForClassroom(roomCodeToSearch);*/
//                            
                            //String roomCodeToSearch = OccupiedTable.getOccupiedRoomForType(classType);
                            System.out.println("ROOM TO SEARCH " + roomCodeToSearch + " and the start time is " + startTime);
//                            if (startTime < OccupiedTable.getEndTimeForClassroom(roomCodeToSearch)) {
//                                startTime = OccupiedTable.getEndTimeForClassroom(roomCodeToSearch);
//                            }
                            selectedClassroom = roomCodeToSearch;
                        } else {
                            selectedClassroom = Availability.getClassroomForType(classType);
                            Availability.getAvailableClassrooms().remove(selectedClassroom);
                            System.out.println("SELECTED: " + selectedClassroom);
                        }
                        //System.out.println("SELECTED CLASSROOM " + selectedClassroom);
                        endTime = startTime + hours;
                        //System.out.println("START TIME: " + startTime + " HOURS: " + hours + " END TIME " + endTime);
                        t.setRoomCode(selectedClassroom);
                        t.setStartTime(startTime);
                        t.setEndTime(endTime);

                        //Availability.getAvailableGroups().removeAll(groupCodes);
                        //Availability.getAvailableTeachers().remove(teacherId);
                        //Availability.getAvailableClassrooms().remove(selectedClassroom);
                        // First remove the exisiting value and put the updated value
                        //System.out.println("SELECTE ROOM: " + selectedClassroom);
                        System.out.println("BEFORE REMOVE");
                        System.out.println(OccupiedTable.getOccupiedClassroom());

                        double selectedClassromCurrentEndTime = OccupiedTable.getEndTimeForClassroom(selectedClassroom);

                        /** 
                         * UPDATING THE OCCUPIED TABLE ONLY IF THE VALUE TO UPDATE IS HIGHER THEN CURRENT VALUE
                         * OR IF SOME RESOURCE ARE ALREADY AVAILABLE JUST REMOVE IT FROM AVAILABILITY AND ADD TO OCCUPIED
                         **/
                        if(groupAvailability){
                            for (String g : groupCodes) {
                                Availability.getAvailableGroups().remove(g);
                                OccupiedTable.getOccupiedGroup().put(g, endTime);
                            }
                        }else if (endTime > gAvailabilityTime) {
                            for (String g : groupCodes) {
                                OccupiedTable.getOccupiedGroup().remove(g);
                            }

                            for (String s : groupCodes) {
                                OccupiedTable.getOccupiedGroup().put(s, endTime);
                            }
                        }
                        
                        if(classroomAvailability){
                            Availability.getAvailableClassrooms().remove(selectedClassroom);
                            OccupiedTable.getOccupiedClassroom().put(selectedClassroom, endTime);
                        } else if (endTime > selectedClassromCurrentEndTime) {   // current or to occupied time is higher then only update
                            OccupiedTable.getOccupiedClassroom().remove(selectedClassroom);
                            OccupiedTable.getOccupiedClassroom().put(selectedClassroom, endTime);
                        }
                        
                        if(teacherAvailability){
                            Availability.getAvailableTeachers().remove(teacherId);
                            OccupiedTable.getOccupiedTeacher().put(teacherId, endTime);
                        }
                        if (endTime > tAvailabilityTime) {
                            OccupiedTable.getOccupiedTeacher().remove(teacherId);
                            OccupiedTable.getOccupiedTeacher().put(teacherId, endTime);
                        }
                        

                        //System.out.println("AVAILABLE ROOM " + Availability.getAvailableClassrooms());
                        System.out.println("AFTER ADD");
                        System.out.println(OccupiedTable.getOccupiedClassroom());
                    }
                    System.out.println(t + ", " + t.getStartTime() + " - " + t.getEndTime());

                    System.out.println("__________");
                }

            }
//            System.out.println("ROOMS ");
//            System.out.println(Availability.getAvailableClassrooms());
//            System.out.println(OccupiedTable.getOccupiedClassroom());
//            System.out.println("END OF THE DAY");
        }

        System.out.println("SCHEDULED");
        for (Timeslot t : groupedAndSortedTimeslot) {
            if (t.getDay() == Timeslot.SUN) {
                System.out.println(t + " " + RetrieveResources.getClassroomName(t.getRoomCode()) + ", " + t.getStartTime() + " - " + t.getEndTime());
            }
        }
    }

}
