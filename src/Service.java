import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    
    // Adds or updates a room

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        Room existingRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                existingRoom = room;
                break;
            }
        }
        
        if (existingRoom != null) {

            // Update existing room's type and price

            existingRoom.setType(roomType);
            existingRoom.setPricePerNight(roomPricePerNight);
        } else {

            // Add new room

            rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
        }
    }

    // Handles room booking by user

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {

        // Validate date range

    if (checkIn.compareTo(checkOut) >= 0) {
        System.out.println("Booking failed: Check-out date must be after check-in date");
        return;
    }

    // Find user by ID

    User user = null;
    for (User u : users) {
        if (u.getUserId() == userId) {
            user = u;
            break;
        }
    }
    
    // Find room by number

    if (user == null) {
        System.out.println("Booking failed: User not found");
        return;
    }

    Room room = null;
    for (Room r : rooms) {
        if (r.getRoomNumber() == roomNumber) {
            room = r;
            break;
        }
    }
    if (room == null) {
        System.out.println("Booking failed: Room not found");
        return;
    }

    // Check room availability during requested period

    boolean isAvailable = true;
    for (Booking booking : bookings) {
        if (booking.getRoom().getRoomNumber() == roomNumber) {
            if (!(checkOut.compareTo(booking.getCheckIn()) <= 0 || checkIn.compareTo(booking.getCheckOut()) >= 0)) {
                isAvailable = false;
                break;
            }
        }
    }
    if (!isAvailable) {
        System.out.println("Booking failed: Room not available for selected dates");
        return;
    }

    // Calculate number of nights and total cost

    long diff = checkOut.getTime() - checkIn.getTime();
    int nights = (int) (diff / (1000 * 60 * 60 * 24));
    int originalPricePerNight = room.getPricePerNight();
    int totalPrice = nights * originalPricePerNight;

    // Check if user has enough balance

    if (user.getBalance() < totalPrice) {
        System.out.println("Booking failed: Insufficient balance. Required: " + totalPrice + ", Available: " + user.getBalance());
        return;
    }

    // Proceed with booking

    bookings.add(new Booking(user, room, checkIn, checkOut, originalPricePerNight, totalPrice));
    user.setBalance(user.getBalance() - totalPrice);
    System.out.println("Booking successful for Room " + roomNumber);
}

// Prints all rooms and bookings in reverse order (latest to oldest)

    public void printAll() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Rooms:");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            Room room = rooms.get(i);
            System.out.println("Room " + room.getRoomNumber() + 
                              " - Type: " + room.getType() + 
                              ", Price/Night: " + room.getPricePerNight());
        }

        System.out.println("\nBookings:");
        for (int i = bookings.size() - 1; i >= 0; i--) {
            Booking booking = bookings.get(i);
            System.out.println("User ID: " + booking.getUser().getUserId() +
                              ", Room: " + booking.getRoom().getRoomNumber() +
                              ", Check-in: " + sdf.format(booking.getCheckIn()) +
                              ", Check-out: " + sdf.format(booking.getCheckOut()) +
                              ", Price/Night: " + booking.getOriginalPricePerNight() +
                              ", Total: " + booking.getTotalPrice());
        }
    }

    // Adds or updates a user

    public void setUser(int userId, int balance) {
        User existingUser = null;
        for (User user : users) {
            if (user.getUserId() == userId) {
                existingUser = user;
                break;
            }
        }
        
        if (existingUser != null) {
            existingUser.setBalance(balance);
        } else {
            users.add(new User(userId, balance));
        }
    }

    // Prints all users in reverse order (latest to oldest)

    public void printAllUsers() {
        System.out.println("Users:");
        for (int i = users.size() - 1; i >= 0; i--) {
            User user = users.get(i);
            System.out.println("User ID: " + user.getUserId() + 
                             ", Balance: " + user.getBalance());
        }
    }
}