package org.example;

import java.util.List;

public interface DataProcessingStrategy {
    String process(List<Person> data);
}
