package com.thoughtworks.tdd;

import com.thoughtworks.tdd.exception.NOT_ENOUGH_POSITION_EXCEPTION;

import java.util.stream.Collectors;

import static com.thoughtworks.tdd.Constant.PARKING_LOT_IS_FULL;

public class SmartParkingBoy extends Parker {
  public ParkingTicket park(Car car) {
    parkingLotList = parkingLotList.stream().filter(x -> !x.isFull()).collect(Collectors.toList());
    if (parkingLotList.size() == 0) {
      throw new NOT_ENOUGH_POSITION_EXCEPTION();
    }
    ParkingTicket ticket = new ParkingTicket();
    parkingLotList.sort((a, b) -> b.getAvailable() - a.getAvailable());
    parkingLotList.get(0).getMap().put(ticket, car);
    return ticket;
  }
}
