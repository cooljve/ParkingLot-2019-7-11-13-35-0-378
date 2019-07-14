package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.tdd.Constant.NO_TICKET;
import static com.thoughtworks.tdd.Constant.WRONG_TICKET;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParkingSystemTest {

  @Test
  public void should_return_car_when_park_car_fetch_car() {
    //give
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket = parkingBoy.park(car);
    Response response = parkingBoy.fetch(ticket);
    //then
    assertEquals(car, response.getObject());
  }

  @Test
  public void should_return_right_car_when_park_car_fetch_car() {
    //give
    Car firstCar = new Car();
    Car secondCar = new Car();
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket = parkingBoy.park(firstCar);
    ParkingTicket ticket1 = parkingBoy.park(secondCar);
    Response response = parkingBoy.fetch(ticket);
    Response response1 = parkingBoy.fetch(ticket1);
    //then
    assertEquals(firstCar, response.getObject());
    assertEquals(secondCar, response1.getObject());
  }

  @Test
  public void should_null_when_fetch_car_with_wrong_ticket() {
    //give
    Customer customer = new Customer();
    customer.setParkingTicket(new ParkingTicket());
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    Response response = parkingBoy.fetch(customer.getParkingTicket());
    Response response1 = parkingBoy.fetch(null);
    //then
    assertEquals(null, response.getObject());
    assertEquals(null, response1.getObject());
  }

  @Test
  public void should_null_when_fetch_car_give_used_ticket() {
    //give
    Customer customer = new Customer();
    customer.setCar(new Car());
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket = parkingBoy.park(customer.getCar());
    customer.setParkingTicket(ticket);
    Response response = parkingBoy.fetch(customer.getParkingTicket());
    Response response1 = parkingBoy.fetch(customer.getParkingTicket());
    //then
    assertEquals(customer.getCar(), response.getObject());
    assertEquals(null, response1.getObject());
  }

  @Test
  public void should_null_when_park_car_give_full_parkingLot() {
    //give
    Customer customer = new Customer();
    customer.setCar(new Car());
    ParkingLot parkingLot = mock(ParkingLot.class);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    when(parkingLot.isFull()).thenReturn(true);
    ParkingTicket ticket = parkingBoy.park(customer.getCar());
    customer.setParkingTicket(ticket);
    //then
    assertEquals(null, customer.getParkingTicket());
  }

  @Test
  public void should_return_null_ticket_when_park_car_give_parkedCar() {
    //give
    Customer customer = new Customer();
    customer.setCar(new Car());
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    parkingBoy.park(customer.getCar());
    ParkingTicket ticket = parkingBoy.park(customer.getCar());
    //then
    assertEquals(null, ticket);
  }

  @Test
  public void should_return_null_ticket_when_park_car_give_null_car() {
    //give
    Customer customer = new Customer();
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket = parkingBoy.park(customer.getCar());
    //then
    assertEquals(null, ticket);
  }

  @Test
  public void should_return_error_string_when_fetch_car_give_used_ticket() {
    //give
    Customer customer = new Customer();
    customer.setCar(new Car());
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    ParkingTicket ticket = parkingBoy.park(customer.getCar());
    customer.setParkingTicket(ticket);
    parkingBoy.fetch(customer.getParkingTicket());
    Response response1 = parkingBoy.fetch(customer.getParkingTicket());
    //then
    assertEquals(WRONG_TICKET, response1.getMessage());
  }

  @Test
  public void should_return_error_string_when_fetch_car_give_no_ticket() {
    //give
    Customer customer = new Customer();
    customer.setCar(new Car());
    ParkingLot parkingLot = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    Response response = parkingBoy.fetch(null);
    //then
    assertEquals(NO_TICKET, response.getMessage());
  }

}