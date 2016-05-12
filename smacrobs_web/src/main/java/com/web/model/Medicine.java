package com.web.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medicine")
public class Medicine {
    private String[] medicines;

    public String[] getMedicines() {
        return medicines;
    }

    public void setMedicines(String[] medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "ClassPojo [medicines = " + medicines + "]";
    }
}
