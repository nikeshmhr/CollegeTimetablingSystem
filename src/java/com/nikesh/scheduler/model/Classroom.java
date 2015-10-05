package com.nikesh.scheduler.model;

import com.nikesh.scheduler.abstractor.ClassType;

/**
 *
 * @author Nikesh
 */
public class Classroom {

    private String roomCode;
    private String roomName;
    private ClassType roomType;
    private int capacity;

    public Classroom() {

    }

    public Classroom(String roomId, String roomName, ClassType roomType, int capacity) {
        this.roomCode = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ClassType getRoomType() {
        return roomType;
    }

    public void setRoomType(ClassType roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
