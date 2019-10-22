package com.example.task;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ObjectForDatabase {

    @Id
    private String id;

    private int duration;

    @Nullable
    private String type;

    @Nullable
    private String host;

    private boolean alert;

    public ObjectForDatabase(String id, int duration, boolean alert) {
        this.id = id;
        this.duration = duration;
        this.alert = alert;
    }

    public ObjectForDatabase(String id, int duration, String type, String host, boolean alert) {
        this.id = id;
        this.duration = duration;
        this.type = type;
        this.host = host;
        this.alert = alert;
    }

    public ObjectForDatabase() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(int time) {
        if(time > 4000) {
            this.alert = true;
        } else {
            this.alert = false;
        }
    }
}
