package devices;

/**
 * Device states
 */
public abstract class DeviceState {

    protected final Device device;

    public DeviceState(Device device) {
        this.device = device;
    }

    /**
     *
     * @return true if device gets used
     */
    public abstract boolean useDevice();

    /**
     * Updates an entity state, updates state for report
     */
    public abstract void update();

    /**
     * See if the device is broken or not
     * @return boolean
     */
    public abstract boolean isBroken();

    /**
     * Repair broken device
     */
    public abstract void repair();

    /**
     *
     * @return true if action was successful
     */
    public abstract boolean turnOff();

    /**
     *
     * @return true if action was successful
     */
    public abstract boolean turnOn();

}
