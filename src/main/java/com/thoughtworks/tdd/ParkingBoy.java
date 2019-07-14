package com.thoughtworks.tdd;

import static com.thoughtworks.tdd.Constant.NO_TICKET;
import static com.thoughtworks.tdd.Constant.WRONG_TICKET;

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

  public Response fetch(ParkingTicket ticket) {
    if (ticket == null) {
      return new Response(NO_TICKET, null);
    }
    Car car = parkingLot.getMap().get(ticket);
    parkingLot.getMap().remove(ticket);
    if (car == null) {
      return new Response(WRONG_TICKET,null);
    }
    return new Response("",car);
  }

  public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }
}
