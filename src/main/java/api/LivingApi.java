package api;

import home.Room;
import living.Living;
import living.LivingFactory;
import java.util.ArrayList;
import java.util.List;

public class LivingApi {

    /**
     * Add living entity to the current room
     * @param room current room
     */
    public void addLivingToRoom(Room room) throws Exception {
        LivingFactory livingFactory = new LivingFactory();
        List<Living> livings = new ArrayList<>();
        if (room.getOccupants().isEmpty()) {
            switch (room.getRoomName()) {
                case "Kitchen":
                    livings.add(livingFactory.createMother("Mother", room, 30));
                    break;
                case "BedRoom#1":
                    livings.add(livingFactory.createFather("Father", room, 40));
                    livings.add(livingFactory.createDog("Dog", room, 2));
                    break;
                case "BedRoom#2":
                    livings.add(livingFactory.createSon("Son", room, 10));
                    livings.add(livingFactory.createCat("Cat", room, 10));
                    break;
                case "Attic":
                    livings.add(livingFactory.createDaughter("Daughter", room, 12));
                    break;
                case "LivingRoom":
                    livings.add(livingFactory.createSon("AnotherSon", room, 14));
                    break;
            }
        }

        for (Living living : livings) {
            room.setLivings(living);
        }
    }
}
