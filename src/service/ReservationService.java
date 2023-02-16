package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import repositories.ReservationRepository;
import repositories.RoomRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {

    private final RoomRepository roomRepository = RoomRepository.getRoomRepository();
    private final ReservationRepository reservationRepository = ReservationRepository.getReservationRepository();
    private static final ReservationService RESERVATION_SERVICE = new ReservationService();

    private ReservationService(){
    }

    public void addRoom(IRoom room){
        roomRepository.createRoom(room);
    }

    public IRoom getRoom(String roomId){
        return roomRepository.retrieveRoom(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationRepository.createReservation(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        if(checkInDate.before(Date.from(Instant.now()))){
            throw new IllegalArgumentException("Are you trying to go back in time? Check-in date is invalid");
        }

        if(checkOutDate.before(checkInDate)){
            throw new IllegalArgumentException("Check-in cannot be after check-out except in Dutch");
        }

        Collection<IRoom> availableRooms = new ArrayList<>();
        Collection<IRoom> bookedRooms = new ArrayList<>();
        Collection<IRoom> allRooms = roomRepository.retrieveAllRooms();

        reservationRepository.getAllReservations().forEach((reservation) -> bookedRooms.add(reservation.room()));

        for(IRoom room : allRooms){
            if(!bookedRooms.contains(room)) availableRooms.add(room);
        }

        reservationRepository.getAllReservations().stream().filter((reservation) ->
                reservation.getCheckOutDate().before(checkInDate)
                        || checkOutDate.before(reservation.getCheckInDate()))
                .forEach((reservation) -> availableRooms.add(reservation.room()));

        return availableRooms;
    }

    public Collection<IRoom> findAllRooms(){
        return roomRepository.retrieveAllRooms();
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        return reservationRepository.retrieveCustomerReservation(customer);
    }

    public void printAllReservation(){
        System.out.println(reservationRepository.getAllReservations().stream().toList());
    }

    public static ReservationService getReservationService(){
        return RESERVATION_SERVICE;
    }
}
