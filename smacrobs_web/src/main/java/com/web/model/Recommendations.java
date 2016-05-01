package com.web.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

/**
 * Created by uday on 4/27/16.
 */
@Document(collection = "recommendations")
public class Recommendations {
    private String userId;

    private String date;

    @DBRef
    private HashMap<String, List<String>> topics;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<String, List<String>> getTopics() {
        return topics;
    }

    public void setTopics(HashMap<String, List<String>> topics) {
        this.topics = topics;
    }
}
