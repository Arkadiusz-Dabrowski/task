package com.example.task;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;

import java.util.stream.Stream;

@Component
public class Reader {

    public List<JsonObject> readFile(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonObject> list = new ArrayList<>();
        Stream<String> content = Files.lines(Paths.get(path));
        content.forEach(x -> {
            try {
                list.add(mapper.readValue(x, JsonObject.class));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        return list;
    }
}
