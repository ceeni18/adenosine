package com.web.model;

/**
 * Created by uday on 4/27/16.
 */
public class SynchronizedData {
    private String time;

    private String value;

    public String getTime() {
        return time;
    }

    public SynchronizedData setTime(String time) {
        this.time = time;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SynchronizedData setValue(String value) {
        this.value = value;
        return this;
    }
}
