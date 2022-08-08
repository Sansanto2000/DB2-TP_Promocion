package com.zinbig.mongodemo.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class LocationWithAmount {

    @Field("location")
    String location;

    @Field("amount")
    int amount;

    public LocationWithAmount() {
    }

    public LocationWithAmount(String location, int amount) {
        this.location = location;
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
