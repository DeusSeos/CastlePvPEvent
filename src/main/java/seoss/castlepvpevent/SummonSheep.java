package seoss.castlepvpevent;



import net.minecraft.server.v1_15_R1.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Sheep;


public class SummonSheep {

    public CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);


    public Sheep sheep(World world){
        Sheep castleSheep = plugin.world.spawn(plugin.sheepLocation, Sheep.class);
        castleSheep.setBaby();
        castleSheep.setAgeLock(true);
        castleSheep.setCollidable(false);
        castleSheep.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(.9);
        castleSheep.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0);
        castleSheep.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(810);
        castleSheep.setHealth(810);
        return castleSheep;
    }

}
