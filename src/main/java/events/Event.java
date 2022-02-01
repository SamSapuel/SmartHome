package events;

import api.HouseApi;
import home.Room;
import living.humans.*;

/**
 * Devices event class
 */
public abstract class Event {
    /**
     * Room where the event has been generated
     */
    private final Room eventRoom;

    private final int eventTime;
    /**
     * Source of this event
     */
    protected final EventGeneratorInterface eventGenerator;
    /**
     * Boolean signaling the event has been taken care of
     */
    private boolean handleable;

    private final EventType eventType;

    protected final String name;

    public Event(boolean handle, String name, EventGeneratorInterface eventGenerator, Room eventRoom, EventType type) {
        this.handleable = handle;
        this.name = name;
        this.eventGenerator = eventGenerator;
        this.eventRoom = eventRoom;
        this.eventType = type;
        eventTime = HouseApi.getCurrentLoop();
    }

    public Room eventRoom() {
        return eventRoom;
    }

    public boolean isHandleable() {
        return handleable;
    }

    public void setHandleable(boolean needsEvent) {
        handleable = needsEvent;
    }

    public  void handle(Father father) {
    }

    public void handle(Mother mother) {
    }

    public void handle(Son son) {
    }

    public void handle(Daughter daughter) {
    }

    @Override
    public String toString() {
        return "▽Event: " +
                "eventRoom = " + eventRoom +
                ", eventName = " + name +
                ", eventTime = " + eventTime + ", " +
                 eventGenerator + "->" + eventType +
                ", isNeedsEvent = " + handleable;
    }
}
