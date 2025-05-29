package ro.ulbs.paradigme.lab11.pb2.storage;

import ro.ulbs.paradigme.lab11.pb2.storage.ISensorData;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO implement decorator for ISensorData objects. Make sure toString() returning different value than decorated object toString()
public class DecoratedSensorData implements ISensorData {
	private final ISensorData decoratedSensorData;

	public DecoratedSensorData(ISensorData decoratedSensorData) {
		this.decoratedSensorData = decoratedSensorData;
	}

	@Override
	public int getStepsCount() {
		return 20 + decoratedSensorData.getStepsCount();
	}

	@Override
	public long getTimestamp() {
		return decoratedSensorData.getTimestamp();
	}

	@Override
	public String toString() {
		long timestamp = getTimestamp();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		String formattedTimestamp = formatter.format(new Date(timestamp));
		return String.format("DecoratedSensorData [stepsCount=%d, timestamp=%s]", getStepsCount(), formattedTimestamp);
	}
}
