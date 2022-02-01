package living.strategy;

import devices.DeviceInterface;
import devices.DeviceType;

public class LazyStrategy extends Strategy{

    @Override
    public DeviceInterface getDeviceToUse() {
        return getDeviceByType(DeviceType.ENTERTAINMENT_DEVICE);
    }


}
