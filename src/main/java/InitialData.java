import api.HouseApi;
import home.House;

public class InitialData {

    private int currentTime;

    public void init() throws Exception {
        currentTime = (int) System.nanoTime();
        // Create our house
        House house = HouseApi.getInstance().createHouse(3, 1);
        // Start smarthome simulation
        HouseApi.getInstance().startSimulation();
    }

    public int getCurrentTime() {
        return currentTime;
    }
}
