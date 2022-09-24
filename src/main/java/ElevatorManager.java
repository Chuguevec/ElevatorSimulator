import java.util.List;

public class ElevatorManager {
    private Elevator elevator;
    private House house;
    private Direction direction;


    public ElevatorManager(Elevator elevator, House house) {
        this.elevator = elevator;
        this.house = house;
        direction = Direction.UP;
    }

    public void run() {
        getPassenger();
        int neededFloor = moveTo();
        moveElevator(neededFloor);
    }

    private void getPassenger() {
        Floor currentFloor = house.floors[elevator.getCurrentFloor()];
        List<Passenger> floorPassengers = currentFloor.getPassengers();
        List<Passenger> elevatorPassenger = elevator.getPassengers();
        int freeSeat = elevator.getMAX_CAPACITY() - elevatorPassenger.size();
        if (freeSeat > 0) {
            List<Passenger> suitable = floorPassengers.stream()
                    .filter(passenger -> passenger
                            .getNeededDirection().equals(direction))
                    .limit()
        }
    }

    private int moveTo() {
        return 0;
    }

    private void moveElevator(int neededFloor) {
    }

    private int checkCall() {
        return 0;
    }

}


