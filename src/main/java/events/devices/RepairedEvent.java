package events.devices;

import devices.DeviceInterface;
import events.Event;
import events.EventType;
import home.Room;

public class RepairedEvent extends Event {

    public RepairedEvent(DeviceInterface eventGenerator, Room eventRoom) {
        super(false, "BrokenEvent", eventGenerator, eventRoom, EventType.DEVICE_REPAIRED);
    }

}
