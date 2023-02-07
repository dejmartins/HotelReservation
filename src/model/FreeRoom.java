package model;

public class FreeRoom extends Room{

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;


    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, price, roomType);
        this.roomNumber = roomNumber;
        this.price = 0.0;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
