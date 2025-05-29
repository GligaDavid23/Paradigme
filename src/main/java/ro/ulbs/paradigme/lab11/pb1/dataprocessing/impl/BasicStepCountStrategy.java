package ro.ulbs.paradigme.lab11.pb1.dataprocessing.impl;

import ro.ulbs.paradigme.lab11.pb1.dataprocessing.StepCountStrategy;
import ro.ulbs.paradigme.lab11.pb1.storage.ISensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
    private int totalSteps = 0;

    @Override
    public void consumeMessage(ISensorData sd) {
        totalSteps += sd.getStepsCount();
    }

    @Override
    public int getTotalSteps() {
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        return this.getClass().getName();
    }
}
