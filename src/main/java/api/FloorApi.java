package api;

import home.Floor;
import java.util.List;

public class FloorApi {

    /**
     * Create a floor
     *
     * @param roomNames names of rooms that belongs to current floor
     * @param floorNumber number of current floor
     * @return floor
     */
    public Floor createFloor(List<String> roomNames, int floorNumber) throws Exception {
        Floor floor = new Floor(floorNumber);
        RoomApi room = new RoomApi();
        for (String roomName : roomNames) {
            floor.addRoom(room.newRoom(roomName, floorNumber));
        }
        return floor;
    }

}
