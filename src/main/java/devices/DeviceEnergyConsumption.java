package devices;

import java.util.Map;

/**
 * Energy consumption of device
 */
public class DeviceEnergyConsumption {

    private Map<DeviceStatus, Integer> electricityUsage;
    private Map<DeviceStatus, Integer> gasUsage;
    private Map<DeviceStatus, Integer> waterUsage;

    public DeviceEnergyConsumption(Map<DeviceStatus, Integer> electricityUsage, Map<DeviceStatus, Integer> gasUsage, Map<DeviceStatus, Integer> waterUsage) {
        this.electricityUsage = electricityUsage;
        this.gasUsage = gasUsage;
        this.waterUsage = waterUsage;
    }

    public Integer getElectricityUsage(DeviceStatus status) {
        return electricityUsage.get(status);
    }

    public Integer getGasUsage(DeviceStatus status) {
        return gasUsage.get(status);
    }

    public Integer getWaterUsage(DeviceStatus status) {
        return waterUsage.get(status);
    }

}
