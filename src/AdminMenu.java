import model.*;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.util.Scanner;

public class AdminMenu {

    Scanner scanner = new Scanner(System.in);
    CustomerService customerService = CustomerService.getCustomerService();
    ReservationService reservationService = ReservationService.getReservationService();

    public int adminMenu(){
        System.out.println("""
                1. See all Customers
                2. See all Rooms
                3. See all Reservations
                4. Add a Room
                5. Back to Main Menu
                """
        );
        return scanner.nextInt();
    }

    public void entry() throws ParseException {
        int action = adminMenu();
        switch (action){
            case 1 -> seeAllCustomers();
            case 2 -> seeAllRooms();
            case 3 -> seeAllReservations();
            case 4 -> addARoom();
        }
    }

    private void addARoom() throws ParseException {
        System.out.print("Room Number: ");
        String roomNumber = scanner.next();
        System.out.print("Price: ");
        Double price = scanner.nextDouble();
        System.out.print("RoomType: ");
        String roomType = scanner.next();
        IRoom room = new Room(roomNumber, price, RoomType.SINGLE);
        reservationService.addRoom(room);
        System.out.println("Account Created!");
        entry();
    }

    private void seeAllReservations() {
        reservationService.printAllReservation();
    }

    private void seeAllRooms() {
        for (IRoom room : reservationService.findAllRooms()){
            System.out.println(room);
        }
    }

    public void seeAllCustomers(){
        for (Customer customer : customerService.getAllCustomers()){
            System.out.println(customer);
        }
    }

}
