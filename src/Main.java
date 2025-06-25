import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            
            // Create rooms

            System.out.println("Creating rooms...");
            service.setRoom(1, RoomType.STANDARD, 1000);
            service.setRoom(2, RoomType.JUNIOR, 2000);
            service.setRoom(3, RoomType.MASTER, 3000);

            // Create users

            System.out.println("\nCreating users...");
            service.setUser(1, 5000);
            service.setUser(2, 10000);

            // Run booking scenarios

            System.out.println("\nAttempting bookings:");

            // Valid booking: 7 nights

            System.out.println("\n1. User 1 books Room 2 (7 nights):");
            service.bookRoom(1, 2, sdf.parse("30/06/2026"), sdf.parse("07/07/2026"));

            // Invalid booking: check-out before check-in

            System.out.println("\n2. User 1 tries invalid dates:");
            service.bookRoom(1, 2, sdf.parse("07/07/2026"), sdf.parse("30/06/2026"));

            // Valid booking: 1 night

            System.out.println("\n3. User 1 books Room 1 (1 night):");
            service.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));

            // Booking conflict (overlapping dates)

            System.out.println("\n4. User 2 books Room 1 (2 nights):");
            service.bookRoom(2, 1, sdf.parse("07/07/2026"), sdf.parse("09/07/2026"));

            // Valid booking: Room 3

            System.out.println("\n5. User 2 books Room 3 (1 night):");
            service.bookRoom(2, 3, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));

            // Update room type and price (should not affect old bookings)

            System.out.println("\nUpdating Room 1 to MASTER suite with new price...");
            service.setRoom(1, RoomType.MASTER, 10000);

            // Print all users and bookings

            System.out.println("\n=== Final Results ===");
            System.out.println("\nprintAllUsers():");
            service.printAllUsers();
            
            System.out.println("\nprintAll():");
            service.printAll();

        } catch (Exception e) {

            // Catch and print any parsing or runtime errors

            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}