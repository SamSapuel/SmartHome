package events;
/**
 * Devices event types
 */
public enum EventType {
    BROKEN("Device is broken", true),
    DEVICE_UNUSABLE("Couldn't use device", true),
    OUT_OF_CONTENT("Device has no content inside", true),
    DEVICE_REPAIRED("Device is repaired", false),
    MOTION_CHANGES("Device has sensed a motion", true),
    PET_NEEDS_FOOD("Pet needs food", true),
    SWITCHED_ON("Device was switched on", false),
    SWITCHED_OFF("Device was swithced off", false),
    DEVICE_USED("Device was used", false);

    private String message;
    private boolean needsEvent;

    EventType(String message, boolean needsEvent) {
        this.message = message;
        this.needsEvent = needsEvent;
    }

    public String getMessage() {
        return message;
    }

    public boolean isNeedsEvent() {
        return needsEvent;
    }
}
