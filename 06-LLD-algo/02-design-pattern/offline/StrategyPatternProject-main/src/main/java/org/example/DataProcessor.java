package org.example;

import java.util.List;

public class DataProcessor {
    private DataProcessingStrategy strategy;

    public DataProcessor(DataProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DataProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public String process(List<Person> data) {
        return strategy.process(data);
    }
}

