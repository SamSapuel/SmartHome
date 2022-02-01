package living.humans;

import devices.DeviceInterface;
import devices.DeviceType;
import events.Event;
import events.EventListener;
import home.Room;
import java.util.Random;
import living.Living;

/**
 * Basic person
 */
public abstract class Person extends Living implements EventListener {

    public Person(String name, Room room, int age) {
        super(name, room, age);
    }

    
    @Override
    public void update() {
        randomChangeStrategy();
        DeviceInterface goal = null;
        try {
            goal = strategy.getDeviceToUse();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (goal == null) {
            move(strategy.getRandomRoom());
        } else {
            move(goal.getRoom());
            if (goal.turnOn() == false) {
                return;
            }
            goal.useDevice();
            generateAction(goal.getName(), strategy.getActionType());
            if (new Random().nextInt(100) < 80) {
                goal.turnOff();
            }
        }
    }

    @Override
    public void generateEvent(Event event) {};

}
