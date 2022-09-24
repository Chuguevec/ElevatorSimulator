public class Passenger {
private int currentFloor;
private int neededFloor;
private Direction neededDirection;

    public Passenger(int currentFloor, int lastFloor) {
        this.currentFloor = currentFloor;
        setNeededFloor(lastFloor);
        neededDirection = setNeededDirection();
    }

    public int getNeededFloor() {
        return neededFloor;
    }

    private void setNeededFloor(int countLastFloor) {
        do{
            neededFloor = (int) (Math.random() * countLastFloor) + 1;
        } while (neededFloor == currentFloor);
    }

    public Direction getNeededDirection() {
        return neededDirection;
    }

    private Direction setNeededDirection() {
       return currentFloor < neededFloor ? Direction.UP: Direction.DOWN;
    }
}
