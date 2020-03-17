package seoss.castlepvpevent;

import net.minecraft.server.v1_15_R1.BlockPosition;
import net.minecraft.server.v1_15_R1.EntityTypes;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


import java.util.UUID;

public final class CastlePvPEvent extends JavaPlugin {


    public ScoreboardManager scoreboardManager;
    public Scoreboard scoreboard;
    //public ScoreboardManager scoreboardManager = Bukkit.getServer().getScoreboardManager();
    //public Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
    public boolean isCastleRunning = false;
    public UUID sheepuuid;
    public final int delay = 3;
    public World world;;
    public Location sheeplocation;
    public CustomEntityType castleSheep = new CustomEntityType<CustomSheep>("castle_sheep", CustomSheep.class, EntityTypes.SHEEP, CustomSheep::new);
    public double sheepmaxhealth;

    @Override
    public void onLoad(){

        //castleSheep.register();
    }

    @Override
    public void onEnable() {
        castleSheep.register();
        PluginManager manager = Bukkit.getServer().getPluginManager();
        manager.registerEvents(new DisableCollision(), this);
        manager.registerEvents(new SheepDamaged(), this);
        this.getCommand("castle").setExecutor(new CastleCommands());
        world = Bukkit.getWorlds().get(0);
        sheeplocation =  new Location(world, 151.5, 76.1, 184.5, 0, 0);
        scoreboardManager = Bukkit.getServer().getScoreboardManager();
        scoreboard = scoreboardManager.getNewScoreboard();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        castleSheep.unregister();
        // Plugin shutdown logic
    }
}
