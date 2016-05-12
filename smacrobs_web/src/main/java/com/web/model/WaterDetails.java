package com.web.model;

public class WaterDetails {
    private String userId;
    private String date;
    private Water[] water;
    private Summary summary;

    public Water[] getWater() {
        return water;
    }

    public void setWater(Water[] water) {
        this.water = water;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "ClassPojo [water = " + water + ", summary = " + summary + "]";
    }

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

    public static class Water {
        private String amount;
        private String logId;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getLogId() {
            return logId;
        }

        public void setLogId(String logId) {
            this.logId = logId;
        }

        @Override
        public String toString() {
            return "ClassPojo [amount = " + amount + ", logId = " + logId + "]";
        }
    }

    public static class Summary {
        private String water;

        public String getWater() {
            return water;
        }

        public void setWater(String water) {
            this.water = water;
        }

        @Override
        public String toString() {
            return "ClassPojo [water = " + water + "]";
        }
    }
}
