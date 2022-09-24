import java.util.ArrayList;
import java.util.List;

public class Floor{
    private final int ID;
    private final int MAX_COUNT_FLOORS;
    private List<Passenger> passengers = new ArrayList<>();

    public Floor(int id, int maxCountFloors) {
        this.ID = id;
        MAX_COUNT_FLOORS = maxCountFloors;
        initPassengersList();
    }
    private void initPassengersList(){
        int numberPassenger = (int) (Math.random() * 11);
        for (int i = 0; i < numberPassenger; i++) {
            passengers.add(new Passenger(ID, MAX_COUNT_FLOORS));
        }
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
