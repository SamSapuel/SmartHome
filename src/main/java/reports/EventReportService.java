package reports;

import events.Event;
import java.util.ArrayList;
import java.util.List;
/**
 * Event report service for storing event information and generating event reports
 */
public class EventReportService {
    private final List<Event> eventList;

    public EventReportService() {
        eventList = new ArrayList<>();
    }

    /**
     * Report event to be registered by report service
     * @param event to be saved
     */
    public void reportEvent(Event event) {
        eventList.add(event);
    }

    /**
     * Generate a report from data
     * @return String report
     */
    public String generateEventReport() {
        StringBuilder stringBuilder = new StringBuilder();
        eventList.forEach(event -> {
            stringBuilder.append(event.toString()).append("\n");
        });
        return stringBuilder.toString();
    }
}
