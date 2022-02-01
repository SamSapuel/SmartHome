package devices;

import home.Room;
import java.util.EnumMap;

public class Fridge extends Device {
    /**
     * Electricity consumption of fridge with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> ELECTRICITY_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 12);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 0);
            put(DeviceStatus.IDLE, 4);
            put(DeviceStatus.BROKEN, 0);
        }
    };
    /**
     * Gas consumption of fridge with different statuses
     */
    private final static EnumMap<DeviceStatus, Integer> GAS_CONSUMPTION
            = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 10);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 0);
            put(DeviceStatus.IDLE, 7);
            put(DeviceStatus.BROKEN, 0);
        }
    };

    private final static DeviceEnergyConsumption ENERGY_CONSUMPTION
            = new DeviceEnergyConsumption(
                    ELECTRICITY_CONSUMPTION,
                    GAS_CONSUMPTION,
                    Constants.NO_CONSUMPTION
            );


    private static final int CAPACITY = 10;
    private int content;

    public Fridge(String name, Room room) {
        super(name, room, ENERGY_CONSUMPTION);
        content = CAPACITY/2;
    }


}
