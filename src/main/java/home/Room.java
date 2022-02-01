package home;

import devices.Device;
import living.Living;
import java.util.ArrayList;
import java.util.List;

/**
 * Room class, part of house tree hierarchy
 */
public class Room {


    private final String roomName;
    /**
     * List of all devices in room
     */
    private List<Device> devices;
    /**
     * Number of floor on which the room is on
     */
    private int floorNumber;
    /**
     * List of all living entities in room
     */
    private List<Living> occupants;

    public Room(String roomName, List<Device> devices, int floorNumber, List<Living> livings) {
        this.roomName = roomName;
        this.devices = devices;
        this.floorNumber = floorNumber;
        this.occupants = livings;
    }

    public Room(String roomName, List<Device> devices, int floorNumber) {
        this.roomName = roomName;
        this.devices = devices;
        this.floorNumber = floorNumber;
        occupants = new ArrayList<>();
    }

    public Room(String roomName, int floorNumber) {
        this.roomName = roomName;
        this.floorNumber = floorNumber;
        devices = new ArrayList<>();
        occupants = new ArrayList<>();
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<Living> getOccupants() {
        return occupants;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setOccupants(List<Living> occupants) {
        this.occupants = occupants;
    }

    public void setLivings(Living living) {
        occupants.add(living);
    }

    public void removeFromRoom(Living living) {
        occupants.remove(living);
    }

    /**
     * Update all entities in room
     */
    public void update() {
        for (Device device : devices) {
            device.update();
        }
    }

    @Override
    public String toString() {
        return roomName;

    }
}
