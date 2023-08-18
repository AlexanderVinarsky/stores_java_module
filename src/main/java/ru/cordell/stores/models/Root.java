package ru.cordell.stores.models;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
public class Root{
    public String company_name;
    public String name;
    public ArrayList<OpenHour> open_hours;
    public ArrayList<Storage> storage;
    public double x_coordinate;
    public double y_coordinate;
}
