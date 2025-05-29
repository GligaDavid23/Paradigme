package ro.ulbs.paradigme.lab10.dataprocessing;

import ro.ulbs.paradigme.lab10.storage.DataRepository;
import ro.ulbs.paradigme.lab10.storage.SensorData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredStepCountStrategy implements StepCountStrategy {
	private int totalSteps = 0;

	@Override
	public void consumeMessage(SensorData data) {
		if (data.getStepsCount() > 0) {
			totalSteps += data.getStepsCount();
		}
	}

	@Override
	public int getTotalSteps() {
		long oneMinuteAgo = System.currentTimeMillis() - 60000;

		List<SensorData> lastMinuteData = DataRepository.getInstance().getRecords().stream()
				.filter(data -> data.getTimestamp() >= oneMinuteAgo && data.getStepsCount() > 0)
				.toList();

		int totalStepsLastMinute = lastMinuteData.stream()
				.mapToInt(SensorData::getStepsCount)
				.sum();

		if (totalStepsLastMinute > 1000) {
			return 0; // Ignorăm pașii dacă depășesc 1000 în ultimul minut
		}

		return totalStepsLastMinute;
	}

	@Override
	public String getStrategyDescription() {
		return "Strategie de numarare a pasilor filtrata";
	}

	@Override
	public String toString() {
		return getStrategyDescription() +": "+getTotalSteps() + " pasi";
	}
}
