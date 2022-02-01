package events.devices;

import devices.DeviceType;
import events.Event;
import events.EventGeneratorInterface;
import events.EventType;
import home.Room;

public class SwitchedOffEvent extends Event {

    public SwitchedOffEvent(EventGeneratorInterface eventGenerator, Room eventRoom) {
        super(false, "SwitchedOnEvent", eventGenerator, eventRoom, EventType.SWITCHED_OFF);
    }

}
