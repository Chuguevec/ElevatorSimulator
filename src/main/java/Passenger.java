public class Passenger {
    private int currentFloor;
    private int neededFloor;
    private Direction neededDirection;

    public Passenger(int currentFloor, int lastFloor) {
        this.currentFloor = currentFloor;
        generateNeededFloor(lastFloor);
        neededDirection = generateNeededDirection();
    }

    public int getNeededFloor() {
        return neededFloor;
    }

    private void generateNeededFloor(int countLastFloor) {
        do {
            neededFloor = (int) (Math.random() * countLastFloor + 1);
        } while (neededFloor == currentFloor);
    }

    public Direction getNeededDirection() {
        return neededDirection;
    }

    private Direction generateNeededDirection() {
        return currentFloor < neededFloor ? Direction.UP : Direction.DOWN;
    }
}
