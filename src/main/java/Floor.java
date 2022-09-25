import reader.FloorPropertiesReader;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int ID;
    private final int MAX_COUNT_FLOORS;
    private List<Passenger> passengers;

    public Floor(int id, int maxCountFloors) {
        this.ID = id;
        MAX_COUNT_FLOORS = maxCountFloors;
        passengers = generatePassengersList();
    }

    private List<Passenger> generatePassengersList() {
        FloorPropertiesReader floorPropertiesReader = new FloorPropertiesReader();
        int minPassengerCount = floorPropertiesReader.getMIN_PASSENGER_COUNT();
        int maxPassengerCount = floorPropertiesReader.getMAX_PASSENGER_COUNT();
        List<Passenger> passengers = new ArrayList<>();
        int numberPassenger = (int) (Math.random() * (maxPassengerCount - minPassengerCount + 1) + minPassengerCount);
        for (int i = 0; i < numberPassenger; i++) {
            passengers.add(new Passenger(ID, MAX_COUNT_FLOORS));
        }
        return passengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
