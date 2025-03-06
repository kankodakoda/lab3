import java.util.ArrayList;

public class VehicleObservable {
    private final ArrayList<VehicleObserver> observers = new ArrayList<>();

    public void addObserver(VehicleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(VehicleObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (VehicleObserver observer : observers) {
            observer.update();
        }
    }

}



