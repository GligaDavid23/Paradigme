package ro.ulbs.paradigme.lab11.pb2.dataprocessing;

import ro.ulbs.paradigme.lab11.pb2.storage.ISensorData;

/**
 * Defines the operations that can be performed on step data. Each implementation uses its own algorithm.
 */
public interface StepCountStrategy {

    /**
     * Consumes a sensor data sample
     * @param sample
     */
    void consumeMessage(ISensorData sample);

    /**
     * Computes and returns the total number of steps since the app started running.
     */
    int getTotalSteps();

    /**
     * Returns a string describing this strategy, to be used for printing purposes.
     */
    String getStrategyDescription();
}
