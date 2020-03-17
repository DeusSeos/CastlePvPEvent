package seoss.castlepvpevent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ModifyTeam implements Listener {

    public CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);


    public void registerTeams(CommandSender sender){
        //List<String> teams = new ArrayList<String>();
        String[] teamNames = {"Red", "Blue", "Green", "Yellow"};

        for (int i = 0; i < teamNames.length; i++){
            //ChatColor color = ChatColor.getByChar(teamNames[i]);
            try {
                plugin.scoreboard.registerNewTeam(teamNames[i]);
                //plugin.scoreboard.getTeam(teamNames[i]).setColor(color);
                plugin.scoreboard.getTeam(teamNames[i]).setCanSeeFriendlyInvisibles(true);
            } catch (IllegalArgumentException ex){
                sender.sendMessage(teamNames[i] + " was already registered to this scoreboard.");
            }
        }
    }

    public void addTeam(String[] args, CommandSender sender){
        for (int i = 0; i < args.length; i++){
            try {
                plugin.scoreboard.registerNewTeam(args[i]);
            } catch (IllegalArgumentException ex){
                sender.sendMessage(args[i] + " was already registered to this scoreboard.");
            }
        }
    }

    @EventHandler
    public void clickSign(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();

    }

}
