
package events.devices;

import events.Event;
import events.EventGeneratorInterface;
import events.EventType;
import home.Room;

public class UsedDeviceEvent extends Event {

    public UsedDeviceEvent(EventGeneratorInterface eventGenerator, Room eventRoom) {
        super(false, "Used device", eventGenerator, eventRoom, EventType.DEVICE_USED);
    }

}
