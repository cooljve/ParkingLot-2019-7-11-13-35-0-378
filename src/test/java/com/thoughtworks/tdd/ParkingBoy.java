package com.thoughtworks.tdd;

public class ParkingBoy {
  private ParkingLot parkingLot;

  public ParkingTicket park(Car car) {
    ParkingTicket ticket = new ParkingTicket();
    parkingLot.getMap().put(ticket, car);
    return ticket;
  }

  public Car fetch(ParkingTicket ticket) {
    return parkingLot.getMap().get(ticket);
  }

  public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }
}
