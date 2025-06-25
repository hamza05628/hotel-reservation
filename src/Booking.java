import java.util.Date;


// Represents a booking made by a user for a room during a specific period

public class Booking {
    private User user;
    private Room room;
    private Date checkIn;
    private Date checkOut;
    private int originalPricePerNight;
    private int totalPrice;

    // Constructor

    public Booking(User user, Room room, Date checkIn, Date checkOut, int originalPricePerNight, int totalPrice) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.originalPricePerNight = originalPricePerNight;
        this.totalPrice = totalPrice;
    }

    // Getters

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getOriginalPricePerNight() {
        return originalPricePerNight;
    }
}