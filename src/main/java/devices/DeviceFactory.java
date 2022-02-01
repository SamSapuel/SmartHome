package devices;

import home.Room;

/**
 * Сlass for creating devices, implemented using factory pattern
 */
public class DeviceFactory {

    public Device createComputer(String name, Room room) {
        return new Computer(name, room);
    }

    public Device createFridge(String name, Room room) {
        return new Fridge(name, room);
    }

    public Device createGameConsole(String name, Room room) {
        return new GameConsole(name, room);
    }

    public Device createTelevision(String name, Room room) {
        return new Television(name, room);
    }

    public Device createTreadmill(String name, Room room) {
        return new Treadmill(name, room);
    }

    public Device createWashingMachine(String name, Room room) {
        return new WashingMachine(name, room);
    }

    public Device createDishwasher(String name, Room room) {
        return new Dishwasher(name, room);
    }

}
