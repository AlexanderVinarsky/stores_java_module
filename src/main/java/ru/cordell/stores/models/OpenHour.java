package ru.cordell.stores.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
public class OpenHour{
    @JsonProperty("Everyday")
    public boolean everyday;
    @JsonProperty("Intervals")
    public ArrayList<Interval> intervals;
    @JsonProperty("TwentyFourHours")
    public boolean twentyFourHours;
}
