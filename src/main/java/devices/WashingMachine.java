package devices;

import home.Room;
import java.util.EnumMap;

public class WashingMachine extends Device {
    /**
     * Electricity consumption of washingmachine with different statuses
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

    /**
     * Water consumption of washingmachine with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> WATER_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 60);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 140);
            put(DeviceStatus.IDLE, 6);
            put(DeviceStatus.BROKEN, 0);
        }
    };

    private final static DeviceEnergyConsumption ENERGY_CONSUMPTION
            = new DeviceEnergyConsumption(
                ELECTRICITY_CONSUMPTION,
                Constants.NO_CONSUMPTION,
                WATER_CONSUMPTION
            );

    public WashingMachine(String name, Room room) {
        super(name, room, ENERGY_CONSUMPTION);
    }

}
