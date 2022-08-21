package com.mitocode.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class LocationAndAmount {

    @Field("location")
    String location;

    @Field("amount")
    int amount;

    public LocationAndAmount() {
    }

    public LocationAndAmount(String location, int amount) {
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
