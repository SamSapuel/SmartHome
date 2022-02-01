package events.pets;

import api.HouseApi;
import entityAction.Action;
import entityAction.ActionType;
import events.Event;
import events.EventGeneratorInterface;
import events.EventType;
import home.Room;
import living.humans.Daughter;
import living.humans.Father;
import living.humans.Mother;
import living.humans.Son;

public class NeedsFoodEvent extends Event {

    public NeedsFoodEvent(EventGeneratorInterface eventGeneratorInterface, Room eventRoom) {
        super(true, "PetNeedsFoodEvent", eventGeneratorInterface, eventRoom, EventType.PET_NEEDS_FOOD);
    }

    @Override
    public void handle(Father father) {
        HouseApi.getInstance().getReportService().getActionReportService()
                .registerAction(new Action(father.getName(), "Pet food", ActionType.GET_ITEM));
    }

    @Override
    public void handle(Mother mother) {
        HouseApi.getInstance().getReportService().getActionReportService()
                .registerAction(new Action(mother.getName(), "Food bowl", ActionType.USE));
    }

    @Override
    public void handle(Son son) {
        HouseApi.getInstance().getReportService().getActionReportService()
                .registerAction(new Action(son.getName(), eventGenerator.getName(), ActionType.PET_A_PET));
    }

    @Override
    public void handle(Daughter daughter) {
        HouseApi.getInstance().getReportService().getActionReportService()
                .registerAction(new Action(daughter.getName(), eventGenerator.getName(), ActionType.PET_A_PET));
    }

}
