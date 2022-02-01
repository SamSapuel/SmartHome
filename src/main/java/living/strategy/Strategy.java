package living.strategy;

import api.HouseApi;
import devices.Device;
import devices.DeviceInterface;
import devices.DeviceType;
import entityAction.ActionType;
import home.Floor;
import home.House;
import home.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Strategy abstract class
 */
public abstract class Strategy implements StrategyInterface{

    protected House house;
    protected HouseApi houseApi;

    protected List<Device> devices;

    public Strategy() {
        house = HouseApi.getInstance().getHouse();
        devices = house.getAllDevices();
    }

    /**
     * Get a random room from house
     * @return random room
     */
    public Room getRandomRoom() {
        Room randomRoom = null;
        while (randomRoom == null) {
            Floor floor = house.getFloor((int) (Math.random()*house.getFloors().size()));
            randomRoom = floor.getRoom((int) (Math.random()*floor.getRooms().size()));
        }
        return randomRoom;
    }

    public DeviceInterface getDeviceByType(DeviceType type) {
        List<DeviceInterface> possibleGoals = new ArrayList<>();
        for (DeviceInterface device : devices) {
            if(type == DeviceType.DEFAULTTYPE_DEVICE) {
                if(device.getDeviceType() != DeviceType.NON_USABLE) {
                    possibleGoals.add(device);
                }
            } else if(device.getDeviceType() == type) {
                possibleGoals.add(device);
            }
        }
        if(possibleGoals.isEmpty()) {
            return null;
        }

        /**
         *  Return one random device from all possible
         */
        return possibleGoals.get(Math.abs(new Random().nextInt() % possibleGoals.size()));
    }

    @Override
    public ActionType getActionType() {
        return ActionType.USE;
    }
}
