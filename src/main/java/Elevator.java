import reader.ElevatorPropertiesReader;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private List<Passenger> passengers;
    private int currentFloor;
    private final int MAX_CAPACITY;

    public Elevator() {
        ElevatorPropertiesReader elevatorPropertiesReader = new ElevatorPropertiesReader();
        MAX_CAPACITY = elevatorPropertiesReader.getMAX_CAPACITY();
        passengers = new ArrayList<>(MAX_CAPACITY);
        currentFloor = elevatorPropertiesReader.getSTART_FLOOR();
    }

    public List<Passenger> getPassengers() {
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
