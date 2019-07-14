package com.thoughtworks.tdd;

import java.util.List;
import java.util.stream.Collectors;

import static com.thoughtworks.tdd.Constant.NO_TICKET;
import static com.thoughtworks.tdd.Constant.PARKING_LOT_IS_FULL;
import static com.thoughtworks.tdd.Constant.WRONG_TICKET;

public class ParkingBoy implements ParkingSystem{
  private List<ParkingLot> parkingLotList;

  public Response park(Car car) {
    parkingLotList = parkingLotList.stream().filter(x -> !x.isFull()).collect(Collectors.toList());
    if (parkingLotList.size() == 0) {
      return new Response(PARKING_LOT_IS_FULL, null);
    }
    if (parkingLotList.get(0).getMap().containsValue(car) || car == null) {
      return new Response("", null);
    }
    ParkingTicket ticket = new ParkingTicket();
    parkingLotList.get(0).getMap().put(ticket, car);
    return new Response("", ticket);
  }

  public Response fetch(ParkingTicket ticket) {
    if (ticket == null) {
      return new Response(NO_TICKET, null);
    }
    Car car = null;
    for (ParkingLot lot : parkingLotList) {
      if (lot.getMap().containsKey(ticket)) {
        car = lot.getMap().get(ticket);
        lot.getMap().remove(ticket);
      }
    }
    if (car == null) {
      return new Response(WRONG_TICKET, null);
    }
    return new Response("", car);
  }

  public List<ParkingLot> getParkingLotList() {
    return parkingLotList;
  }

  public void setParkingLotList(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }

}
