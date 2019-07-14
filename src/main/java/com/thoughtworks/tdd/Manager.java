package com.thoughtworks.tdd;

import java.util.List;

public class Manager {
  private List<ParkingBoy> parkingBoyList;
  private List<ParkingLot> parkingLotList;

  public Manager(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }

  public void distribute(ParkingBoy boy, List<ParkingLot> parkingLots) {
    boy.setParkingLotList(parkingLots);
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
}
