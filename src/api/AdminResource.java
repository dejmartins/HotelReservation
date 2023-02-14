package api;

import java.util.Collection;
import java.util.List;
import model.Customer;
import model.IRoom;

public class AdminResource {

  private static final AdminResource ADMIN_RESOURCE = new AdminResource();

  private AdminResource() {}

  public Customer getCustomer(String email) {
    return null;
  }

  public void addRoom(List<IRoom> rooms) {}

  public Collection<IRoom> getAllRooms() {
    return null;
  }

  public Collection<Customer> getAllCustomers() {
    return null;
  }

  public void displayAllReservations() {}
}
