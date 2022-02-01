package reports;

import entityAction.Action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Action report service for generating reports from data
 */
public class ActionReportService {

    private final List<Action> actions;

    public ActionReportService() {
        actions = new ArrayList<>();
    }
    /**
     * Register new action to report service
     * @param action to be saved
     */
    public void registerAction(Action action) {
        actions.add(action);
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }

    /**
     * Generate a report from data
     * @return String report
     */
    public String generateActionReport() {
        StringBuilder stringBuilder = new StringBuilder();
        actions.forEach(action -> {
            stringBuilder.append(action.toString()).append("\n");
        });
        return stringBuilder.toString();
    }

}
