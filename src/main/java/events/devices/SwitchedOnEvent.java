package events.devices;

import events.Event;
import events.EventGeneratorInterface;
import events.EventType;
import home.Room;

public class SwitchedOnEvent extends Event {

    public SwitchedOnEvent(EventGeneratorInterface eventGenerator, Room eventRoom) {
        super(false, "SwitchedOnEvent", eventGenerator, eventRoom, EventType.SWITCHED_ON);
    }

}
