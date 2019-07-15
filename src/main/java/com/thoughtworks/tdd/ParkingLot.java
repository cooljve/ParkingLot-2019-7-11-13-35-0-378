package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
  private final int capacity;
  private Map<ParkingTicket, Car> map = new HashMap<>();

  public ParkingTicket park(Car car) {
    ParkingTicket ticket = new ParkingTicket();
    map.put(ticket, car);
    return ticket;
  }

  public Car fetch(ParkingTicket ticket) {
    return map.remove(ticket);
  }

  public ParkingLot(int capacity) {
    this.capacity = capacity;
  }

  public boolean isFull() {
    return capacity <= map.size();
  }

  public Map<ParkingTicket, Car> getMap() {
    return map;
  }

  public void setMap(Map<ParkingTicket, Car> map) {
    this.map = map;
  }

  public int getCapacity() {
    return capacity;
  }

  public boolean containsTicket(ParkingTicket ticket) {
    return map.containsKey(ticket);
  }

  public boolean containsCar(Car car) {
    return map.containsValue(car);
  }

  public int getAvailable (){
    return capacity - map.size();
  }

  public double getAvailableRate (){
    return getAvailable() / (double) capacity;
  }
}
