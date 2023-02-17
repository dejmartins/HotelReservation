package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private static final HotelResource HOTEL_RESOURCE = new HotelResource();
    private final CustomerService customerService = CustomerService.getCustomerService();
    private final ReservationService reservationService = ReservationService.getReservationService();

    private HotelResource(){
    }

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return reservationService.getRoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservation(String customerEmail){
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.getCustomerReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);
    }

    public static HotelResource getHotelResource(){
        return HOTEL_RESOURCE;
    }
}
