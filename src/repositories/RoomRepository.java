package repositories;

import model.IRoom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoomRepository {

    private static final RoomRepository ROOM_REPOSITORY = new RoomRepository();

    private final Map<String, IRoom> rooms = new HashMap<>();

    private RoomRepository(){
    }

    public void createRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom retrieveRoom(String roomNumber){
        return rooms.get(roomNumber);
    }

    public Collection<IRoom> retrieveAllRooms(){
        return rooms.values();
    }

    public static RoomRepository getRoomRepository(){
        return ROOM_REPOSITORY;
    }
}
