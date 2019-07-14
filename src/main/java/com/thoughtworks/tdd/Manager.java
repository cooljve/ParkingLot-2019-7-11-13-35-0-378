package com.thoughtworks.tdd;

import java.util.List;

public class Manager implements ParkingSystem{
  private List<ParkingBoy> parkingBoyList;
  private List<ParkingLot> parkingLotList;

  public Manager() {
  }

  public Manager(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }

  public void distribute(ParkingBoy boy, List<ParkingLot> parkingLots) {
    boy.setParkingLotList(parkingLots);
  }

  public Response distributeParkingBoyToPark(ParkingBoy boy, Customer customer) {
    return boy.park(customer.getCar());
  }

  public Response distributeParkingBoyToFetch(ParkingBoy boy, Customer customer) {
    return boy.fetch(customer.getParkingTicket());
  }

  public void setParkingBoyList(List<ParkingBoy> parkingBoyList) {
    this.parkingBoyList = parkingBoyList;
  }

  public List<ParkingLot> getParkingLotList() {
    return parkingLotList;
  }

  public void setParkingLotList(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }

  @Override
  public Response park(Car car) {
    return null;
  }

  @Override
  public Response fetch(ParkingTicket ticket) {
    return null;
  }
}
