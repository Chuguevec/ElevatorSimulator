public class House {
    private int floorsNumber;
    Floor[] floors;

    public House() {
        this.floorsNumber = (int) (Math.random() * 16)+5;
        this.floors = new Floor[floorsNumber];
    }

    private void init (){
        for (int i = 0; i < floors.length; i++) {
                floors [i] = new Floor(i+1, floorsNumber);
        }
    }
}
