package events.devices;

import api.HouseApi;
import devices.DeviceInterface;
import devices.DeviceType;
import entityAction.Action;
import entityAction.ActionType;
import events.Event;
import events.EventType;
import home.Room;
import living.humans.Daughter;
import living.humans.Father;
import living.humans.Mother;
import living.humans.Son;

public class BrokenEvent extends Event {

    private final DeviceInterface brokenDevice;

    public BrokenEvent(DeviceInterface eventGenerator, Room eventRoom) {
        super(true, "BrokenEvent", eventGenerator, eventRoom, EventType.BROKEN);
        brokenDevice = eventGenerator;
    }

    @Override
    public void handle(Father father) {
        HouseApi.getInstance().getReportService().getActionReportService()
                .registerAction(new Action(father.getName(), brokenDevice.getName(), ActionType.FIX));
        brokenDevice.repair();
    }

    @Override
    public void handle(Mother mother) {
        if (brokenDevice.getDeviceType() == DeviceType.WASHING_DEVICE) {
            HouseApi.getInstance().getReportService().getActionReportService()
                    .registerAction(new Action(mother.getName(), brokenDevice.getName(), ActionType.COMPLAIN));
        }
    }

    @Override
    public void handle(Son son) {
        if (brokenDevice.getDeviceType() == DeviceType.FOOD_DEVICE) {
            HouseApi.getInstance().getReportService().getActionReportService()
                    .registerAction(new Action(son.getName(), brokenDevice.getName(), ActionType.COMPLAIN));
        }
    }

    @Override
    public void handle(Daughter daughter) {
        if (brokenDevice.getDeviceType() == DeviceType.ENTERTAINMENT_DEVICE) {
            HouseApi.getInstance().getReportService().getActionReportService()
                    .registerAction(new Action(daughter.getName(), brokenDevice.getName(), ActionType.COMPLAIN));
        }
    }

}
