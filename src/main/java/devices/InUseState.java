package devices;

import events.devices.UsedDeviceEvent;
import java.util.Random;

/**
 * In use state configuration of device
 */
public class InUseState extends DeviceState {

    public InUseState(Device device) {
        super(device);
        device.generateEvent(new UsedDeviceEvent(device, device.getRoom()));
    }

    @Override
    public boolean useDevice() {
        return false;
    }

    @Override
    public void update() {
        device.deviceReportService
                .incrementElectricityConsumed(device.energyConsumption.getElectricityUsage(DeviceStatus.IN_USE));
        device.deviceReportService
                .incrementGasConsumed(device.energyConsumption.getGasUsage(DeviceStatus.IN_USE));
        device.deviceReportService
                .incrementWaterConsumed(device.energyConsumption.getWaterUsage(DeviceStatus.IN_USE));
        device.deviceReportService.incrementUseCounter();
        if (new Random().nextInt(100) < 3) {
                device.changeState(new BrokenState(device));
                return;
        }
        device.changeState(new OnState(device));
    }

    @Override
    public boolean isBroken() {
        return false;
    }

    @Override
    public void repair() {
    }

    @Override
    public boolean turnOff() {
        return false;
    }

    @Override
    public boolean turnOn() {
        return true;
    }

}
