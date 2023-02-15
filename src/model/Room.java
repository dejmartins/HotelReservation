package model;

public class Room implements IRoom{

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType){
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return null;
    }

    @Override
    public String getRoomPrice() {
        return null;
    }

    @Override
    public String getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
