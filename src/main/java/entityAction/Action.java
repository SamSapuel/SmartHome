package entityAction;

/**
 * Humans action class
 */

public class Action {

    /**
     * Entity that has handled the event generating this action
     */
    private String owner;

    /**
     * Entity that was handled in the event generating this action
     */
    private String goal;

    private ActionType actionType;

    public Action(String owner, String goal, ActionType actionType) {
        this.owner = owner;
        this.goal = goal;
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "◉Who: " + owner + "-> What did: " + actionType.getMessage() + " -> " + goal;
    }
}
