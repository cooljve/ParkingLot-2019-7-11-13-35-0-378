package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.TICKET_MISSING_EXCEPTION;
import com.thoughtworks.tdd.exception.UNRECOGNIZED_PARKING_TICKET;

import java.util.Arrays;
import java.util.List;

public class Parker {
  protected List<ParkingLot> parkingLots;

  public Parker(ParkingLot... parkingLots) {
    this.parkingLots.addAll(Arrays.asList(parkingLots));
  }

  public Car fetch(ParkingTicket ticket) {
    if (ticket == null) {
      throw new TICKET_MISSING_EXCEPTION();
    }
    Car car = null;
    for (ParkingLot lot : parkingLots) {
      if (lot.containsTicket(ticket)) {
        car = lot.fetch(ticket);
      }
    }
    if (car == null) {
      throw new UNRECOGNIZED_PARKING_TICKET();
    }
    return car;
  }
}
