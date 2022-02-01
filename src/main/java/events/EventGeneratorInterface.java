package events;

/**
 * Generation of events interface
 */
public interface EventGeneratorInterface {

    /**
     * Generate device event
     * @param event
     */
    void generateEvent(Event event);

    /**
     * Returns a name of the entity as a String
     * @return name of the entity
     */
    String getName();

}
