package reader;

public class HousePropertiesReader extends PropertiesReader {
    private final int MIN_FLOOR_COUNT;
    private final int MAX_FLOOR_COUNT;

    public HousePropertiesReader() {
        MIN_FLOOR_COUNT = Integer.parseInt(properties.getProperty("house.min_floor_count"));
        MAX_FLOOR_COUNT = Integer.parseInt(properties.getProperty("house.max_floor_count"));
    }

    public int getMIN_FLOOR_COUNT() {
        return MIN_FLOOR_COUNT;
    }

    public int getMAX_FLOOR_COUNT() {
        return MAX_FLOOR_COUNT;
    }
}
