package reports;

import api.HouseApi;
import home.Floor;
import home.House;
import home.Room;
import living.LivingInterface;
import java.util.List;

/**
 * House configuration report service for storing data about all constituents
 */
public class HouseConfigReportService {

    public String generateHouseReport(House house) {
        List<LivingInterface> livings = HouseApi.getInstance().getLivings();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("!Configuration no. %d\n", HouseApi.getInstance().getConfigNumber()));
        stringBuilder.append(String.format("->House has %d floors\n", house.getFloors().size()));
        for (int i = 0; i < house.getFloors().size(); i++) {
            Floor floor = house.getFloor(i);
            stringBuilder.append(String.format(" ->Floor %d has rooms:\n", floor.getFloorNumber()));
            for (int j =  0; j < floor.getRooms().size(); j++) {
                Room room = floor.getRoom(j);
                stringBuilder.append(String.format("  ->Room: %s\n  ->Devices: ", room.getRoomName()));
                room.getDevices().forEach(device -> stringBuilder.append(String.format("%s, ", device.getName())));
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("-->There are some Living entities:\n");
        livings.forEach(living -> stringBuilder.append(String.format("  -->Entity '%s'\n", living.getName())));
        return stringBuilder.toString();
    }

}
