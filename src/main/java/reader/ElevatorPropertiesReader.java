package reader;

public class ElevatorPropertiesReader extends PropertiesReader{
    private final int MAX_CAPACITY;
    private final int START_FLOOR;

    public ElevatorPropertiesReader() {
        MAX_CAPACITY = Integer.parseInt(properties.getProperty("elevator.max_capacity"));
        START_FLOOR = Integer.parseInt(properties.getProperty("elevator.start_floor"));
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public int getSTART_FLOOR() {
        return START_FLOOR;
    }
}
