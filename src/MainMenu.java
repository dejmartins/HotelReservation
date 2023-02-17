import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    HotelResource hotelResource = HotelResource.getHotelResource();
    AdminMenu menu = new AdminMenu();
    Customer currentCustomer;

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

        List<IRoom> freeRooms = hotelResource.findARoom(new SimpleDateFormat("dd/MM/yyyy").parse(checkIn),
                new SimpleDateFormat("dd/MM/yyyy").parse(checkOut)).stream().toList();

        if (freeRooms.size() == 0) {
            System.out.println("\nNo rooms Available!");
            return;
        }

        for (int i = 1; i <= freeRooms.size(); i++){
            System.out.println(i + "" + freeRooms.get(i - 1));
        }

        System.out.println("To reserve a room, enter the number");
        int selectedRoom = scanner.nextInt();

        hotelResource.bookARoom(currentCustomer.getEmail(),
                freeRooms.get(selectedRoom - 1),
                new SimpleDateFormat("dd/MM/yyyy").parse(checkIn),
                new SimpleDateFormat("dd/MM/yyyy").parse(checkOut));
    }

    public void seeMyReservations(){
        hotelResource.getCustomerReservation(currentCustomer.getEmail());
    }

    public void createAnAccount() throws ParseException {
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("FirstName: ");
        String firstName = scanner.next();
        System.out.print("LastName: ");
        String lastName = scanner.next();
        hotelResource.createACustomer(email, firstName, lastName);
        currentCustomer = new Customer(email, firstName, lastName);
        System.out.println("Account Created!");
        entry();
    }

}
