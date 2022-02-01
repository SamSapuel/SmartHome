package devices;

import api.HouseApi;
import events.Event;
import home.Room;
/**
 * Default device with no further specialization
 */
public abstract class Device implements DeviceInterface {

    protected final String name;
    protected final Room room;
    protected final DeviceEnergyConsumption energyConsumption;
    protected DeviceReportService deviceReportService;
    protected DeviceType deviceType;
    protected DeviceState deviceState;

    /**
     * Our device start configuration
     * @param name device name
     * @param room current room
     * @param energyConsumption electricity, water, gas consumption
     */
    public Device(String name, Room room, DeviceEnergyConsumption energyConsumption) {
        deviceState = new OffState(this);
        this.name = name;
        this.room = room;
        this.energyConsumption = energyConsumption;
        this.deviceReportService = new DeviceReportService();
        deviceType = DeviceType.DEFAULTTYPE_DEVICE;
    }

    @Override
    public void update() {
        deviceState.update();
    }

    @Override
    public void useDevice() {
        deviceState.useDevice();
    }

    @Override
    public void repair() {
        deviceState.repair();
    }

    @Override
    public boolean turnOff() {
        return deviceState.turnOn();
    };

    @Override
    public boolean turnOn() {
        return deviceState.turnOff();
    }

    @Override
    public int getWaterConsumed() {
        return deviceReportService.getWaterConsumed();
    }

    @Override
    public int getGasConsumed() {
        return deviceReportService.getGasConsumed();
    }

    @Override
    public int getElectricityConsumed() {
        return deviceReportService.getElectricityConsumed();
    }

    @Override
    public DeviceType getDeviceType() {
        return deviceType;
    }

    @Override
    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Room getRoom() {
        return room;
    }

    void changeState(DeviceState state) {
        deviceState = state;
    }

    public DeviceEnergyConsumption getEnergyConsumption() {
        return energyConsumption;
    }

    public DeviceReportService getDeviceReportService() {
        return deviceReportService;
    }

    @Override
    public void generateEvent(Event event) {
        HouseApi.getInstance().getEventService().registerEvent(event);
    }

    @Override
    public String toString() {
        return "Device"
                + "Name = " + name;
    }
}
