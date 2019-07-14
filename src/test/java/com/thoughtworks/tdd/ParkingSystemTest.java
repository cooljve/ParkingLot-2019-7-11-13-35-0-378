package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {

  @Test
  public void should_return_car_when_park_car_fetch_car(){
    //give
    Car car=new Car();
    ParkingLot parkingLot=new ParkingLot();
    ParkingBoy parkingBoy=new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket=parkingBoy.park(car);
    Car fetchedCar=parkingBoy.fetch(ticket);
    //then
    assertEquals(car, fetchedCar);
  }

  @Test
  public void should_return_right_car_when_park_car_fetch_car(){
    //give
    Car firstCar=new Car();
    Car secondCar=new Car();
    ParkingLot parkingLot=new ParkingLot();
    ParkingBoy parkingBoy=new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket=parkingBoy.park(firstCar);
    ParkingTicket ticket1=parkingBoy.park(secondCar);
    Car fetchedCar=parkingBoy.fetch(ticket);
    Car fetchedCar1=parkingBoy.fetch(ticket1);
    //then
    assertEquals(firstCar, fetchedCar);
    assertEquals(secondCar, fetchedCar1);
  }

}