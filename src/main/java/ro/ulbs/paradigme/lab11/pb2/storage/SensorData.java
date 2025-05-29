package ro.ulbs.paradigme.lab11.pb2.storage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents the sensing data sent to the storage component
 */
public class SensorData implements ISensorData {

    private int stepsCount;
    private long timestamp;

    public SensorData(int stepsCount, long timestamp) {
        this.stepsCount = stepsCount;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        //return String.format("stepsCount = %4d, timestamp = %d", stepsCount, timestamp);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        Date resultdate = new Date( getTimestamp());
        return String.format( "stepsCount = %4d, timestamp = %d  time=%s", getStepsCount(), getTimestamp(), sdf.format(resultdate));
    }


    public int getStepsCount() {
        return stepsCount;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
