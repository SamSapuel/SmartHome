package entityAction;

/**
 * Humans actions
 */
public enum ActionType {
    COMPLAIN("complained about"),
    USE("used"),
    FIX("fixed"),
    EAT("ate food"),
    TURN_ON("turned on"),
    TURN_OFF("turned off"),
    MOVE("moved"),
    GET_ITEM("got item"),
    PET_A_PET("pet");

    private String message;

    ActionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
