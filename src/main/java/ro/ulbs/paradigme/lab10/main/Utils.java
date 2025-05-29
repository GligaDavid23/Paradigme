package ro.ulbs.paradigme.lab10.main;

import ro.ulbs.paradigme.lab10.dataprocessing.BasicStepCountStrategy;
import ro.ulbs.paradigme.lab10.dataprocessing.FilteredStepCountStrategy;
import ro.ulbs.paradigme.lab10.dataprocessing.StepCountStrategy;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }

    // TODO implement static getStrategy(String type). Returns either BasicStepCountStrategy or FilteredStepCountStrategy
    public static StepCountStrategy getStrategy(String type) {
        if(type.equals(BASIC_STRATEGY)) {
            return new BasicStepCountStrategy();
        } else if(type.equals(FILTERED_STRATEGY)) {
            return new FilteredStepCountStrategy();
        } else {
            throw new IllegalArgumentException("Unknown strategy type: " + type);
        }
    }
}
