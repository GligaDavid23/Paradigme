package ro.ulbs.paradigme.lab11.pb1.storage;

import java.util.Observable;
/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
// TODO make this an Observable - by extending class java.util.Observable
public class DataRepository extends Observable{
    private static DataRepository instance;

    private DataRepository() {}

    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }
    public void addData(SensorData dataRecord){
        // TODO notify observers -  mark as changed, then call inherited notifyObservers(dataRecord)
        setChanged();
        notifyObservers(dataRecord);
    }

}


