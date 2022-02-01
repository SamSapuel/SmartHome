package devices;

import java.util.Random;

/**
 * Idle state configuration of device
 */
public class IdleState extends DeviceState {

    public IdleState(Device device) {
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
                .incrementElectricityConsumed(device.energyConsumption.getElectricityUsage(DeviceStatus.IDLE));
        device.deviceReportService
                .incrementGasConsumed(device.energyConsumption.getGasUsage(DeviceStatus.IDLE));
        device.deviceReportService
                .incrementWaterConsumed(device.energyConsumption.getWaterUsage(DeviceStatus.IDLE));
        device.deviceReportService.incrementUseCounter();
        if (new Random().nextInt(100) < 1) {
            device.changeState(new BrokenState(device));
        }
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
        device.changeState(new OnState(device));
        return true;
    }

}
