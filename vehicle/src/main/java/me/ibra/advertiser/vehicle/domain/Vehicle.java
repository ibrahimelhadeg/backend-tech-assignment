package me.ibra.advertiser.vehicle.domain;

public interface Vehicle {

    Long      id();
    String    type();
    String    brand();
    String    model();
    Integer   modelYear();
    String    fuel();
    String    gearBox();
    String    color();
    Integer   horsePower();
    Integer   doorCount();
    Integer   seatCount();
    String    description();
}
