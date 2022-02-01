package living.strategy;

import devices.DeviceInterface;
import devices.DeviceType;

public class CleaningStrategy extends Strategy{
    @Override
    public DeviceInterface getDeviceToUse() {
        return getDeviceByType(DeviceType.WASHING_DEVICE);
    }

}
