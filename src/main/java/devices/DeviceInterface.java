package devices;

import events.EventGeneratorInterface;
import home.Room;
/**
 * Basic device
 */
public interface DeviceInterface extends EventGeneratorInterface {
    /**
     * Get room where the device is located
     * @return room
     */
    Room getRoom();
    /**
     * Get type of the device
     * @return type of device
     */
    DeviceType getDeviceType();

    void setDeviceType(DeviceType deviceType);

    void update();
    /**
     * Use this device and update its inner state
     */
    void useDevice();

    boolean turnOn();

    boolean turnOff();
    /**
     * Repairs the device
     */
    void repair();

    /**
     * Get electricity consumption
     * @return electricity consumed
     */
    int getElectricityConsumed();
    /**
     * Get gas consumption
     * @return gas consumed
     */
    int getGasConsumed();
    /**
     * Get water consumption
     * @return water consumed
     */
    int getWaterConsumed();

}
