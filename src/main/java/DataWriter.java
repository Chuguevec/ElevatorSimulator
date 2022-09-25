public class DataWriter {
    StringBuilder stringBuilder;

    public DataWriter() {
        this.stringBuilder = new StringBuilder();
    }

    public void writeData(String data) {
        stringBuilder.append(data).append('\n');
    }

    public void readData() {
        System.out.println(stringBuilder.toString());
        stringBuilder.setLength(0);
    }
}
