
package events.devices;

import events.Event;
import events.EventGeneratorInterface;
import events.EventType;
import home.Room;

public class DeviceUnusableEvent extends Event {

    public DeviceUnusableEvent(EventGeneratorInterface eventGenerator, Room eventRoom) {
        super(false, "Unusable device", eventGenerator, eventRoom, EventType.DEVICE_UNUSABLE);
    }

}
