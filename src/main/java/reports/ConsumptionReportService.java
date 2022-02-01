package reports;

import api.HouseApi;
import devices.Device;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Consumption report service for taking care of all consumption reports and total statistics
 */
public class ConsumptionReportService {

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Device> devices = HouseApi.getInstance().getHouse().getAllDevices();

        AtomicInteger totalElectricityUsage = new AtomicInteger();
        AtomicInteger totalGasUsage = new AtomicInteger();
        AtomicInteger totalWaterUsage = new AtomicInteger();
        AtomicInteger totalUseCounter = new AtomicInteger();

        devices.forEach(device -> {
            stringBuilder.append(String.format("➣Device %s has consumed:\n  ➣%d units of electricity\n  ➣%d units of gas\n  ➣%d units of water.\n",
                    device.getName(), device.getElectricityConsumed(), device.getGasConsumed(), device.getWaterConsumed()));
            totalElectricityUsage.addAndGet(device.getElectricityConsumed());
            totalGasUsage.addAndGet(device.getGasConsumed());
            totalWaterUsage.addAndGet(device.getWaterConsumed());
            totalUseCounter.addAndGet(device.getDeviceReportService().getUseCount());
        });
        stringBuilder.append(String.format("\n①Total electricity consumption:\n%d\n" +
                        "②Total gas consumption:\n%d\n" +
                        "③Total water consumption:\n%d\n" +
                        "④Total devices use counter:\n%d",
                totalElectricityUsage.intValue(), totalGasUsage.intValue(), totalWaterUsage.intValue(), totalUseCounter.intValue()));
        return stringBuilder.toString();
    }





}
