package living.strategy;

import devices.DeviceInterface;
import devices.DeviceType;

public class ActiveStrategy extends Strategy {

    @Override
    public DeviceInterface getDeviceToUse() {
        return getDeviceByType(DeviceType.SPORT_DEVICE);
    }


}
