
// Represents a room in the hotel with a number, type, and price per night

public class Room {
    private int roomNumber;
    private RoomType type;
    private int pricePerNight;

    // Constructor

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    // Getter for room number

    public int getRoomNumber() {
        return roomNumber;
    }

    // Getter for room type

    public RoomType getType() {
        return type;
    }

    // Getter for price per night

    public int getPricePerNight() {
        return pricePerNight;
    }

    // Setter for room type (used when updating)

    public void setType(RoomType type) {
        this.type = type;
    }

    // Setter for price per night (used when updating)

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}