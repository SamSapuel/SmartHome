package devices;

import events.devices.BrokenEvent;
import events.devices.DeviceUnusableEvent;
import events.devices.RepairedEvent;

/**
 * Broken state configuration of device
 */
public class BrokenState extends DeviceState {

    public BrokenState(Device device) {
        super(device);
        device.generateEvent(new BrokenEvent(device, device.getRoom()));
    }

    @Override
    public boolean useDevice() {
        return false;
    }

    @Override
    public void update() {
    }

    @Override
    public boolean isBroken() {
        return true;
    }

    @Override
    public void repair() {
        device.generateEvent(new RepairedEvent(device, device.getRoom()));
        device.changeState(new IdleState(device));
    }

    @Override
    public boolean turnOff() {
        device.generateEvent(new DeviceUnusableEvent(device, device.getRoom()));
        return false;
    }

    @Override
    public boolean turnOn() {
        device.generateEvent(new DeviceUnusableEvent(device, device.getRoom()));
        return false;
    }

}
