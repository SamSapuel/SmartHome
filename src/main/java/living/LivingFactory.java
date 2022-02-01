package living;

import api.HouseApi;
import living.humans.*;
import living.pets.*;
import home.Room;

/**
 * Сlass for creating living entities, implemented using factory pattern
 */
public class LivingFactory {

    public Living createMother(String name, Room room, int age) {
        Mother mother = new Mother(name, room, age);
        HouseApi.getInstance().getEventService().subscribe(mother);
        return mother;
    }

    public Living createFather(String name, Room room, int age) {
        Father father = new Father(name, room, age);
        HouseApi.getInstance().getEventService().subscribe(father);
        return father;
    }

    public Living createSon(String name, Room room, int age) {
        Son son = new Son(name, room, age);
        HouseApi.getInstance().getEventService().subscribe(son);
        return son;
    }

    public Living createDaughter(String name, Room room, int age) {
        Daughter daughter = new Daughter(name, room, age);
        HouseApi.getInstance().getEventService().subscribe(daughter);
        return daughter;
    }

    public Living createDog(String name, Room room, int age) {
        return new Dog(name, room, age);
    }

    public Living createCat(String name, Room room, int age) {
        return new Cat(name, room, age);
    }

}
