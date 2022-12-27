package com.mitocode.model.schema;

public class AccidentWithDistanceSchema {
    private String id;
    private Double distance;

    public AccidentWithDistanceSchema() {
    }

    public AccidentWithDistanceSchema(String id, Double distance) {
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