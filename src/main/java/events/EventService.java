package events;

import api.HouseApi;
import reports.ActionReportService;
import reports.EventReportService;

import java.util.ArrayList;
import java.util.List;
/**
 * Service taking care of event handling and sending reports to event and action report services
 */
public class EventService {

    private List<Event> eventList;
    private List<EventListener> listeners;
    private final EventReportService eventReportService;
    private final ActionReportService actionReportService;

    public EventService(HouseApi houseApi) {
        eventList = new ArrayList<>();
        listeners = new ArrayList<>();
        eventReportService = houseApi.getReportService().getEventReportService();
        actionReportService = houseApi.getReportService().getActionReportService();

    }

    /**
     * Register new event that happened and notify all listeners
     * @param event to register and pass to listener
     */
    public void registerEvent(Event event) {
        eventList.add(event);
        if (event.isHandleable()) {
            notifyListeners(event);
        }
        eventReportService.reportEvent(event);
    }

    public void subscribe(EventListener eventListener) {
        if (!listeners.contains(eventListener)) listeners.add(eventListener);
    }

    public List<Event> getEventList() {
        return eventList;
    }

    /**
     * Notify all listeners for every event in queue nad empty queue
     */
    private void notifyListeners(Event event) {
        listeners.forEach(listener -> listener.react(event));
        eventList = new ArrayList<>();
    }

}
