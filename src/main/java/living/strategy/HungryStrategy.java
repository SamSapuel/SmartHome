package living.strategy;

import devices.DeviceInterface;
import devices.DeviceType;
import entityAction.ActionType;

public class HungryStrategy extends Strategy{
    @Override
    public DeviceInterface getDeviceToUse() {
        return getDeviceByType(DeviceType.FOOD_DEVICE);
    }

    @Override
    public ActionType getActionType() {
        return ActionType.EAT;
    }
}
