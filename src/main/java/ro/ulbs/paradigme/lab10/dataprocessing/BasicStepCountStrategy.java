package ro.ulbs.paradigme.lab10.dataprocessing;

import ro.ulbs.paradigme.lab10.storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
	private int totalSteps = 0;

	@Override
	public void consumeMessage(SensorData data) {
		totalSteps += data.getStepsCount();
	}

	@Override
	public int getTotalSteps() {
		return totalSteps;
	}

	@Override
	public String getStrategyDescription() {
		return "Strategie de numarare a pasilor de baza";
	}

	@Override
	public String toString() {
		return getStrategyDescription() +":"+getTotalSteps() + " pasi";
	}
}
