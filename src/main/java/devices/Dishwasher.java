package devices;

import home.Room;
import java.util.EnumMap;

public class Dishwasher extends Device {
    /**
     * Electricity consumption of dishwasher with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> ELECTRICITY_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 14);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 6);
            put(DeviceStatus.IDLE, 6);
            put(DeviceStatus.BROKEN, 0);
        }
    };

    /**
     * Water consumption of dishwasher with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> WATER_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 10);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 50);
            put(DeviceStatus.IDLE, 5);
            put(DeviceStatus.BROKEN, 0);
        }
    };

    private final static DeviceEnergyConsumption ENERGY_CONSUMPTION
            = new DeviceEnergyConsumption(
                    ELECTRICITY_CONSUMPTION,
                    Constants.NO_CONSUMPTION,
                    WATER_CONSUMPTION
            );

    public Dishwasher(String name, Room room) {
        super(name, room, ENERGY_CONSUMPTION);
    }


}
