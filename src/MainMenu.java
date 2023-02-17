import api.HotelResource;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    HotelResource hotelResource = HotelResource.getHotelResource();
    AdminMenu menu = new AdminMenu();

    public int mainMenu(){
        System.out.println("""
                1. Find and reserve a room
                2. See my reservations
                3. Create an account
                4. Admin
                5. Exit
                """
        );
        return scanner.nextInt();
    }

    public void entry() throws ParseException {
        int action = mainMenu();
        switch (action){
            case 1 -> findAndReserveARoom();
            case 2 -> seeMyReservations();
            case 3 -> createAnAccount();
            case 4 -> menu.entry();
            case 5 -> System.exit(0);
        }
    }

    public void findAndReserveARoom() throws ParseException {
        System.out.print("Check-in Date(dd/mm/yyyy): ");
        String checkIn = scanner.next();
        System.out.print("Check-out Date(dd/mm/yyyy): ");
        String checkOut = scanner.next();

        Collection<IRoom> freeRooms = hotelResource.findARoom(new SimpleDateFormat("dd/MM/yyyy").parse(checkIn),
                new SimpleDateFormat("dd/MM/yyyy").parse(checkOut));

        if (freeRooms.size() == 0) System.out.println("\nNo rooms Available!");

        for (IRoom room : freeRooms){
            System.out.println(room);
        }

//        TODO: Reserve Room
    }

    public void seeMyReservations(){
        System.out.print("Enter email address: ");
        String emailAddress = scanner.next();
        hotelResource.getCustomerReservation(emailAddress);
    }

    public void createAnAccount() throws ParseException {
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("FirstName: ");
        String firstName = scanner.next();
        System.out.print("LastName: ");
        String lastName = scanner.next();
        hotelResource.createACustomer(email, firstName, lastName);
        System.out.println("Account Created!");
        entry();
    }

}
