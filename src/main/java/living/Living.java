package living;

import api.HouseApi;
import devices.DeviceInterface;
import entityAction.Action;
import entityAction.ActionType;
import events.EventGeneratorInterface;
import home.Room;
import living.strategy.*;
import java.util.Random;

/**
 * Abstract living entity class taking care of mutual living functionality
 */
public abstract class Living implements LivingInterface, EventGeneratorInterface {
    protected final String name;
    protected Room room;
    protected int age;
    protected StrategyInterface strategy;

    public Living(String name, Room room, int age) {
        this.name = name;
        this.room = room;
        this.age = age;
        randomChangeStrategy();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void move(Room room) {
        Room previous = this.room;
        this.room = room;
        room.setLivings(this);
        if (previous != null) {
            previous.removeFromRoom(this);
        }
        generateAction(room.getRoomName(), ActionType.MOVE);
    }

    @Override
    public Room getRoom() {
        return room;
    }

    /**
     * Change current strategy to new randomly generated one
     */
    protected final void randomChangeStrategy() {
        int index = new Random().nextInt(4);
        switch (index) {
            case 0:
                strategy = new LazyStrategy();
                break;
            case 1:
                strategy = new ActiveStrategy();
                break;
            case 2:
                strategy = new CleaningStrategy();
                break;
            case 3:
                strategy = new HungryStrategy();
                break;
            default:
                strategy = new Strategy() {
                    @Override
                    public DeviceInterface getDeviceToUse() {
                        return null;
                    }
                };
        }
    }

    /**
     * Generates an action and registers it to action report service
     * @param goal entity of action
     * @param actionType type of the action
     */
    protected void generateAction(String goal, ActionType actionType) {
        HouseApi.getInstance().getReportService().getActionReportService().registerAction(new Action(this.name, goal, actionType));
    }
}
