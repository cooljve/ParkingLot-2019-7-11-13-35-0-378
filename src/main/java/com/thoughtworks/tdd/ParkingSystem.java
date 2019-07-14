package com.thoughtworks.tdd;

public interface ParkingSystem {
  public Response park(Car car);

  public Response fetch(ParkingTicket ticket);
}
