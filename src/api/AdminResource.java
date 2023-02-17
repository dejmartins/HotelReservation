package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    private static final AdminResource ADMIN_RESOURCE = new AdminResource();
    private final CustomerService customerService = CustomerService.getCustomerService();
    private final ReservationService reservationService = ReservationService.getReservationService();

    private AdminResource(){
    }

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void addRoom(IRoom room){
        reservationService.addRoom(room);
    }

    public Collection<IRoom> getAllRooms(){
        return reservationService.findAllRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservation();
    }

    public static AdminResource getAdminResource(){
        return ADMIN_RESOURCE;
    }
}
