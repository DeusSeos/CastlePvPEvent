package seoss.castlepvpevent;

import org.bukkit.command.CommandSender;

import java.util.Date;

public class CastleTime {
    public CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);


    public String timeTill(CommandSender sender){
        String message = "";
        Date currentTime = new Date();
        currentTime.toString();
        return message;
    }

    public String setTime(CommandSender sender){
        String message = "";
        Date currentTIme = new Date();
        plugin.getConfig().set("Castle Time: ", currentTIme);
        return message;
    }

}
