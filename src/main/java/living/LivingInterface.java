package living;

import events.EntitiesInterface;
import home.Room;

/**
 * Living entity which can move and interact
 */
public interface LivingInterface extends EntitiesInterface {
    /**
     *
     * @return current room
     */
    Room getRoom();

    /**
     * Moves an entity into another room
     * @param room to go to
     */
    void move(Room room);

}
