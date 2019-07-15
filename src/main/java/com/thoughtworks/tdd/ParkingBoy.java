package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.NOT_ENOUGH_POSITION_EXCEPTION;

import java.util.stream.Collectors;

public class ParkingBoy extends Parker {

  public ParkingTicket park(Car car) {

    parkingLotList = parkingLotList.stream().filter(x -> !x.isFull()).collect(Collectors.toList());
    if (parkingLotList.size() == 0) {
      throw new NOT_ENOUGH_POSITION_EXCEPTION();
    }
    ParkingTicket ticket = new ParkingTicket();
    parkingLotList.get(0).park(car);
    return ticket;
  }

}
