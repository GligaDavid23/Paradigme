package ro.ulbs.paradigme.lab11.pb1.storage;


import ro.ulbs.paradigme.lab11.pb1.dataprocessing.StepCountStrategy;

import java.util.Observable;
import java.util.Observer;


// TODO Implement observer for changes in data repository, implement java.util.Observer interface
public class DataAggregator implements Observer {

    private StepCountStrategy strategy;
    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }

    public String getResults() {
        return String.format("Strategy %s: stepsCount=%d", strategy.getStrategyDescription(), strategy.getTotalSteps());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof SensorData) {
            strategy.consumeMessage((SensorData) arg);
        }
    }
}
