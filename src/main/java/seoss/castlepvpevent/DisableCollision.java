package seoss.castlepvpevent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DisableCollision implements Listener {

    public CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.setCollidable(false);

    }

}
