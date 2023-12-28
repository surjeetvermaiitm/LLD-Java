package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        DataProcessor processor = new DataProcessor(new JsonStrategy());
        System.out.println("JSON:\n" + processor.process(people));

        processor.setStrategy(new CsvStrategy());
        System.out.println("CSV:\n" + processor.process(people));
    }
}