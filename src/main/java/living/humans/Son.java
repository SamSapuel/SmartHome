package living.humans;

import events.Event;
import home.Room;

public class Son extends Person {

    public Son(String name, Room room, int age) {
        super(name, room, age);
    }

    @Override
    public void react(Event event) {
        event.handle(this);
    }

}
