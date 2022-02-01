package home;

import devices.Device;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing house with all its content
 */
public class House {

    private static House instance;
    private List<Floor> floors;

    private House() {
        floors = new ArrayList<>();
    }

    /**
     * Get a singleton instance of house
     * @return House instance
     */
    public static House getInstance() {
        if (instance == null) {
            instance = new House();
        }
        return instance;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public int getNumberOfFloors() {
        return floors.size();
    }

    public Floor getFloor(int index) {
        return floors.get(index);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        floors.forEach(floor -> {
            floor.getRooms().forEach(room -> {
                devices.addAll(room.getDevices());
            });
        });
        return devices;
    }

    public void update() {
        for (Floor floor : floors) {
            floor.update();
        }
    }

    @Override
    public String toString() {
        return "House:" + "\n" +
                "floors=" + floors.toString();
    }
}
