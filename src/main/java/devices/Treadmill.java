package devices;

import home.Room;
import java.util.EnumMap;

public class Treadmill extends Device {
    /**
     * Electricity consumption of treadmill with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> ELECTRICITY_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 9);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 15);
            put(DeviceStatus.IDLE, 2);
            put(DeviceStatus.BROKEN, 0);
        }
    };

    private final static DeviceEnergyConsumption ENERGY_CONSUMPTION
            = new DeviceEnergyConsumption(
                    ELECTRICITY_CONSUMPTION,
                    Constants.NO_CONSUMPTION,
                    Constants.NO_CONSUMPTION
            );

    public Treadmill(String name, Room room) {
        super(name, room, ENERGY_CONSUMPTION);
    }

}
