package home;

import java.util.ArrayList;
import java.util.List;

/**
 * House floor class, part of house tree hierarchy
 */
public class Floor {

    private List<Room> rooms;
    private final int floorNumber;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int getRoomsNumber() {
        return rooms.size();
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public List<Room> getRooms () {
        return rooms;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void update() {
        for (Room room : rooms) {
            room.update();
        }
    }

    @Override
    public String toString() {
        return "Floor #" + floorNumber + ":" + "\n" +
                "rooms=" + rooms;
    }
}
