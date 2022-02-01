package api;

import devices.*;
import home.Room;

import java.util.*;

public class RoomApi {

    private Room room;

    /**
     * Create a room
     *
     * @param name room name
     * @param floor floor number
     * @return new room that belongs to floor
     */
    public Room newRoom(String name, int floor) throws Exception {
        room = new Room(name, floor);
        List<Device> devices = new ArrayList<>();
        Random random = new Random();
        DeviceFactory deviceFactory = new DeviceFactory();
        LivingApi livingApi = new LivingApi();
        
        for (int i = 0; (int) (Math.random() * (1 + 2) + 1) > i; i++) {
            switch (random.nextInt(7)) {
                case 0:
                    Device fridge = deviceFactory.createFridge("fridge1", room);
                    fridge.setDeviceType(DeviceType.FOOD_DEVICE);
                    devices.add(fridge);
                    livingApi.addLivingToRoom(room);
                    break;
                case 1:
                    Device gameConsole = deviceFactory.createGameConsole("PS4", room);
                    gameConsole.setDeviceType(DeviceType.ENTERTAINMENT_DEVICE);
                    devices.add(gameConsole);
                    livingApi.addLivingToRoom(room);
                    break;
                case 2:
                    Device television = deviceFactory.createTelevision("Panasonic", room);
                    television.setDeviceType(DeviceType.ENTERTAINMENT_DEVICE);
                    devices.add(television);
                    livingApi.addLivingToRoom(room);
                    break;
                case 3:
                    Device treadmill = deviceFactory.createTreadmill("Runner 3000", room);
                    treadmill.setDeviceType(DeviceType.SPORT_DEVICE);
                    devices.add(treadmill);
                    livingApi.addLivingToRoom(room);
                    break;
                case 4:
                    Device washingMachine = deviceFactory.createWashingMachine("Bosch", room);
                    washingMachine.setDeviceType(DeviceType.WASHING_DEVICE);
                    devices.add(washingMachine);
                    livingApi.addLivingToRoom(room);
                    break;
                case 5:
                    Device dishwasher = deviceFactory.createDishwasher("Washy washy", room);
                    dishwasher.setDeviceType(DeviceType.WASHING_DEVICE);
                    devices.add(dishwasher);
                    livingApi.addLivingToRoom(room);
                    break;
                case 6:
                    Device computer = deviceFactory.createComputer("Asus", room);
                    computer.setDeviceType(DeviceType.ENTERTAINMENT_DEVICE);
                    devices.add(computer);
                    livingApi.addLivingToRoom(room);
                    break;
            }
            room.setDevices(devices);
        }
        return room;
    }

    public Room getRoom() {
        return room;
    }
}
