package living.pets;

import api.HouseApi;
import events.Event;
import events.pets.NeedsFoodEvent;
import home.Room;
import java.util.Random;
import living.Living;

public abstract class Pet extends Living {

    public Pet(String name, Room room, int age) {
        super(name, room, age);
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", room=" + room
                + ", age=" + age
                + '}';
    }

    @Override
    public void generateEvent(Event event) {
        HouseApi.getInstance().getEventService().registerEvent(event);
    }

    @Override
    public void move(Room room) {
        this.room = room;
    }

    @Override
    public void update() {
        if (new Random().nextInt(100) < 5) {
            generateEvent(new NeedsFoodEvent(this, room));
        }
    }

}
