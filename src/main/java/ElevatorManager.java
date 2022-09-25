import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorManager {
    private Elevator elevator;
    private House house;
    private Direction direction;
    private DataWriter dataWriter;
    private List<Boolean> floorsHavePassenger;
    private int lastFloorId;


    public ElevatorManager(Elevator elevator, House house) {
        this.elevator = elevator;
        this.house = house;
        direction = Direction.UP;
        dataWriter = new DataWriter();
        floorsHavePassenger = getHavePassengerList();
    }

    private List<Boolean> getHavePassengerList() {
        return house.getFloors().stream().map(floor -> !floor.getPassengers().isEmpty()).collect(Collectors.toList());
    }

    public void run() {
        boolean haveAnyPassenger = true;
        while (haveAnyPassenger) {
            writeElevatorInfo();
            exitPassenger();
            getPassenger();
            updateLastFloorID();
            moveElevator();
            dataWriter.readData();
            haveAnyPassenger = checkHaveAnyPassenger() || !elevator.getPassengers().isEmpty();
        }
    }

    private void writeElevatorInfo() {
        dataWriter.writeData("Текущий этаж " + elevator.getCurrentFloor() + " " + direction);
        dataWriter.writeData("Человек в лифте: " + elevator.getPassengers().size());
    }

    private void exitPassenger() {
        List<Passenger> elevatorPassenger = elevator.getPassengers();
        if (!elevatorPassenger.isEmpty()) {
            int currentFloor = elevator.getCurrentFloor();
            List<Passenger> exitPassenger = elevatorPassenger.stream().filter(passenger -> passenger.getNeededFloor() == currentFloor).toList();
            if (!exitPassenger.isEmpty()) {
                elevatorPassenger.removeAll(exitPassenger);
                dataWriter.writeData("Вышло человек из лифта: " + exitPassenger.size());
            }
        }
    }

    private void getPassenger() {
        int currentFloorId = elevator.getCurrentFloor();
        Floor currentFloor = house.getFloorByIndex(currentFloorId);
        List<Passenger> floorPassengers = currentFloor.getPassengers();
        List<Passenger> elevatorPassenger = elevator.getPassengers();
        if (elevatorPassenger.isEmpty() && !floorPassengers.isEmpty()) {
            changeDirection(floorPassengers);
        }
        int freeSeat = elevator.getMAX_CAPACITY() - elevatorPassenger.size();
        if (freeSeat > 0) {
            List<Passenger> suitable = floorPassengers.stream()
                    .filter(passenger -> passenger.getNeededDirection().equals(direction))
                    .limit(freeSeat).toList();
            elevatorPassenger.addAll(suitable);
            floorPassengers.removeAll(suitable);
            dataWriter.writeData("Зашло человек в лифт: " + suitable.size());
            if (floorPassengers.isEmpty()) {
                floorsHavePassenger.set(currentFloorId - 1, false);
            }
        }
    }

    private void changeDirection(List<Passenger> passengers) {
        int upCount = 0;
        int downCount = 0;
        for (Passenger passenger : passengers) {
            if (passenger.getNeededDirection() == Direction.UP) {
                upCount++;
            } else {
                downCount++;
            }
        }
        direction = upCount > downCount ? Direction.UP : Direction.DOWN;
    }

    private void moveElevator() {
        if (direction == Direction.UP && elevator.getCurrentFloor() < lastFloorId) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            if (elevator.getCurrentFloor() == lastFloorId) {
                direction = Direction.DOWN;
            }
        } else {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            if (elevator.getCurrentFloor() == 1) {
                direction = Direction.UP;
            }
        }
    }

    private void updateLastFloorID() {
        List<Passenger> elevatorPassenger = elevator.getPassengers();
        if (!elevatorPassenger.isEmpty()) {
            lastFloorId = elevatorPassenger.stream().map(Passenger::getNeededFloor).max(Comparator.comparingInt(value -> value)).get();
        } else {
            for (int i = floorsHavePassenger.size(); i > 0; i--) {
                if (floorsHavePassenger.get(i - 1)) {
                    lastFloorId = i;
                }
            }
        }
    }

    private boolean checkHaveAnyPassenger() {
        return floorsHavePassenger.stream().anyMatch(Boolean::booleanValue);
    }
}


