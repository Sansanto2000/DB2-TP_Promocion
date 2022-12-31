package com.mitocode.model.schema;

public class AccidentWithDistanceSchema {
	
    private String id;
    private Double top_10_avg_distance;

    public AccidentWithDistanceSchema() {
    }

    public AccidentWithDistanceSchema(String id, Double top_10_avg_distance) {
        this.id = id;
        this.top_10_avg_distance = top_10_avg_distance;
    }

    public String getId() {
        return id;
    }

    public Double getTop_10_avg_distance() {
        return top_10_avg_distance;
    }

    public void setDistance(Double top_10_avg_distance) {
        this.top_10_avg_distance = top_10_avg_distance;
    }

    public void setId(String id) {
        this.id = id;
    }
}