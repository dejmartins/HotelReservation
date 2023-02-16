package repositories;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationRepository {

    private static final ReservationRepository RESERVATION_REPOSITORY = new ReservationRepository();
    private final Collection<Reservation> allReservations = new ArrayList<>();

    private final Map<String, ArrayList<Reservation>> reservations = new HashMap<>();

    private ReservationRepository(){
    }

    public void createReservation(Reservation reservation){
        if (reservations.containsKey(reservation.getCustomer().getEmail())){
            reservations.get(reservation.getCustomer().getEmail()).add(reservation);
        } else {
            ArrayList<Reservation> newReservation = new ArrayList<>();
            newReservation.add(reservation);
            reservations.put(reservation.getCustomer().getEmail(), newReservation);
        }
        allReservations.add(reservation);
    }

    public Collection<Reservation> retrieveCustomerReservation(Customer customer){
        return reservations.get(customer.getEmail());
    }

    public Collection<Reservation> getAllReservations(){
        if (reservations.isEmpty()){
            System.out.println("No reservations made");
        }
        return allReservations;
    }

    public static ReservationRepository getReservationRepository(){
        return RESERVATION_REPOSITORY;
    }
}
