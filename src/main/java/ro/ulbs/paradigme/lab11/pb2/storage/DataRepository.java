package ro.ulbs.paradigme.lab11.pb2.storage;


import java.util.ArrayList;
import java.util.List;
/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
// TODO make this an Observable - by extending class java.util.Observable
public class DataRepository {
    private static DataRepository instance;
    private List<ISensorData> dataList = new ArrayList<>();
    private DataRepository() {}

    public static DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }
    public void addData(ISensorData dataRecord){
        // TODO notify observers -  mark as changed, then call inherited notifyObservers(dataRecord)
        dataList.add(dataRecord);
    }

}


