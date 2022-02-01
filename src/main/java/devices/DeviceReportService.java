package devices;

/**
 * Report service which contains all info about devices history
 */
public class DeviceReportService {
    private int useCount;
    private int electricityConsumed;
    private int gasConsumed;
    private int waterConsumed;

    public DeviceReportService() {
        this.useCount = 0;
        this.electricityConsumed = 0;
        this.gasConsumed = 0;
        this.waterConsumed = 0;
    }

    /**
     * Increments total number of times this device has been used
     */
    public void incrementUseCounter() {
        useCount++;
    }

    /**
     * Increments total electricity units consumed
     * @param consumed to increment
     */
    public void incrementElectricityConsumed(int consumed) {
        electricityConsumed += consumed;
    }
    /**
     * Increments total gas units consumed
     * @param consumed to increment
     */
    public void incrementGasConsumed(int consumed) {
        gasConsumed += consumed;
    }
    /**
     * Increments total water units consumed
     * @param consumed to increment
     */
    public void incrementWaterConsumed(int consumed) {
        waterConsumed += consumed;
    }

    public int getUseCount() {
        return useCount;
    }

    public int getElectricityConsumed() {
        return electricityConsumed;
    }

    public int getGasConsumed() {
        return gasConsumed;
    }

    public int getWaterConsumed() {
        return waterConsumed;
    }
}
