package repositories;

import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationRepository {

    private static final ReservationRepository RESERVATION_REPOSITORY = new ReservationRepository();

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
    }

    public Collection<Reservation> retrieveCustomerReservation(String emailAddress){
        return reservations.get(emailAddress);
    }

    public void printAllReservations(){
        System.out.println();
    }

    public static ReservationRepository getReservationRepository(){
        return RESERVATION_REPOSITORY;
    }
}
