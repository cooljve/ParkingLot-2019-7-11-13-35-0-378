package com.thoughtworks.tdd;

import java.util.List;

public class Manager {
  private List<ParkingBoy> parkingBoyList;
  private List<ParkingLot> parkingLotList;

  public Manager(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }


  public void setParkingBoyList(List<ParkingBoy> parkingBoyList) {
    this.parkingBoyList = parkingBoyList;
  }

  public Response park(Car car) {
    return super.park(car);
  }

  public List<ParkingLot> getParkingLotList() {
    return parkingLotList;
  }

  public void setParkingLotList(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }

  public List<ParkingBoy> getParkingBoyList() {
    return parkingBoyList;
  }
}
