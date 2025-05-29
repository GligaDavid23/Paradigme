package ro.ulbs.paradigme.lab11.pb2.dataprocessing.impl;

import ro.ulbs.paradigme.lab11.pb2.dataprocessing.StepCountStrategy;
import ro.ulbs.paradigme.lab11.pb2.storage.ISensorData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredStepCountStrategy implements StepCountStrategy {
    private static final long MINUTE = 60000;
    private int totalSteps = 0;
    List<ISensorData> lastMinuteData = new ArrayList<>();

    @Override
    public void consumeMessage(ISensorData sd) {
        if (sd.getStepsCount() > 0) {
            long one_minute_ago = System.currentTimeMillis() - MINUTE;
            lastMinuteData = lastMinuteData.stream().filter(r -> r.getTimestamp() >= one_minute_ago).collect(Collectors.toList());
            int lastMinSteps = lastMinuteData.stream().map(ISensorData::getStepsCount).reduce(0, Integer::sum);
            if (lastMinSteps < 1000) {
                totalSteps += sd.getStepsCount();
            }
            lastMinuteData.add(sd);
        }
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