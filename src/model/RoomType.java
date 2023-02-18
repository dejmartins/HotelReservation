package model;

public enum RoomType {
    SINGLE("s"), DOUBLE("d");

    private final String type;
    RoomType(String type) {
        this.type = type;
    }

    public static RoomType stringToRoomType(String type){
        return switch (type) {
            case "s" -> SINGLE;
            case "d" -> DOUBLE;
            default -> null;
        };
    }

    public String getRoomType(){
        return type;
    }

}

