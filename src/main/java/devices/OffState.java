package devices;

import events.devices.SwitchedOffEvent;
import events.devices.SwitchedOnEvent;

/**
 * Off state configuration of device
 */
public class OffState extends DeviceState {

    public OffState(Device device) {
        super(device);
        device.generateEvent(new SwitchedOffEvent(device, device.getRoom()));
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
        return false;
    }

    @Override
    public void repair() {
    }

    @Override
    public boolean turnOff() {
        return true;
    }

    @Override
    public boolean turnOn() {
        device.changeState(new OnState(device));
        device.generateEvent(new SwitchedOnEvent(device, device.getRoom()));
        return true;
    }

}
