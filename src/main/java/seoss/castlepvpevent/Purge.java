package seoss.castlepvpevent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.UUID;

public class Purge {

    public static void purge() {
        Double[] minCoords = {93.0, 0.0, 178.0};
        Double[] maxCoords = {169.0, 272.0, 226.0};
        Double[] gateCoords = {105.4, 67.52, 243.5};
        //  Remove all users (not from owning clan) from castle (and place at gates)
        for (Player player : Bukkit.getOnlinePlayers()) { // Loop through players
            // Somehow check if they're in the owning clan, return;
            Location location = player.getLocation(); // Check their location
            Double[] coords = new Double[3];
            coords[0] = location.getX();
            coords[1] = location.getY();
            coords[2] = location.getZ();
            // Get their coords through location
            if ((coords[0] > minCoords[0] && coords[0] < maxCoords[0]) && // Check if their X is inside castle
                    (coords[1] > minCoords[1] && coords[1] < maxCoords[1]) && // Check if their Y is inside castle
                    (coords[2] > minCoords[2] && coords[2] < maxCoords[2])) { // Check if their Z is inside castle
                // If completely in castle
                player.teleport(new Location(location.getWorld(), gateCoords[0], gateCoords[1], gateCoords[2], -180, 0));
            }
        }
    }

    public static void purge(UUID kUUID) {
        Double[] minCoords = {93.0, 0.0, 178.0};
        Double[] maxCoords = {169.0, 272.0, 226.0}; // setting y max at 100 for testing
        Double[] gateCoords = {105.4, 67.52, 243.5};

        //  Remove all users (not from owning clan) from castle (and place at gates)
        for (Player player : Bukkit.getOnlinePlayers()) { // Loop through players
            // Somehow check if they're in the owning clan, return;
            if (player.getUniqueId().equals(kUUID)) {
                continue;
            }
            Location location = player.getLocation(); // Check their location
            Double[] coords = new Double[3];
            coords[0] = location.getX();
            coords[1] = location.getY();
            coords[2] = location.getZ();
            // Get their coords through location
            if ((coords[0] > minCoords[0] && coords[0] < maxCoords[0]) && // Check if their X is inside castle
                    (coords[1] > minCoords[1] && coords[1] < maxCoords[1]) && // Check if their Y is inside castle
                    (coords[2] > minCoords[2] && coords[2] < maxCoords[2])) { // Check if their Z is inside castle
                // If completely in castle
                player.teleport(new Location(location.getWorld(), gateCoords[0], gateCoords[1], gateCoords[2], -180, 0));
                player.sendMessage(ChatColor.RED + "You have been purged from castle.");
                //player.sendMessage(ChatColor.RED + "You have " + TimeLeft.timeEnd() + " to capture castle");
            }
        }
    }
}
