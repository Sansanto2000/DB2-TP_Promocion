package com.mitocode.model.schema;

public class LocationAndAmountSchema {

    String location;

    int amount;

    public LocationAndAmountSchema() {
    }

    public LocationAndAmountSchema(String location, int amount) {
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
