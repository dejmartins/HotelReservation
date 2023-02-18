import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.text.ParseException;
import java.util.Scanner;

public class AdminMenu {

    Scanner scanner = new Scanner(System.in);
    AdminResource adminResource = AdminResource.getAdminResource();
    HotelResource hotelResource = HotelResource.getHotelResource();

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
            case 5 -> MainMenu.entry();
            default -> entry();
        }
    }

    private void addARoom() throws ParseException {
        System.out.print("Room Number: ");
        String roomNumber = scanner.next();
        System.out.print("Price: ");
        Double price = scanner.nextDouble();
        System.out.print("RoomType: ");
        String roomType = scanner.next();

        IRoom foundRoom = hotelResource.getRoom(roomNumber);
        if(foundRoom != null){
            IRoom room = new Room(roomNumber, price, RoomType.stringToRoomType(roomType));
            adminResource.addRoom(room);
            System.out.println("\nRoom added!\n\n");
        } else {
            System.out.println("\nRoom number already exists!\n\n");
            addARoom();
        }

        entry();
    }

    private void seeAllReservations() {
        adminResource.displayAllReservations();
    }

    private void seeAllRooms() {
        if(adminResource.getAllRooms().size() == 0){
            System.out.println("No rooms available");
            return;
        }

        for (IRoom room : adminResource.getAllRooms()){
            System.out.println(room);
        }
    }

    public void seeAllCustomers(){
        if(adminResource.getAllCustomers().size() == 0){
            System.out.println("No customers on platform");
            return;
        }

        for (Customer customer : adminResource.getAllCustomers()){
            System.out.println(customer);
        }
    }

}
