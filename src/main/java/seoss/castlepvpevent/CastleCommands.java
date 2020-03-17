package seoss.castlepvpevent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class CastleCommands implements CommandExecutor {

    private ModifyTeam modifyTeam = new ModifyTeam();
    public CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //determine if the command is correct
        //determine who is sending the command
        //Rule #1 Never send items to player thru this
        //Store castle time and countdown

        if (sender instanceof ConsoleCommandSender) {
            int argLength = args.length;
            if (argLength == 0){
            }
            else if (argLength >= 1){
                if (args[0].equalsIgnoreCase("setup")){
                    modifyTeam.registerTeams(sender);
                    plugin.sheepUUID = plugin.castleSheep.spawn(plugin.sheepLocation).getUniqueId();
                }


            }
        } else if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            int argLength = args.length;
            if (argLength == 0){
            }
            else if (argLength >= 1){
                if (args[0].equalsIgnoreCase("setup")){
                    modifyTeam.registerTeams(sender);
                }
                else if (args[0].equalsIgnoreCase("start")){
                    //plugin.castleSheep.spawn(location).getUniqueId();
                    if (plugin.isCastleRunning) {
                        sender.sendMessage(ChatColor.GREEN + "Countdown is already running");
                    } else {
                        plugin.isCastleRunning = true;
                    }
                    plugin.sheepUUID = plugin.castleSheep.spawn(plugin.sheepLocation).getUniqueId();
                    plugin.sheepMaxHealth = ((LivingEntity)Bukkit.getEntity(plugin.sheepUUID)).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();


                }else if (args[0].equalsIgnoreCase("end")){
                    plugin.isCastleRunning = false;
                }
            }
        } else {
            return false;
        }

        return false;
    }
}
