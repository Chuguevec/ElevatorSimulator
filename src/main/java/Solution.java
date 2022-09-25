public class Solution {
    public static void main(String[] args) {
        House house = new House();
        Elevator elevator = new Elevator();
        ElevatorManager elevatorManager = new ElevatorManager(elevator, house);
        elevatorManager.run();
    }
}
