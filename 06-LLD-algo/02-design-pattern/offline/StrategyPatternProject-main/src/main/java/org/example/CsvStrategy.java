package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class CsvStrategy implements DataProcessingStrategy {
    @Override
    public String process(List<Person> data) {
        return data.stream()
                .map(p -> p.getName() + "," + p.getAge())
                .collect(Collectors.joining("\n"));
    }
}