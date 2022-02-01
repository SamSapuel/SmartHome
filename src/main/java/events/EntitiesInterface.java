package events;

/**
 * Basic entity
 */
public interface EntitiesInterface extends EventGeneratorInterface{
    /**
     * Updates an entity state, updates state for report, and living entities may move or perform activity
     */
    void update();
}
