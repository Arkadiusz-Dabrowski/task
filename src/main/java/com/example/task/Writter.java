package com.example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class Writter implements CommandLineRunner {

    @Autowired
    Reader reader;

    @Autowired
    ObjectRepository repository;

    public void writingToDatabase() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String path = in.readLine();
            List<JsonObject> list = reader.readFile(path);
            Collections.sort(list, new SortById());
            List<ObjectForDatabase> nowaLista = new ArrayList();
            JsonObject jsonObject = new JsonObject();
            ObjectForDatabase objectForDatabase = new ObjectForDatabase();
            for(int i = 0; i<list.size();i++){
                if (i%2 ==0) {
                    jsonObject = list.get(i);
                    objectForDatabase.setId(jsonObject.getId());
                    if(jsonObject.getHost() != null) {
                        objectForDatabase.setHost(jsonObject.getHost());
                        objectForDatabase.setType(jsonObject.getType());
                    }
                } else {

                    objectForDatabase.setDuration(list.get(i).getTimestamp().getNanos() - jsonObject.getTimestamp().getNanos());
                    objectForDatabase.setAlert(objectForDatabase.getDuration());
                    if(list.get(i).getHost() != null) {
                        objectForDatabase.setHost(list.get(i).getHost());
                        objectForDatabase.setType(list.get(i).getType());
                    }
                    nowaLista.add(objectForDatabase);
                }

            }
            repository.saveAll(nowaLista);

    }

    @Override
    public void run(String... args) throws Exception {
        writingToDatabase();
    }
}
