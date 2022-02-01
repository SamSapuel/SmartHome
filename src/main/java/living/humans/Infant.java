package living.humans;

import events.Event;
import home.Room;

public class Infant extends Person {

    public Infant(String name, Room room, int age) {
        super(name, room, age);
    }

    @Override
    public void react(Event event) {
    }

}
