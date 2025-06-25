
// Enum to represent the three types of rooms

public enum RoomType {
    STANDARD("standard suite"),
    JUNIOR("junior suite"),
    MASTER("master suite");

    // Display name for each room type

    private final String displayName;

    // Constructor to set display name

    RoomType(String displayName) {
        this.displayName = displayName;
    }

    // Return the display name when printing the enum

    @Override
    public String toString() {
        return displayName;
    }
}