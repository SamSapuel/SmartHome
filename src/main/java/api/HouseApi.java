package api;

import events.EntitiesInterface;
import events.EventService;
import home.Floor;
import home.House;
import home.Room;
import living.LivingInterface;
import reports.ReportService;

import java.util.*;

/**
 * Main api taking care of whole smart home simulation
 */
public class HouseApi {

    private boolean running;
    /**
     * Only instance of this class
     */
    private static HouseApi houseApi;
    /**
     * Event service handling all events
     */
    private final EventService eventService;
    /**
     * Floor api for creating rooms
     */
    private FloorApi floorApi;
    /**
     * Report service handling all report and statistics
     */
    private ReportService reportService;
    /**
     * House instance for composed entity hierarchy
     */
    private House house;
    /**
     * List of all living entities in this home
     */
    private List<LivingInterface> livings;

    private int loopsToRun;
    private static int currentLoop = 1;
    private int configNumber;

    /**
     * Constructor for class
     */
    public HouseApi() {
        this.reportService = new ReportService();
        this.eventService = new EventService(this);
    }

    /**
     * Get a singleton instance of api
     * @return SmartHomeApi instance
     */
    public static synchronized HouseApi getInstance() {
        if (houseApi == null) {
            houseApi = new HouseApi();
        }
        return houseApi;
    }

    /**
     * Create a house
     * @param floors that the house has
     * @return House house - our house
     */
    public House createHouse(int floors, int config) throws Exception {
        house = House.getInstance();
        floorApi = new FloorApi();
        Random random = new Random();
        configNumber = config;
        for (int i = 0; i < floors; i++) {
            List<String> roomNames = new ArrayList<>();
            switch (random.nextInt(3)) {
                case 0:
                    roomNames.add("LivingRoom");
                    roomNames.add("Kitchen");
                    house.addFloor(floorApi.createFloor(roomNames, i));
                    break;
                case 1:
                    roomNames.add("LivingRoom");
                    roomNames.add("BedRoom#1");
                    roomNames.add("Kitchen");
                    house.addFloor(floorApi.createFloor(roomNames, i));
                    break;
                case 2:
                    roomNames.add("BedRoom#2");
                    roomNames.add("Kitchen");
                    roomNames.add("Attic");
                    house.addFloor(floorApi.createFloor(roomNames, i));
                    break;
            }
        }
        System.out.println("=============================================================\n" +
                "House was created\n" +
                "=============================================================");
        return house;
    }

    /**
     * Start the smarthome simulation
     */
    public void startSimulation() {
        running = true;
        livings = new ArrayList<>();

        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                livings.addAll(room.getOccupants());
            }
        }
        System.out.println("Enter number of simulation cycles:");
        Scanner scanner = new Scanner(System.in);
        try {
            loopsToRun = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number of loops to run, in digits.");
            return;
        }
        while (loopsToRun > 0) {
            livings.forEach(EntitiesInterface::update);
            house.update();
            loopsToRun--;
            currentLoop++;
        }
        scanner.close();
        System.out.println("What happened during this time:\n");
        reportService.generateReports();
    }

    public boolean isRunning() {
        return running;
    }

    public static int getCurrentLoop() {
        return currentLoop;
    }

    /**
     * Get instance of event service
     * @return event service instance
     */
    public EventService getEventService() {
        return eventService;
    }

    /**
     * Get instance of report service
     * @return report service instance
     */
    public ReportService getReportService() {
        return reportService;
    }

    public List<LivingInterface> getLivings() {
        return livings;
    }

    public House getHouse() {
        return house;
    }

    /**
     * Get configuration number of current house
     * @return config number
     */
    public int getConfigNumber() {
        return configNumber;
    }
}
