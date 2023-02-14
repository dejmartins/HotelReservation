package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

  private final Collection<Reservation> reservations = new ArrayList<>();

  private static final ReservationService RESERVATION_SERVICE = new ReservationService();

  private ReservationService() {}

  public void addRoom(IRoom room) {}

  public IRoom getRoom(String roomId) {
    return null;
  }

  public Reservation reserveARoom(
      Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
    return null;
  }

  public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
    return null;
  }

  public Collection<Reservation> getCustomerReservation(Customer customer) {
    return null;
  }

  public void printAllReservation() {}

  public static ReservationService getReservationService() {
    return RESERVATION_SERVICE;
  }
}
