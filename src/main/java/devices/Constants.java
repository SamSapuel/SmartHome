package devices;

import java.util.EnumMap;
import java.util.Map;

public class Constants {
    /**
     * Default consumption of device with different statuses
     */
    public static Map<DeviceStatus, Integer> NO_CONSUMPTION = new EnumMap<DeviceStatus, Integer>(DeviceStatus.class) {
        {
            put(DeviceStatus.ON, 0);
            put(DeviceStatus.OFF, 0);
            put(DeviceStatus.IN_USE, 0);
            put(DeviceStatus.IDLE, 0);
            put(DeviceStatus.BROKEN, 0);
        }
    };

}
