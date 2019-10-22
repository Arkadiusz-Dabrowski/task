package com.example.task;


import java.sql.Timestamp;


public class JsonObject {


    private String id;

    private String state;

    private Timestamp timestamp;

    private String type;

    private String host;


    public JsonObject(String id, String state, Timestamp timestamp) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
    }

    public JsonObject(String id, String state, String type, String host, Timestamp timestamp) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.type = type;
        this.host = host;
    }

    public JsonObject() {
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
