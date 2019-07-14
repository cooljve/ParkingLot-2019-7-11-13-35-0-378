package com.thoughtworks.tdd;

public class ParkingBoy {
  private ParkingLot parkingLot;

  public ParkingTicket park(Car car) {
    if (parkingLot.isFull() || parkingLot.getMap().containsValue(car) || car == null) {
      return null;
    }
    ParkingTicket ticket = new ParkingTicket();
    parkingLot.getMap().put(ticket, car);
    return ticket;
  }

  public Car fetch(ParkingTicket ticket) {
    Car car = parkingLot.getMap().get(ticket);
    parkingLot.getMap().remove(ticket);
    return car;
  }

  public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }
}
