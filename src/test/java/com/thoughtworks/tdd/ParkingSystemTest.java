package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.tdd.Constant.NO_TICKET;
import static com.thoughtworks.tdd.Constant.PARKING_LOT_IS_FULL;
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(car).getObject();
    Car fetchedCar = (Car) parkingBoy.fetch(ticket).getObject();
    //then
    assertEquals(car, fetchedCar);
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(firstCar).getObject();
    ParkingTicket ticket1 = (ParkingTicket) parkingBoy.park(secondCar).getObject();
    Car fetchedCar = (Car) parkingBoy.fetch(ticket).getObject();
    Car fetchedCar1 = (Car) parkingBoy.fetch(ticket1).getObject();
    //then
    assertEquals(firstCar, fetchedCar);
    assertEquals(secondCar, fetchedCar1);
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
    Car fetchedCar = (Car) parkingBoy.fetch(customer.getParkingTicket()).getObject();
    Car fetchedCar1 = (Car) parkingBoy.fetch(null).getObject();
    //then
    assertEquals(null, fetchedCar);
    assertEquals(null, fetchedCar1);
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(customer.getCar()).getObject();
    customer.setParkingTicket(ticket);
    Car fetchedCar = (Car) parkingBoy.fetch(customer.getParkingTicket()).getObject();
    Car fetchedCar1 = (Car) parkingBoy.fetch(customer.getParkingTicket()).getObject();
    //then
    assertEquals(customer.getCar(), fetchedCar);
    assertEquals(null, fetchedCar1);
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(customer.getCar()).getObject();
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(customer.getCar()).getObject();
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(customer.getCar()).getObject();
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
    ParkingTicket ticket = (ParkingTicket) parkingBoy.park(customer.getCar()).getObject();
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

  @Test
  public void should_full_parkingLot_message_when_park_car_give_full_parkingLot() {
    //give
    Customer customer = new Customer();
    customer.setCar(new Car());
    ParkingLot parkingLot = mock(ParkingLot.class);
    ParkingBoy parkingBoy = new ParkingBoy();
    //when
    parkingBoy.setParkingLot(parkingLot);
    when(parkingLot.isFull()).thenReturn(true);
    Response response = parkingBoy.park(customer.getCar());
    //then
    assertEquals(PARKING_LOT_IS_FULL, response.getMessage());
  }
}