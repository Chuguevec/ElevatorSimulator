import java.util.ArrayList;
import java.util.List;

public class Elevator  {
    private List<Passenger> passengers;
    private int currentFloor;
    private final int MAX_CAPACITY;

    public Elevator() {
        MAX_CAPACITY = 5;
        passengers = new ArrayList<>(MAX_CAPACITY);
        currentFloor = 1;

    }

    public List <Passenger> getPassengers() {
        return passengers;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }
}
