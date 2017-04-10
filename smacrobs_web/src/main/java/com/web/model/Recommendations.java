package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;

@Document(collection = "recommendations")
public class Recommendations {
    private final String userId;
    private final Date date;
    private final HashMap<String, String> recommendations;

    private Recommendations(RecommendationsBuilder builder){
        this.userId = builder.userId;
        this.date = builder.date;
        this.recommendations = builder.recommendations;
    }

    public static class RecommendationsBuilder{
        private String userId;
        private Date date;
        private HashMap<String, String> recommendations;

        public RecommendationsBuilder(String userId, Date date){
            this.userId = userId;
            this.date = date;
        }

        public RecommendationsBuilder setRecommendations(
            HashMap<String, String> recommendations){
            this.recommendations = recommendations;
        }

        public Recommendations build(){
            return Recommendations(this);
        }
    }

    public Date getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public HashMap<String, String> getRecommendations() {
        return recommendations;
    }
}