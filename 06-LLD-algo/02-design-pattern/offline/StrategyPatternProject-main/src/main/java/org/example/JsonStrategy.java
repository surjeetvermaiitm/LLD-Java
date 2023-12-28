package org.example;

import com.google.gson.Gson;

import java.util.List;

public class JsonStrategy implements DataProcessingStrategy {
    @Override
    public String process(List<Person> data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}