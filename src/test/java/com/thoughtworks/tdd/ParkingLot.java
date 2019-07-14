package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
  private Map<ParkingTicket, Car> map = new HashMap<>();

  public Map<ParkingTicket, Car> getMap() {
    return map;
  }

  public void setMap(Map<ParkingTicket, Car> map) {
    this.map = map;
  }
}
