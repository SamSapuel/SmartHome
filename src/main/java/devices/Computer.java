package devices;

import home.Room;
import java.util.EnumMap;

public class Computer extends Device {
    /**
     * Electricity consumption of computer with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> ELECTRICITY_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 10);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 14);
            put(DeviceStatus.IDLE, 6);
            put(DeviceStatus.BROKEN, 0);
        }
    };

    private final static DeviceEnergyConsumption ENERGY_CONSUMPTION
            = new DeviceEnergyConsumption(
                    ELECTRICITY_CONSUMPTION,
                    Constants.NO_CONSUMPTION,
                    Constants.NO_CONSUMPTION
            );

    public Computer(String name, Room room) {
        super(name, room, ENERGY_CONSUMPTION);
    }

}
