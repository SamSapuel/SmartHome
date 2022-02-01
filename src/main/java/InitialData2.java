import api.HouseApi;
import home.House;

public class InitialData2 {

    private int currentTime;

    public void init() throws Exception {
        currentTime = (int) System.nanoTime();
        // Create our house
        House house = HouseApi.getInstance().createHouse(2, 2);
        // Start smarthome simulation
        HouseApi.getInstance().startSimulation();
    }

    public int getCurrentTime() {
        return currentTime;
    }
}
