package reports;

import api.HouseApi;

/**
 * Report service taking care of all sub report services.
 */
public class ReportService {

    private ActionReportService actionReportService;
    private EventReportService eventReportService;
    private HouseConfigReportService houseConfigReportService;
    private ConsumptionReportService consumptionReportService;

    private String houseReport;
    private String eventReport;
    private String actionReport;
    private String consumptionReport;

    public ReportService() {
        actionReportService = new ActionReportService();
        eventReportService = new EventReportService();
        houseConfigReportService = new HouseConfigReportService();
        consumptionReportService = new ConsumptionReportService();

    }

    public ActionReportService getActionReportService() {
        return actionReportService;
    }

    public EventReportService getEventReportService() {
        return eventReportService;
    }

    public void generateReports() {
        houseReport = houseConfigReportService.generateHouseReport(HouseApi.getInstance().getHouse());
        eventReport = eventReportService.generateEventReport();
        actionReport = actionReportService.generateActionReport();
        consumptionReport = consumptionReportService.generateReport();
        System.out.println(houseReport);
        System.out.println(actionReport);
        System.out.println(eventReport);
        System.out.println(consumptionReport);

        ReportSaverToTxt.saveToFile("HouseReport.txt", houseReport);
        ReportSaverToTxt.saveToFile("EventReport.txt", eventReport);
        ReportSaverToTxt.saveToFile("ActionReport.txt", actionReport);
        ReportSaverToTxt.saveToFile("Consumption.txt", consumptionReport);

    }
}
