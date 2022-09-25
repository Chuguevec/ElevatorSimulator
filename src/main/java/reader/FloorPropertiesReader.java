package reader;

public class FloorPropertiesReader extends PropertiesReader {
    private final int MIN_PASSENGER_COUNT;
    private final int MAX_PASSENGER_COUNT;

    public FloorPropertiesReader() {
        MIN_PASSENGER_COUNT = Integer.parseInt(properties.getProperty("floor.min_passenger_count"));
        MAX_PASSENGER_COUNT = Integer.parseInt(properties.getProperty("floor.max_passenger_count"));
    }

    public int getMIN_PASSENGER_COUNT() {
        return MIN_PASSENGER_COUNT;
    }

    public int getMAX_PASSENGER_COUNT() {
        return MAX_PASSENGER_COUNT;
    }
}
