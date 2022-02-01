package living.strategy;

import devices.DeviceInterface;
import entityAction.ActionType;
import home.Room;

/**
 * Strategy interface for living entities
 */
public interface StrategyInterface {
    /**
     * Gets random room
     * @return random room in house
     */
    Room getRandomRoom();
    /**
     * Get device the entity wants to use next
     * @return next device to use
     */
    DeviceInterface getDeviceToUse();
    /**
     * Gets an action type for next use of this strategy
     */
    ActionType getActionType();

}
