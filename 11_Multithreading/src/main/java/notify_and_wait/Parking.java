package notify_and_wait;

public class Parking {
    private int capasityPark = 500;
    private int carCount = 0;

    public synchronized void addAuto(){
        if (carCount==capasityPark) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCount++;
        System.out.println("Adding auto to park");
        System.out.println("The free place " + (capasityPark-carCount));
        notify();
    }
    public synchronized void removeAuto(){
        if (carCount==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carCount--;
        System.out.println("Removing auto from park");
        System.out.println("The free place " + (capasityPark-carCount));
        notify();
    }
}
