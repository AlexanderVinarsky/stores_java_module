package ru.cordell.stores.models;

public class Request {
    private String address;
    private Integer radius = 50;

    public Request() {

    }

    public Request(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
