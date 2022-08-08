package com.zinbig.mongodemo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class AccidentWithDistance {
    private String id;
    @Field(value = "distance")
    private Double distance;

    public AccidentWithDistance() {
    }

    public AccidentWithDistance(String id, Double distance) {
        this.id = id;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setId(String id) {
        this.id = id;
    }
}