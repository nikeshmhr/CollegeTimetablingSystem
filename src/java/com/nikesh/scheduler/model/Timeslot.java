package com.nikesh.scheduler.model;

import java.util.ArrayList;

/**
 *
 * @author Nikesh
 */
public class Timeslot {

    private int day;
    private String teacherId;
    private String moduleCode;
    private int classType;
    private String groupCode;
    private String roomCode;
    private int year, sem;
    private boolean isScheduled; // for particular teacher, module, classtype, day, and group code.
    private boolean isOccupied; // for classroom, startTime and endTime.
    private double startTime, endTime;
    private double hours;
    public static final int SUN = 1, MON = 2, TUE = 3, WED = 4, THU = 5, FRI = 6;

    public Timeslot() {
        day = 0;
        classType = 0;
        year = sem = 0;
        isScheduled = false;
        isOccupied = false;
        startTime = 0;
        endTime = 0;
        hours = 0;
    }

    public int getDay() {
        return day;
    }

    public String getDayString() {
        switch (this.day) {
            case 1:
                return "SUNDAY";

            case 2:
                return "MONDAY";

            case 3:
                return "TUESDAY";

            case 4:
                return "WEDNESDAY";

            case 5:
                return "THURSDAY";

            case 6:
                return "FRIDAY";

            default:
                return "SATURDAY";
        }
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public boolean isIsScheduled() {
        return isScheduled;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public ArrayList<String> getGroupCodes() {
        ArrayList<String> codes = new ArrayList<String>();

        String[] splits = groupCode.split("_");
        for (int i = 0; i < splits.length; i++) {
            codes.add(splits[i]);
        }

        return codes;
    }

    @Override
    public String toString() {
        return teacherId + ", " + moduleCode + ", " + groupCode + ", " + classType + ", Day: " + getDayString() + ", Hours: " + hours;
    }

    public String getStartTimeString() {
        return convertTimeToString(startTime);
    }

    public String getEndTimeString() {
        return convertTimeToString(endTime);
    }

    private String convertTimeToString(double time) {
        String timeString = "";
        double timeHour = time;

        int timeMinutes = (int) (timeHour * 60);

        String convertedHour = (timeMinutes / 60) + "";
        if (Integer.parseInt(convertedHour) < 10) {
            convertedHour = "0" + convertedHour;
        }

        String convertedMinutes = (timeMinutes % 60) + "";
        if (Integer.parseInt(convertedMinutes) < 10) {
            convertedMinutes = "0" + convertedMinutes;
        }

        timeString = convertedHour + ":" + convertedMinutes;

        return timeString;

    }

}
