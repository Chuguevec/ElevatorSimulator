import reader.HousePropertiesReader;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final int MAX_COUNT_FLOOR;
    private List<Floor> floors;

    public House() {
        MAX_COUNT_FLOOR = generateMaxCountFloor();
        floors = new ArrayList<>(MAX_COUNT_FLOOR);
        initFloors();
    }

    private int generateMaxCountFloor() {
        HousePropertiesReader housePropertiesReader = new HousePropertiesReader();
        int minFloor = housePropertiesReader.getMIN_FLOOR_COUNT();
        int maxFloor = housePropertiesReader.getMAX_FLOOR_COUNT();
        return (int) (Math.random() * (maxFloor - minFloor + 1)) + minFloor;
    }

    private void initFloors() {
        for (int i = 0; i < MAX_COUNT_FLOOR; i++) {
            floors.add(new Floor(i + 1, MAX_COUNT_FLOOR));
        }
    }

    public Floor getFloorByIndex(int index) {
        return floors.get(index - 1);
    }

    public int getMAX_COUNT_FLOOR() {
        return MAX_COUNT_FLOOR;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
