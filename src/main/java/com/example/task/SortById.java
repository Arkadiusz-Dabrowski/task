package com.example.task;

import java.util.Comparator;

public class SortById implements Comparator<JsonObject> {

    @Override
    public int compare(JsonObject o1, JsonObject o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
