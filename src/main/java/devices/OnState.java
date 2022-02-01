package devices;

import java.util.Random;

/**
 * On state configuration of device
 */
public class OnState extends DeviceState {

    public OnState(Device device) {
        super(device);
    }

    @Override
    public boolean useDevice() {
        device.changeState(new InUseState(device));
        return true;
    }

    @Override
    public void update() {
        device.deviceReportService
                .incrementElectricityConsumed(device.energyConsumption.getElectricityUsage(DeviceStatus.ON));
        device.deviceReportService
                .incrementGasConsumed(device.energyConsumption.getGasUsage(DeviceStatus.ON));
        device.deviceReportService
                .incrementWaterConsumed(device.energyConsumption.getWaterUsage(DeviceStatus.ON));
        device.deviceReportService.incrementUseCounter();
        if (new Random().nextInt(100) < 2) {
                device.changeState(new BrokenState(device));
                return;
        }
        device.changeState(new IdleState(device));
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
        device.changeState(new OffState(device));
        return true;
    }

    @Override
    public boolean turnOn() {
        return true;
    }

}
