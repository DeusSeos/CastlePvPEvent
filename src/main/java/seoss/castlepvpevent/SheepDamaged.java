package seoss.castlepvpevent;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

public class SheepDamaged implements Listener {

    public CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!plugin.isCastleRunning) {
        } else {
            Entity entitySheep = e.getEntity();
            if (entitySheep.getUniqueId().equals((plugin.sheepUUID))) {
                if (e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) ||
                        e.getCause().equals(EntityDamageEvent.DamageCause.LIGHTNING) ||
                        e.getCause().equals(EntityDamageEvent.DamageCause.MAGIC) ||
                        e.getCause().equals(EntityDamageEvent.DamageCause.WITHER)) {
                    e.setCancelled(true);
                }

                if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) {
                    e.setCancelled(true);
                    entitySheep.setFireTicks(0);
                } else {
                    e.getEntity().setVelocity(new Vector(0.0,0.0,0.0));
                    Bukkit.getScheduler().runTaskLater(plugin, () -> e.getEntity().setVelocity(new Vector(0.0, 0.0, 0.0)), plugin.delay);
                    Bukkit.getScheduler().runTaskLater(plugin, () -> e.getEntity().teleport(plugin.sheepLocation), plugin.delay);
                    LivingEntity castleSheep = (LivingEntity) entitySheep;
                    double currentHealth = castleSheep.getHealth();
                    double healthBase = plugin.sheepMaxHealth/3.0;

                    if (currentHealth < healthBase) {
                        castleSheep.setCustomName(ChatColor.RED + "Heart <3");
                    }
                    else if (currentHealth >= healthBase && currentHealth < (healthBase*2)) {
                        castleSheep.setCustomName(ChatColor.YELLOW + "Heart <3");
                    }
                    else if (currentHealth > healthBase*2) {
                        castleSheep.setCustomName(ChatColor.GREEN + "Heart <3");
                    }
                }

            } else {

            }
        }
    }
}
